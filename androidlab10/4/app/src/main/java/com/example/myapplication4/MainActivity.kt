package com.example.myapplication4

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var option: SharedPreferences
    lateinit var userInfo: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        option = getSharedPreferences("option", MODE_PRIVATE)
        userInfo = getSharedPreferences("user_info", MODE_PRIVATE)

        vBtnSave.setOnClickListener {
            userInfo.edit {
                putString("name", vEditName.text.toString())
                vEditName.setText(null)
            }
            Toast.makeText(this, "저장", Toast.LENGTH_SHORT).show()
        }

        vSwitchAlarm.setOnCheckedChangeListener {compoundButton, b ->
            option.edit {
                putBoolean("alarm", vSwitchAlarm.isChecked)
            }
        }

        vBtnMoveActivity.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        saveValueLoad()
        super.onStart()
    }

    private fun saveValueLoad() {
        vEditName.setText(userInfo.getString("name", ""))

        vSwitchAlarm.isChecked = option.getBoolean("alarm", false)
    }
}