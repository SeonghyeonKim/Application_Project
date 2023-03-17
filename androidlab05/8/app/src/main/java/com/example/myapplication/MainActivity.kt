package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var text: EditText
    lateinit var b0: Button
    lateinit var b1: Button
    lateinit var b2: Button
    lateinit var b3: Button
    lateinit var b4: Button
    lateinit var b5: Button
    lateinit var b6: Button
    lateinit var b7: Button
    lateinit var b8: Button
    lateinit var b9: Button
    lateinit var bst: Button
    lateinit var bsh: Button
    lateinit var back: ImageButton
    var num = ""
    var cnt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.text)
        b0 = findViewById(R.id.b0)
        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4 = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6 = findViewById(R.id.b6)
        b7 = findViewById(R.id.b7)
        b8 = findViewById(R.id.b8)
        b9 = findViewById(R.id.b9)
        back = findViewById(R.id.back)

        bst = findViewById(R.id.bst)
        bsh = findViewById(R.id.bsh)

        fun update() {
            text.setText(num)
        }

        b0.setOnClickListener { view ->
            if(cnt%5==3) {
                cnt+=2
                num = num + "-0"
            }
            else {
                cnt++
                num = num + "0"
            }

            update()
        }

        b1.setOnClickListener { view ->
            if(cnt%5==3) {
                cnt+=2
                num = num + "-1"
            }
            else {
                cnt++
                num = num + "1"
            }

            update()
        }

        b2.setOnClickListener { view ->
            if(cnt%5==3) {
                cnt+=2
                num = num + "-2"
            }
            else {
                cnt++
                num = num + "2"
            }

            update()
        }

        b3.setOnClickListener { view ->
            if(cnt%5==3) {
                cnt+=2
                num = num + "-3"
            }
            else {
                cnt++
                num = num + "3"
            }

            update()
        }

        b4.setOnClickListener { view ->
            if(cnt%5==3) {
                cnt+=2
                num = num + "-4"
            }
            else {
                cnt++
                num = num + "4"
            }

            update()
        }

        b5.setOnClickListener { view ->
            if(cnt%5==3) {
                cnt+=2
                num = num + "-5"
            }
            else {
                cnt++
                num = num + "5"
            }

            update()
        }

        b6.setOnClickListener { view ->
            if(cnt%5==3) {
                cnt+=2
                num = num + "-6"
            }
            else {
                cnt++
                num = num + "6"
            }

            update()
        }

        b7.setOnClickListener { view ->
            if(cnt%5==3) {
                cnt+=2
                num = num + "-7"
            }
            else {
                cnt++
                num = num + "7"
            }

            update()
        }

        b8.setOnClickListener { view ->
            if(cnt%5==3) {
                cnt+=2
                num = num + "-8"
            }
            else {
                cnt++
                num = num + "8"
            }

            update()
        }

        b9.setOnClickListener { view ->
            if(cnt%5==3) {
                cnt+=2
                num = num + "-9"
            }
            else {
                cnt++
                num = num + "9"
            }

            update()
        }

        back.setOnClickListener { view ->
            if(cnt>0) {
                num = num.substring(0, num.length-1)
                cnt--
                if(cnt>1) {
                    if (num[num.length - 1] == '-') {
                        num = num.substring(0, num.length - 1)
                        cnt--
                    }
                }
            }
            update()
        }

        bsh.setOnClickListener { view ->
            if(cnt%5==3) {
                cnt+=2
                num = num + "-#"
            }
            else {
                cnt++
                num = num + "#"
            }

            update()
        }

        bst.setOnClickListener { view ->
            if(cnt%5==3) {
                cnt+=2
                num = num + "-*"
            }
            else {
                cnt++
                num = num + "*"
            }

            update()
        }
    }
}