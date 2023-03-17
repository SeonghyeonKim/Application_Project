package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val img : ImageView = findViewById(R.id.img_sub)
        val btn : Button = findViewById(R.id.btn_sub)
        val kname : TextView = findViewById(R.id.kname_sub)
        val ename : TextView = findViewById(R.id.ename_sub)
        val num : TextView = findViewById(R.id.num_sub)
        val email : TextView = findViewById(R.id.mail_sub)
        val address : TextView = findViewById(R.id.add_sub)

        val a : EditText = findViewById(R.id.a_sub)
        val b : EditText = findViewById(R.id.b_sub)
        val c : EditText = findViewById(R.id.c_sub)
        val d : EditText = findViewById(R.id.d_sub)

        val bit : Bitmap? = intent!!.getParcelableExtra("image")

        img.setImageBitmap(intent!!.getParcelableExtra("image"))
        kname.text = intent!!.getStringExtra("kname").toString()
        ename.text = intent!!.getStringExtra("ename").toString()
        num.text = intent!!.getStringExtra("number").toString()
        address.text = intent!!.getStringExtra("address").toString()
        email.text = intent!!.getStringExtra("email").toString()

        a.setText(intent!!.getStringExtra("a").toString())
        b.setText(intent!!.getStringExtra("b").toString())
        c.setText(intent!!.getStringExtra("c").toString())
        d.setText(intent!!.getStringExtra("d").toString())

        if(a.text.toString() == "null") a.setText("")
        if(b.text.toString() == "null") b.setText("")
        if(c.text.toString() == "null") c.setText("")
        if(d.text.toString() == "null") d.setText("")

        btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("a", a.text.toString())
            intent.putExtra("b", b.text.toString())
            intent.putExtra("c", c.text.toString())
            intent.putExtra("d", d.text.toString())
            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }
}