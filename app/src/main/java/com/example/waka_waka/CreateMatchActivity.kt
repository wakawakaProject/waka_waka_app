package com.example.waka_waka

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.waka_waka.databinding.ActivityMatchCreateBinding

class CreateMatchActivity : AppCompatActivity() {

    val binding = ActivityMatchCreateBinding.inflate(layoutInflater)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // spinner에 리스트 추가
        ArrayAdapter.createFromResource(
            this,
            R.array.gender_arr, // values/array.xml에 있는 array리소스 인자로 넘기기
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spnSelectField.adapter = adapter // spinner에 array 적용
        }
    }
}