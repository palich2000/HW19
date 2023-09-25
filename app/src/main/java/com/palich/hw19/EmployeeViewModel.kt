package com.palich.hw19

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class EmployeeViewModel : ViewModel() {
    private val repo = MyApplication.getApp().repo
    private val _listState = MutableLiveData<ListState>(ListState.EmptyList)
    val listState: LiveData<ListState> = _listState

    private val observer = Observer<List<Employee>> {
        _listState.postValue(ListState.UpdatedList(list = it))
    }

    init {
        repo.getAll().observeForever(observer)
    }

    fun add(name: String, position: String) {
        repo.add(Employee(name = name, position = position))
    }

    fun remove(employee: Employee) {
        repo.remove(employee)
    }

    override fun onCleared() {
        super.onCleared()
        repo.getAll().removeObserver(observer)
    }

    sealed class ListState {
        object EmptyList : ListState()
        class UpdatedList(var list: List<Employee>) : ListState()
    }

}