package com.example.myprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EntryForm : AppCompatActivity() {
    lateinit var vm : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry_form)


        vm = MainViewModel(application)

        var ffood: EditText = findViewById(R.id.ffood)
        var sfood: EditText = findViewById(R.id.sfood)
        var btnSubmit: Button = findViewById(R.id.btn_submit)
        var cancel:Button = findViewById(R.id.cancel)

        var studentList = ArrayList<RFood>()



//        btnSubmit.setOnClickListener(this)
//        fun validate():Boolean{
//            if (ffood.text.toString().isEmpty()){
//                ffood.text.error = "enter your first favourite food"
//                return false
//            }else if (sfood.text.toString().isEmpty()){
//                sfood.text.error =" Enter your second favourite Food"
//                return false
//            }
//            return true
//        }

        btnSubmit.setOnClickListener {

            vm.insertFood(Food(null,ffood.text.toString(),sfood.text.toString()))
            val myIntent = Intent(this,MainActivity::class.java)
            startActivity(myIntent)
            Toast.makeText(application, "Item inserted", Toast.LENGTH_SHORT).show()

        }

        cancel.setOnClickListener() {
            //vm.deleteFood(Food( foodId = null,ffood.text.toString(),sfood.text.toString()))
            var myIntent = Intent(this,MainActivity::class.java)
            startActivity(myIntent)
            Toast.makeText(application, "Home page", Toast.LENGTH_SHORT).show()

        }
    }
}




