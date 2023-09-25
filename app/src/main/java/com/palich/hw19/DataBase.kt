package com.palich.hw19

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDataBase:RoomDatabase() {
    abstract fun employeeDao():EmployeeDao
}