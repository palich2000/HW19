package com.palich.hw19

import android.app.Application
import android.os.Trace
import androidx.annotation.NonNull
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

class MyApplication: Application(){
    lateinit var repo:EmployeeRepository
    companion object{
        private lateinit var instance: MyApplication
        fun getApp() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        val db = Room.databaseBuilder(context=this, klass =EmployeeDataBase::class.java, "employee_database1")
        .build()
        repo = EmployeeRepository(db)
    }

}