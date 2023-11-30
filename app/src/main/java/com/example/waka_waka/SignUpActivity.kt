package com.example.waka_waka

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.waka_waka.databinding.ActivitySignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.database.database


class SignUpActivity : AppCompatActivity() {
    var checkcomplete : Boolean = true
    val database = Firebase.database
    val myRef = database.getReference("user")
    override fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)

        val binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val intent = Intent(this, LoginActivity::class.java)


//
//        constructor(id:String, pw:String, name: String, age: String, phone: String,
//            gender: String, position: String, played_year : String, address : String){
        with(binding){
            signUpComplete.setOnClickListener{
                val user = User(
                    SignUpID.text.toString(),
                    SignUpPWD.text.toString(),
                    SignUpName.text.toString(),
                    20, // 나이를 입력받는 디자인 미완성으로 인해 더미데이터 입력
                    SignUpNumber.text.toString(),
                    SignUpSex.text.toString(),
                    SignUpPosition.text.toString(),
                    SignUpCareer.text.toString(),
                    SignUpAddress.text.toString()
                    )
                addKey(user)

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

    fun addKey(user: User){
        val id = myRef.push().key!!
        user.id = id
        myRef.child(id).setValue(user)
    }
}
