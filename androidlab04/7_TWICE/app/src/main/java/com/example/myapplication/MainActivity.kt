package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.*

var list = arrayOf(R.drawable.a,
    R.drawable.b,
    R.drawable.c,
    R.drawable.d,
    R.drawable.e,
    R.drawable.f,
    R.drawable.g,
    R.drawable.h,
    R.drawable.i,
    R.drawable.j,
    R.drawable.k,
    R.drawable.l,
    R.drawable.m,
    R.drawable.n,
    R.drawable.o,
    R.drawable.p,
    R.drawable.q,
    R.drawable.r,
    R.drawable.s,
    R.drawable.t,
    R.drawable.u,
    R.drawable.v,
    R.drawable.w,
    R.drawable.x,
    R.drawable.y,
    R.drawable.z
)

private var LastClickTime = 0L

class MainActivity : AppCompatActivity() {
    lateinit var img: ImageView
    lateinit var left: Button
    lateinit var right: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "트와이스 갤러리"

        var i = 0

        img = findViewById(R.id.imgView)
        left = findViewById(R.id.Left)
        right = findViewById(R.id.Right)

        img.setImageResource(R.drawable.a)

        left.setOnTouchListener { view, motionEvent ->
            if(SystemClock.elapsedRealtime() - LastClickTime > 100) {
                if (i > 0) i--
                else i = 25
                img.setImageResource(list[i])
            }
            LastClickTime = SystemClock.elapsedRealtime()
            false
        }

        right.setOnTouchListener { view, motionEvent ->
            if(SystemClock.elapsedRealtime() - LastClickTime > 100) {
                if (i < 25) i++
                else i = 0
                img.setImageResource(list[i])

            }
            LastClickTime = SystemClock.elapsedRealtime()
            false
        }
    }
}