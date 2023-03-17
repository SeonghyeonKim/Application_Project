package com.example.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val img : ImageView = findViewById(R.id.image_sub)
        val btn1 : Button = findViewById(R.id.btn1_sub)
        val btn2 : Button = findViewById(R.id.btn2_sub)
        val nameAge : TextView = findViewById(R.id.nameAge_sub)
        val number : TextView = findViewById(R.id.number_sub)
        val address : TextView = findViewById(R.id.address_sub)
        val extra : TextView = findViewById(R.id.extra_sub)

        val bit : Bitmap? = intent!!.getParcelableExtra("image")
        val name : String? = intent!!.getStringExtra("name").toString()
        val age : String? = intent!!.getStringExtra("age").toString()

        img.setImageBitmap(intent!!.getParcelableExtra("image"))
        nameAge.text = "이름:" + intent!!.getStringExtra("name").toString() + " 나이:" + intent!!.getStringExtra("age").toString()
        number.text = "연락처" + intent!!.getStringExtra("number").toString()
        address.text = "주소" + intent!!.getStringExtra("address").toString()
        extra.text = "메모" + intent!!.getStringExtra("extra").toString()

        btn1.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("image", bit)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            intent.putExtra("address", address.text.toString())
            intent.putExtra("number", number.text.toString())
            intent.putExtra("extra", extra.text.toString())
            startActivityForResult(intent, 100)
        }

        btn2.setOnClickListener {
            finish()
        }
    }
}