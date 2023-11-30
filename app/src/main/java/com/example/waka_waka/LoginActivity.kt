package com.example.waka_waka

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.waka_waka.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.database.database

class LoginActivity : AppCompatActivity() {

    val database = Firebase.database
    val binding = ActivityLoginBinding.inflate(layoutInflater)
    override fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)
        setContentView(binding.root)

        binding.signUp.setOnClickListener{
            val signUpintent = Intent(this, SignUpActivity::class.java)
            startActivity(signUpintent)
        }
        binding.login.setOnClickListener{
            val homeIntent = Intent(this,HomeActivity::class.java)
            startActivity(homeIntent)
        }

    }
}