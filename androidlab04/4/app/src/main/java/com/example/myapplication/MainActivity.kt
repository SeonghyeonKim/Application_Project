package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText
    lateinit var edit2 : EditText
    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMul : Button
    lateinit var btnDiv : Button
    lateinit var textResult : TextView
    lateinit var num1 : String
    lateinit var num2 : String
    var result : Int? = null
    var cnt = 0

    fun updateTitle() {
        title = "${cnt}회 계산기"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "${cnt}회 계산기"

        edit1 = findViewById(R.id.Edit1)
        edit2 = findViewById(R.id.Edit2)

        btnAdd = findViewById(R.id.BtnAdd)
        btnSub = findViewById(R.id.BtnSub)
        btnMul = findViewById(R.id.BtnMul)
        btnDiv = findViewById(R.id.BtnDiv)
        textResult = findViewById(R.id.TextResult)

        btnAdd.setOnTouchListener { view, motionEvent ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) + Integer.parseInt(num2)
                textResult.text = "계산 결과 : " + result.toString()

                updateTitle()
            }
            catch(e: Exception) {
                textResult.text = "에러"
            }
            false}

        btnSub.setOnTouchListener { view, motionEvent ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) - Integer.parseInt(num2)
                textResult.text = "계산 결과 : " + result.toString()

                updateTitle()
            }
            catch(e: Exception) {
                textResult.text = "에러"
            }
            false}

        btnMul.setOnTouchListener { view, motionEvent ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) * Integer.parseInt(num2)
                textResult.text = "계산 결과 : " + result.toString()

                updateTitle()
            }
            catch(e: Exception) {
                textResult.text = "에러"
            }
            false}

        btnDiv.setOnTouchListener { view, motionEvent ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) / Integer.parseInt(num2)
                textResult.text = "계산 결과 : " + result.toString()

                updateTitle()
            }
            catch(e: Exception) {
                textResult.text = "에러"
            }
            false
        }
    }
}
