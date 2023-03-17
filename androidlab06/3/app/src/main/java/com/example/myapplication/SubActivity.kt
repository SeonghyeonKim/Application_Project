package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val btn : Button = findViewById(R.id.btn_sub)
        val nameAge : TextView = findViewById(R.id.nameAge_sub)
        val number : TextView = findViewById(R.id.number_sub)
        val address : TextView = findViewById(R.id.address_sub)
        val extra : TextView = findViewById(R.id.extra_sub)

        nameAge.text = intent!!.getStringExtra("name").toString() + " ,  " + intent!!.getStringExtra("age").toString()
        number.text = intent!!.getStringExtra("number").toString()
        address.text = intent!!.getStringExtra("address").toString()
        extra.text = intent!!.getStringExtra("extra").toString()

        btn.setOnClickListener{
            finish()
        }
    }
}