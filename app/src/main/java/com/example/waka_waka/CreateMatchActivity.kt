package com.example.waka_waka

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.text.intl.Locale
import androidx.core.view.get
import com.example.waka_waka.databinding.ActivityMatchCreateBinding
import com.google.firebase.Firebase
import com.google.firebase.database.database
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class CreateMatchActivity : AppCompatActivity() {

    private val calendar = Calendar.getInstance()
    val database = Firebase.database
    val matchRef = database.getReference("match")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMatchCreateBinding.inflate(layoutInflater)
        var selectedDate : String = ""
        setContentView(binding.root)

        // spinner에 경기장 리스트 추가
        ArrayAdapter.createFromResource(
            this,
            R.array.stardium, // values/array.xml에 있는 array리소스 인자로 넘기기
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spnSelectField.adapter = adapter // spinner에 array 적용
        }

        // 날짜 선택 DatePicker
        binding.dpSelectDate.setOnClickListener {
            selectedDate = showDatePickerDialog(binding)
        }


        // spinner에 경기 인원수 리스트 추가
        ArrayAdapter.createFromResource(
            this,
            R.array.member_num, // values/array.xml에 있는 array리소스 인자로 넘기기
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spnSelectMember.adapter = adapter // spinner에 array 적용
        }


        // 매치 생성 버튼클릭
        binding.btnMakeMatch.setOnClickListener {
            var dataId : String = addKey()
            var match = Match(
                dataId,
                binding.spnSelectField.selectedItem.toString(),
                selectedDate,
                binding.spnSelectMember.selectedItem.toString(),
                binding.edtComment.text.toString()
            )

            matchRef.child(dataId).setValue(match)
            val intent = Intent(applicationContext, MatchListActivity::class.java)
            startActivity(intent)
        }

    }



    private fun showDatePickerDialog(binding: ActivityMatchCreateBinding) : String {
        var selectedDate : String = ""
        val datePickerDialog = DatePickerDialog(
            this,
            android.R.style.Theme_Holo_Dialog,
            { _, year, month, dayOfMonth ->
                // 날짜 선택 후 호출되는 콜백
                selectedDate = updateDate(year, month, dayOfMonth, binding) // 날짜 데이터가 null값이 들어감 추후 확인요망
                println(selectedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        println(selectedDate)
        datePickerDialog.show()
        return selectedDate
    }

        private fun updateDate(year: Int, month: Int, dayOfMonth: Int, binding: ActivityMatchCreateBinding) : String {
            // 선택한 날짜를 TextView에 표시
            val selectedDate : String = "${year.toString()}-${month.toString()}-${dayOfMonth.toString()}"
            binding.dpSelectDate.text = selectedDate
            return selectedDate
        }

        private fun addKey() : String{
            val id = matchRef.push().key!!
        return id
    }
}