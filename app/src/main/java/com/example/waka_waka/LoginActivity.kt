package com.example.waka_waka

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.waka_waka.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.tabs.TabLayout
import com.google.firebase.Firebase
import com.google.firebase.database.database

public class LoginActivity : AppCompatActivity() {

    val database = Firebase.database
    val ref = database.getReference("user")
    override fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 구글 소셜로그인 구현부분 (추후 PUSH 예정)
        /*
        var setInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId("755533939759-msu2nh9hcla4euaccq95c7e64lkbgkei.apps.googleusercontent.com")
                    .setFilterByAuthorizedAccounts(true)
                    .build()
            )
*/


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