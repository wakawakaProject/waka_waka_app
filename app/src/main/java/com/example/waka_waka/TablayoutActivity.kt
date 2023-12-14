package com.example.waka_waka

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.waka_waka.databinding.BottomNavigationViewBinding
import com.google.android.material.tabs.TabLayout

class TablayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = BottomNavigationViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val matchIntent = Intent(this, MatchActivity::class.java)
        val homeIntent = Intent(this, HomeActivity::class.java)
        // profile activity 인텐트 추가해야함

        binding.naviMain.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                when(tab.position){
                    0 -> {
                        startActivity(matchIntent)
                    }
                    1 -> {
                        startActivity(homeIntent)
                    }
                    2 -> {

                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }
}