package com.example.waka_waka
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.waka_waka.databinding.ActivityMatchBinding
import com.example.waka_waka.databinding.ActivityMatchEndBinding

class MatchEndActivity : AppCompatActivity() {

    val binding = ActivityMatchEndBinding.inflate(layoutInflater)

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.myButton1.setOnClickListener {
            count++
            binding.myTextView1.text = count.toString()
        }
        binding.myButton2.setOnClickListener {
            count++
            binding.myTextView2.text = count.toString()
        }
        binding.myButton2.setOnClickListener {
            count++
            binding.myTextView2.text = count.toString()
        }
        val spinner: Spinner = binding.nameChoose
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.name_to_review,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }
}
