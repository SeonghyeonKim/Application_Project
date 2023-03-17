package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var linLayer : LinearLayout
    lateinit var button: Button
    var temp: Int = 1

    private var LastClickTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "직접해보기 1번 문제"

        button = findViewById(R.id.But)

        linLayer = findViewById(R.id.LinLay)

        button.setOnTouchListener { view, motionEvent ->
            if(SystemClock.elapsedRealtime() - LastClickTime > 100) {
                when (temp) {
                    0 -> linLayer.setBackgroundColor(Color.parseColor("#FF0000"))
                    1 -> linLayer.setBackgroundColor(Color.parseColor("#00FF00"))
                    2 -> linLayer.setBackgroundColor(Color.parseColor("#0000FF"))
                }
                temp = (temp + 1) % 3
            }
            LastClickTime = SystemClock.elapsedRealtime()
            false
        }

    }
}
