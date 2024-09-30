package com.superstudio.flagquizgame.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.superstudio.flagquizgame.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
            Thread.sleep(3000L)
            setContentView(R.layout.activity_main)
        }
    }
