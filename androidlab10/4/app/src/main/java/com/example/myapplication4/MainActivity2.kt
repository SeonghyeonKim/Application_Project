package com.example.myapplication4

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    lateinit var option: SharedPreferences
    lateinit var userInfo: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        option = getSharedPreferences("option", MODE_PRIVATE)
        userInfo = getSharedPreferences("user_info", MODE_PRIVATE)

        var str = """User Name: ${userInfo.getString("name", "NULL")}
            |
            |Alarm On/Off: ${boolToText(option.getBoolean("alarm", false))}
        """.trimMargin()

        textview.text = str
    }

    fun boolToText(check: Boolean): String {
        return when(check) {
            true -> "On"
            false -> "Off"
        }
    }
}