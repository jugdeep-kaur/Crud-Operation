package com.example.myprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class updateForm : AppCompatActivity() {

    lateinit var vm : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_form)
        vm =MainViewModel(application)

        var id : TextView = findViewById(R.id.id_t)
        var ffood : TextView = findViewById(R.id.ffood)
        var sfood : TextView = findViewById(R.id.sfood)
        var update : Button = findViewById(R.id.update_t)
        var cancel: Button = findViewById(R.id.cancel_button)

        //id.setText((intent.getIntExtra("id",0).toString()))
        ffood.setText(intent.getStringExtra("ffood"))
        sfood.setText(intent.getStringExtra("sfood"))


        update.setOnClickListener {
            vm.updateFood(Food(id.text.toString().toInt(),ffood.text.toString(),sfood.text.toString()))
            var myIntent = Intent(this,MainActivity::class.java)
            startActivity(myIntent)
            Toast.makeText(application, "item updated", Toast.LENGTH_SHORT).show()

        }

      cancel.setOnClickListener() {
         // vm.deleteFood(Food(fid.text.toString().toInt(), ffood.text.toString(),sfood.text.toString()))
          var myIntent = Intent(this,MainActivity::class.java)
          startActivity(myIntent)
          Toast.makeText(application, "moving to home", Toast.LENGTH_SHORT).show()

      }


    }
}

