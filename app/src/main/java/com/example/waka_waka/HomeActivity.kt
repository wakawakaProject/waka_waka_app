package com.example.waka_waka

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.waka_waka.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.matchMaking.setOnClickListener {
            val intent = Intent(applicationContext, CreateMatchActivity::class.java)
            startActivity(intent)
        }
    }
}