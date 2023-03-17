package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn : Button = findViewById(R.id.btn_main)
        val name : EditText = findViewById(R.id.name_main)
        val age : EditText = findViewById(R.id.age_main)
        val address : EditText = findViewById(R.id.address_main)
        val number : EditText = findViewById(R.id.number_main)
        val extra : EditText = findViewById(R.id.extra_main)

        btn.setOnClickListener{
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("name", name.text.toString())
            intent.putExtra("age", age.text.toString())
            intent.putExtra("address", address.text.toString())
            intent.putExtra("number", number.text.toString())
            intent.putExtra("extra", extra.text.toString())
            startActivityForResult(intent, 100)
            name.text = null
            age.text = null
            address.text = null
            number.text = null
            extra.text = null
        }
    }
}