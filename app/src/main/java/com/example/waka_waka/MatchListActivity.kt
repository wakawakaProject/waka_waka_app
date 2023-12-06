package com.example.waka_waka

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.loader.content.AsyncTaskLoader
import com.example.waka_waka.databinding.ActivityMatchListBinding
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class MatchListActivity : AppCompatActivity() {
    private lateinit var scrl : ScrollView
    private lateinit var ctl : ConstraintLayout
    private var dbRef = Firebase.database.getReference("user")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMatchListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        scrl = binding.scrlMatch
        ctl = binding.ctlScrl

        fetchDataFromFirebase()

    }

    private fun fetchDataFromFirebase(){
        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = mutableListOf<String>()
                // 현재는 User 정보를 가져와서 ui를 변경하는 임시 로직을 구현
                // 추후 변경 요망
                for (childSnapshot in snapshot.children){
                    val item = childSnapshot.getValue(User::class.java)
                    item?.let{ data.add(it.toString())}
                }
                updateUI(data)

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
            }
        })

    }
    private fun  updateUI(data: List<String>) {
        // 데이터를 이용하여 TextView를 생성하고 ScrollView에 추가
        //
        for (item in data) {
            var cardview = CardView(this)
            var textview = TextView(this)
            textview.setText(data.get(1).toString())
            cardview.addView(textview)
            ctl.addView(cardview)
        }
    }

}