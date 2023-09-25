package com.palich.hw19

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.FieldPosition

@Entity(tableName = "employee")
data class Employee(@PrimaryKey(autoGenerate = true) val id: Int?=null, val name: String, val position: String)