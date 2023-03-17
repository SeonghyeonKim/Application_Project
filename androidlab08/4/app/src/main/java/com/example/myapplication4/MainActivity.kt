package com.example.myapplication4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication4.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.activityMain)

        val channel = Channel<Int>()
        val backgroundScope = CoroutineScope(Dispatchers.Default + Job())

        backgroundScope.launch {
            var s = 0
            var flag = 0

            binding.start.setOnClickListener {
                if(flag==0) flag = 1
            }

            binding.stop.setOnClickListener {
                if(flag==1) flag = 0
            }

            binding.pause.setOnClickListener {
                if(flag==1) flag = 2
            }

            binding.resume.setOnClickListener {
                if(flag==2) flag = 1
            }


            for(i in 1..86400) {
                delay(1000)
                when(flag) {
                    0-> s=0
                    1-> s++
                    2-> s=s
                }

                channel.send(s)
            }
        }

        val mainScope = GlobalScope.launch(Dispatchers.Main) {
            channel.consumeEach {
                val df = DecimalFormat("00")

                var h = df.format(it/3600)
                var m = df.format(it/60%60)
                var s = df.format(it%60)

                binding.resultView.text = "$h:$m:$s"
            }
        }
    }
}