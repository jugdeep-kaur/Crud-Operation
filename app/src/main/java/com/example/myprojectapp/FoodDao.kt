package com.example.myprojectapp

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FoodDao {
    ///CRUD STATEMENTS
    //create
    @Insert
    fun insertFood(food: Food)


    //Read
    @Query("select * from food")
    fun selectFood(): LiveData<List<Food>>?


    //update
    @Update
    fun updateFood(food: Food)

    //Delete
    @Delete
    fun deleteFood(food: Food)

    @Query("select * from food where ffood like :name OR sfood like:name")
    fun search(name:String):LiveData<List<Food>>


//    @Query
//    fun searchFood(food: Food)
////    @Query("select * from food where ffood like  or sfood like ")
//    fun searchfood(searchText:String):LiveData<List<Food>>

//    @Query( "delete from students where firstname like :fname")
//      fun deleteAll(fname:String)
////  fun deleteAll(students: Students)

}