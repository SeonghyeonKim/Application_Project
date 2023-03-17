package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import java.lang.Exception

val GALLERY = 1

class MainActivity : AppCompatActivity() {
    lateinit var bt : Bitmap
    var check = 0

    var a : String? = null
    var b : String? = null
    var c : String? = null
    var d : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.btn_main)
        val kname : EditText = findViewById(R.id.kname_main)
        val ename : EditText = findViewById(R.id.ename_main)
        val num : EditText = findViewById(R.id.num_main)
        val email : EditText = findViewById(R.id.mail_main)
        val address : EditText = findViewById(R.id.add_main)
        val img : ImageView = findViewById(R.id.img_main)
        img.isClickable = true

        img.setOnClickListener {
            openGallery()
        }

        btn.setOnClickListener {
            if(check == 0 ) return@setOnClickListener

            val intent = Intent(this, SubActivity::class.java)
            val resize = resizeBitmap(bt, 300, 300)
            intent.putExtra("image", resize)
            intent.putExtra("kname", kname.text.toString())
            intent.putExtra("ename", ename.text.toString())
            intent.putExtra("address", address.text.toString())
            intent.putExtra("number", num.text.toString())
            intent.putExtra("email", email.text.toString())

            intent.putExtra("a", a)
            intent.putExtra("b", b)
            intent.putExtra("c", c)
            intent.putExtra("d", d)

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
                        val pt: ImageView = findViewById(R.id.img_main)
                        pt.setImageBitmap(resizeBitmap(bitmap,300,300))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                100 -> {
                    a = data!!.getStringExtra("a").toString()
                    b = data!!.getStringExtra("b").toString()
                    c = data!!.getStringExtra("c").toString()
                    d = data!!.getStringExtra("d").toString()
                }
            }
        }
    }
}