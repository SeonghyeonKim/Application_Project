package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var linLayer : LinearLayout
    lateinit var but1: Button
    lateinit var but2: Button
    lateinit var but3: Button
    lateinit var but4: Button
    lateinit var but5: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "직접해보기 6번 문제"

        but1 = findViewById(R.id.But1)
        but2 = findViewById(R.id.But2)
        but3 = findViewById(R.id.But3)
        but4 = findViewById(R.id.But4)
        but5 = findViewById(R.id.But5)

        but1.setOnTouchListener { view, motionEvent ->
            but1.visibility = View.INVISIBLE
            but2.visibility = View.VISIBLE
            false
        }

        but2.setOnTouchListener { view, motionEvent ->
            but2.visibility = View.INVISIBLE
            but3.visibility = View.VISIBLE
            false
        }

        but3.setOnTouchListener { view, motionEvent ->
            but3.visibility = View.INVISIBLE
            but4.visibility = View.VISIBLE
            false
        }

        but4.setOnTouchListener { view, motionEvent ->
            but4.visibility = View.INVISIBLE
            but5.visibility = View.VISIBLE
            false
        }

        but5.setOnTouchListener { view, motionEvent ->
            but5.visibility = View.INVISIBLE
            but1.visibility = View.VISIBLE
            false
        }
    }
}
