package com.palich.hw19

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EmployeeDao {
    @Insert
    fun add(employee: Employee):Long
    {
        return 0
    }

    @Delete
    fun delete(employee: Employee)

    @Query("SELECT * FROM employee")
    fun getAll():LiveData<List<Employee>>

}