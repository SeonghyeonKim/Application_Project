package com.example.myapplication

import android.os.Bundle
import android.content.Intent
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val img : ImageView = findViewById(R.id.image_re)
        val nameAge : TextView = findViewById(R.id.nameAge_re)
        val number : TextView = findViewById(R.id.number_re)
        val address : TextView = findViewById(R.id.address_re)
        val extra : TextView = findViewById(R.id.extra_re)

        Toast.makeText(this, "저장 완료", Toast.LENGTH_SHORT).show()

        img.setImageBitmap(intent!!.getParcelableExtra("image"))
        nameAge.text = "이름:" + intent!!.getStringExtra("name").toString() + "나이:" + intent!!.getStringExtra("age").toString()
        number.text = "연락처:" + intent!!.getStringExtra("number").toString()
        address.text = "주소:" + intent!!.getStringExtra("address").toString()
        extra.text = "메모:" + intent!!.getStringExtra("extra").toString()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        System.exit(0)
    }
}