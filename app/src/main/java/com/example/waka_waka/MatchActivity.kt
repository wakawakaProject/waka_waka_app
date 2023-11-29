package com.example.waka_waka

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.waka_waka.databinding.ActivityMatchCreateBinding

class MatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val binding = ActivityMatchCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
    }
}