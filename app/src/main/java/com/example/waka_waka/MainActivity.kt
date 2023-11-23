package com.example.waka_waka

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

import com.example.waka_waka.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val waitTimeMillis: Long = 2000    //기다리는 시간 2초 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(binding.root)

        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }, waitTimeMillis)
    }
}