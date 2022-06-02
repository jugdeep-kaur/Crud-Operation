package com.example.myprojectapp

import android.content.Context
import androidx.lifecycle.LiveData

class FoodRepository (context: Context) {


    var db: FoodDao? = FoodDatabase.getInstance(context)?.FoodDao()


    fun getAllFood(): LiveData<List<Food>>? {
        return db?.selectFood()
    }

    fun insertFood(food: Food) {
        db?.insertFood(food)
    }

    fun updateFood(food: Food) {
        db?.updateFood(food)
    }

    fun deleteFood(food: Food) {
        db?.deleteFood(food)
    }
//    fun searchFood(food: Food){
//        db?.searchfOOD(name: String): LiveDATA
//    }
}