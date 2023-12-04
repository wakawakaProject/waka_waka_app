package com.example.waka_waka

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.waka_waka.databinding.ActivitySignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.database
import kotlin.math.sign


class SignUpActivity : AppCompatActivity() {
    var checkcomplete : Boolean = true
    val database = Firebase.database
    val myRef = database.getReference("user")
    val auth = FirebaseAuth.getInstance()
    override fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)

        val binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val intent = Intent(this, LoginActivity::class.java)


        with(binding){
            signUpComplete.setOnClickListener{


                if (binding.SignUpPWD.text.toString() == binding.SignUpPWDCheck.text.toString()) {
                    checkcomplete = true
                } else {
                    Toast.makeText(applicationContext, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                    binding.SignUpPWD.text = null
                    binding.SignUpPWDCheck.text = null
                    checkcomplete = false
                }


                Toast.makeText(applicationContext, "회원가입 완료!", Toast.LENGTH_SHORT).show()

                if (checkcomplete) {
                    startActivity(intent)
                }
            }
        }




    }

//    fun  addDataKey(user: User) : String{
//        val dataId = myRef.push().key!!
//        user.dataId = dataId;
//        myRef.child(dataId).setValue(user)
//
//        return dataId;
//    }




}
