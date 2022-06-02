package com.example.myprojectapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
data class Food(@PrimaryKey() var foodId: Int?,
                    @ColumnInfo(name="ffood") val ffood:String?,
                    @ColumnInfo(name="sfood") var sfood: String?)

