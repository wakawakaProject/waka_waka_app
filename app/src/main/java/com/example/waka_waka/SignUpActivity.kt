package com.example.waka_waka

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.waka_waka.databinding.ActivityLoginBinding
import com.example.waka_waka.databinding.ActivitySignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.database.database
import kotlin.math.sign


class SignUpActivity : AppCompatActivity() {
    var checkcomplete : Boolean = true
    val auth = FirebaseAuth.getInstance()
    val database = Firebase.database
    val userRef = database.getReference("user")
    override fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)

        val binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val intent = Intent(this, LoginActivity::class.java)


        with(binding){
            signUpComplete.setOnClickListener{
                var user:User = User(
                    binding.SignUpEmail.text.toString(),
                    binding.SignUpName.text.toString(),
                    20,
                    binding.SignUpNumber.text.toString(),
                    binding.SignUpSex.text.toString(),
                    binding.SignUpPosition.text.toString(),
                    binding.SignUpCareer.text.toString(),
                    binding.SignUpAddress.text.toString()
                )
                addKey(user) // firebase DB에 키 값 생성과 함께 저장
                signUp(binding, intent) // firebase auth에 email과 pw로 계정 생성

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
    // firebase auth 연동으로 email, pw 회원가입
    fun signUp(binding: ActivitySignUpBinding, intent: Intent){
        var inputEmail = binding.SignUpEmail.text.toString()
        var inputPw = binding.SignUpPWD.text.toString()

        auth?.createUserWithEmailAndPassword(inputEmail, inputPw)
            ?.addOnCompleteListener{
                    task ->
                if (task.isSuccessful){
                    //정상적으로 이메일과 비번이 전달되어
                    //새 유저 계정을 생성과 서버db 저장 완료 및 로그인
                    //즉, 기존에 있는 계정이 아니다!
                    moveLoginActivity(task.result?.user)
                }else if (task.exception?.message.isNullOrEmpty() == false){
                    //예외메세지가 있다면 출력
                    //에러가 났다거나 서버가 연결이 실패했다거나
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                }else{
                    //여기가 실행되는 경우는 이미 db에 해당 이메일과 패스워드가 있는 경우
                    //그래서 계정 생성이 아닌 토스트 메시지 출력
                    Toast.makeText(this, "이미 존재하는 계정입니다", Toast.LENGTH_SHORT).show()
                }

            }
    }

    private fun moveLoginActivity(user: FirebaseUser?) {
        if (user!=null){
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
    private fun addKey(user:User){
        val id = userRef.push().key!!
        user.dataId = id
        userRef.child(id).setValue(user)
    }



}
