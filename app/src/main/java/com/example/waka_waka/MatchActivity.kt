package com.example.waka_waka

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.waka_waka.databinding.ActivityMatchBinding

class MatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
    }
}