package com.example.waka_waka

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.waka_waka.databinding.ActivityLoginBinding
import com.example.waka_waka.databinding.ActivitySignUpBinding

var checkcomplete : Boolean = true
class SignUpActivity : AppCompatActivity() {
    override fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)

        val binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val intent = Intent(this, LoginActivity::class.java)

        binding.signUpComplete.setOnClickListener {
            if (binding.SignUpPWD.text.toString() == binding.SignUpPWDCheck.text.toString()) {
                checkcomplete = true
            } else {
                Toast.makeText(applicationContext, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                binding.SignUpPWD.text = null
                binding.SignUpPWDCheck.text = null
                checkcomplete = false
            }
            if (checkcomplete) {
                startActivity(intent)
            }
        }
    }
}
