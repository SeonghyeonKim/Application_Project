package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import java.lang.Exception

val GALLERY = 100

class MainActivity : AppCompatActivity() {
    lateinit var bt : Bitmap
    var check = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.btn_main)
        val name : EditText = findViewById(R.id.name_main)
        val age : EditText = findViewById(R.id.age_main)
        val address : EditText = findViewById(R.id.address_main)
        val number : EditText = findViewById(R.id.number_main)
        val extra : EditText = findViewById(R.id.extra_main)
        val img : ImageView = findViewById(R.id.image)
        img.isClickable = true

        img.setOnClickListener {
            openGallery()
        }

        btn.setOnClickListener{
            if(check == 0) return@setOnClickListener

            val intent = Intent(this, SubActivity::class.java)
            val resize = resizeBitmap(bt, 300, 300)
            intent.putExtra("image", resize)
            intent.putExtra("name", name.text.toString())
            intent.putExtra("age", age.text.toString())
            intent.putExtra("address", address.text.toString())
            intent.putExtra("number", number.text.toString())
            intent.putExtra("extra", extra.text.toString())
            startActivityForResult(intent, 100)
        }
    }

    private fun openGallery() {
        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, GALLERY)
    }

    private fun resizeBitmap(bitmap: Bitmap, width:Int, height:Int): Bitmap? {
        return Bitmap.createScaledBitmap(
            bitmap, width, height, false
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK) {
            when(requestCode) {
                GALLERY-> {
                    var ImageData: Uri? = data?.data
                    try{
                        val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImageData)
                        bt = bitmap
                        check = 1
                        val pt: ImageView = findViewById(R.id.image)
                        pt.setImageBitmap(resizeBitmap(bitmap,300,300))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }
}




