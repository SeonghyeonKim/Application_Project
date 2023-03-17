package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.ArithmeticException
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText
    lateinit var edit2 : EditText
    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMul : Button
    lateinit var btnDiv : Button
    lateinit var btnRest : Button
    lateinit var btnEx : Button
    lateinit var textResult : TextView
    lateinit var num1 : String
    lateinit var num2 : String
    var result : Int? = null
    var cnt = 0

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
        btnRest = findViewById(R.id.BtnRest)
        btnEx = findViewById(R.id.BtnEx)
        textResult = findViewById(R.id.TextResult)


        fun updateTitle() {
            cnt++
            title = "${cnt}회 계산기"
            edit1.setText(result.toString())
            edit2.text = null
            textResult.text = "계산 결과 : " + result.toString()
            result = null
        }

        btnAdd.setOnClickListener { view ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) + Integer.parseInt(num2)

                updateTitle()
            }
            catch(e: Exception) {
                textResult.text = "에러 : 숫자없음"
            }
            false
        }

        btnSub.setOnClickListener { view ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) - Integer.parseInt(num2)

                updateTitle()
            }
            catch(e: Exception) {
                textResult.text = "에러 : 숫자없음"
            }
            false
        }

        btnMul.setOnClickListener { view ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) * Integer.parseInt(num2)

                updateTitle()
            }
            catch(e: Exception) {
                textResult.text = "에러 : 숫자없음"
            }
            false
        }

        btnDiv.setOnClickListener { view ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) / Integer.parseInt(num2)

                updateTitle()
            }
            catch(e: ArithmeticException) {
                textResult.text = "에러 : 0으로 나눔"
            }
            catch(e: Exception) {
                textResult.text = "에러 : 숫자없음"
            }
            false
        }

        btnRest.setOnClickListener { view ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                result = Integer.parseInt(num1) % Integer.parseInt(num2)

                updateTitle()
            }
            catch(e: ArithmeticException) {
                textResult.text = "에러 : 0으로 나눔"
            }
            catch(e: Exception) {
                textResult.text = "에러 : 숫자없음"
            }
            false
        }

        btnEx.setOnClickListener { view ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                Integer.parseInt(num1) + Integer.parseInt(num2)
                edit1.setText(num2)
                edit2.setText(num1)

                textResult.text = "계산 결과 :"
            }
            catch(e: Exception) {
                textResult.text = "에러 : 숫자없음"
            }
            false
        }
    }
}
