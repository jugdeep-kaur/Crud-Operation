package com.example.myprojectapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(app: Application): AndroidViewModel(app) {

    private val repo: FoodRepository
    val allFood: LiveData<List<Food>>?

    init {
        repo = FoodRepository(app)
        allFood = repo.getAllFood()
    }

    fun getAllFood() = viewModelScope.launch {
        repo.getAllFood()
    }

    fun insertFood(food: Food) = viewModelScope.launch {
        repo.insertFood(food)
    }

    fun updateFood(food: Food) = viewModelScope.launch {
        repo.updateFood(food)
    }

    fun deleteFood(food: Food) = viewModelScope.launch {
        repo.deleteFood(food)


    }
//    fun search(searchText :String)=viewModelScope.launch{
//        repo.getAllFood()
//    }
}

