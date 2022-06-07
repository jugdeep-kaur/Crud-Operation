package com.example.myprojectapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
data class Food(@PrimaryKey(autoGenerate = true) var foodId: Int? = 0,
                    @ColumnInfo(name="ffood") val ffood:String?,
                    @ColumnInfo(name="sfood") var sfood: String?)

