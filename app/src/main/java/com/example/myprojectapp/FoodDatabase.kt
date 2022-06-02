package com.example.myprojectapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Food::class], version = 1, exportSchema = false)
//3
abstract class FoodDatabase : RoomDatabase(){
    //4 abstract and return Dao
    abstract fun FoodDao():FoodDao
    //5 Singleton
    companion object{
        var INSTANCE: FoodDatabase? = null
        fun getInstance(context: Context):FoodDatabase?{
            if (INSTANCE == null){

                //6 -we are acquiring an instance of RoomDB builder
                synchronized(FoodDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        FoodDatabase::class.java,"food.db")
                        .allowMainThreadQueries().build()
                }
            }

            return INSTANCE
        }
        fun destroyInstance(){
            INSTANCE =null
        }
    }

}
