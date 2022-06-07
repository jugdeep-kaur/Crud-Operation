package com.example.myprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {


    lateinit var foodList : ArrayList<Food>
    lateinit var vm :MainViewModel
    lateinit var adapter: FoodAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = MainViewModel(application)

        foodList = ArrayList()
var loader: ProgressBar = findViewById(R.id.loader)

// add button insert button
        var addBtn: FloatingActionButton = findViewById(R.id.plusBtn)
        val recyclerView: RecyclerView =findViewById(R.id.recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = FoodAdapter({position -> onCardClick(position)},foodList)

        recyclerView.adapter =adapter
        addBtn.setOnClickListener {
            loader.visibility = View.VISIBLE
            val intentEntryForm = Intent(this, EntryForm::class.java)
            startActivity(intentEntryForm)


        }
//********************SearchBar****************************************************
//        var searchbar: EditText =findViewById(R.id.search_bar)
//       // foodList = vm.getAllFood().toString()
//        searchbar.addTextChangedListener(object :TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                var searchText =searchbar.text.toString()
//                foodList = if (searchText==" "){
//                    vm.getAllFood()
//                }else{
//                    vm.search(searchText)
//                }
//                adapter = FoodAdapter({position -> onCardClick(position)},foodList)
//                recyclerView.adapter = adapter
//            }
//
//        })








//add button
//        var plusBtn: View = findViewById(R.id.plusBtn)
//
//        plusBtn.setOnClickListener() {
//            val intentEntryForm = Intent(this,StudentEntryForm::class.java)
//            this.startActivity(intentEntryForm)
//        }
        vm.allFood?.observe(this) {
                foodList ->  getFood(foodList)
        }


    }


    fun onCardClick(poisition:Int){

        println("position:::$poisition")
        val myIntent = Intent(this,updateForm::class.java)
        myIntent.putExtra("Id",foodList[poisition].foodId)
        myIntent.putExtra("Ffood",foodList[poisition].ffood)
        myIntent.putExtra("sfood",foodList[poisition].sfood)
        startActivity(myIntent)
    }

    private fun getFood(foodList: List<Food>){
        this.foodList.clear()
        this.foodList.addAll(foodList)
        adapter.notifyDataSetChanged()
    }
}


