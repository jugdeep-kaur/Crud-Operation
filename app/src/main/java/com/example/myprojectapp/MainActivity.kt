package com.example.myprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.EditText
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



// add button insert button
        var addBtn: FloatingActionButton = findViewById(R.id.plusBtn)
        val recyclerView: RecyclerView =findViewById(R.id.recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = FoodAdapter({position -> onCardClick(position)},foodList)

        recyclerView.adapter =adapter
        addBtn.setOnClickListener {
            val intentEntryForm = Intent(this, EntryForm::class.java)
            startActivity(intentEntryForm)


        }
//
//        var searchbar: EditText =findViewById(R.id.search_bar)
//        foodList = vm.getAllFood().toString()
//        searchbar.addTextChangedListener(object :TextWatcher){
//
//
//        }





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


