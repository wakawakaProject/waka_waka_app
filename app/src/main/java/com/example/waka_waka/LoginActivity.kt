package com.example.waka_waka

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.waka_waka.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

public class LoginActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    override fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)
        auth = FirebaseAuth.getInstance()
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var signUpintent = Intent(this, SignUpActivity::class.java)
        var homeIntent = Intent(this,HomeActivity::class.java)


        binding.signUp.setOnClickListener{
            startActivity(signUpintent)
        }
        binding.loginBtn.setOnClickListener {
            signIn(binding, homeIntent)
        }

    }
//    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount?) {
//        //구글로부터 로그인된 사용자의 정보(Credentail)을 얻어온다.
//        val credential = GoogleAuthProvider.getCredential(account?.idToken!!, null)
//        //그 정보를 사용하여 Firebase의 auth를 실행한다.
//        auth?.signInWithCredential(credential)
//            ?.addOnCompleteListener {  //통신 완료가 된 후 무슨일을 할지
//                    task ->
//                if (task.isSuccessful) {
//                    // 로그인 처리를 해주면 됨!
//                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
//                } else {
//                    // 오류가 난 경우!
//                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
//                }
//               // progressBar.visibility = View.GONE
//            }
//    }
//
//    //startAcivityResult()로 인해 다른 앱/ 액티비티가 실행된 후.
//    //그 앱/액티비티의 작업이 끝나서 다시 이 액티비티로 돌아왔을 떄 할일
//    override fun onActivityResult(requestCode:Int, resultCode: Int, data: Intent?){
//        //Activity.Result_OK : 정상완료
//        //Activity.Result_CANCEL : 중간에 취소 되었음(실패)
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode==1004){
//            if(resultCode == Activity.RESULT_OK){
//                //결과 Intent(data 매개변수) 에서 구글로그인 결과 꺼내오기
//                val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data!!)!!
//
//                //정상적으로 로그인되었다면
//                if(result.isSuccess){
//                    //우리의 Firebase 서버에 사용자 이메일정보보내기
//                    val account = result.signInAccount
//                    firebaseAuthWithGoogle(account)
//                    Toast.makeText(this, "google login success", Toast.LENGTH_SHORT).show()
//                }
//                Toast.makeText(this, "failed to login with google", Toast.LENGTH_SHORT).show()
//
//            }
//        }
//    }
//
//
//    private fun googleLogin() {
//        //1. 구글로 로그인을 한다.
//        val signInIntent = googleSignInClient.signInIntent
//        startActivityForResult(signInIntent, 1004)
//    }





    // email, pw 로그인 기능
    fun signIn(binding : ActivityLoginBinding, intent: Intent){
        var inputEmail = binding.loginID.text.toString()
        var inputPw = binding.loginPWD.text.toString()

        auth.signInWithEmailAndPassword(inputEmail, inputPw)
            ?.addOnCompleteListener(){
                    task ->
                // 로그인 실패했을 경우 토스트 메세지 출력
                if (task.isSuccessful){
                    Toast.makeText(this, "Success login", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }else{
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun moveHomeActivity(user: FirebaseUser?){
        if(user!=null){
            val homeIntent = Intent(this, HomeActivity::class.java)
            val user = auth.currentUser

            homeIntent.putExtra("currentUser", user)
            startActivity(homeIntent)
        }
    }
}