package com.example.waka_waka

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.waka_waka.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)

        val binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.signUp.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}