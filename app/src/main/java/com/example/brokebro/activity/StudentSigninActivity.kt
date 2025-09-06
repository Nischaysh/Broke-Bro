package com.example.brokebro.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.brokebro.R
import com.example.brokebro.databinding.ActivityStudentSigninBinding

class StudentSigninActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentSigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentSigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupYearOfStudySpinner()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun setupYearOfStudySpinner() {
        val years = resources.getStringArray(R.array.year_of_study_options)
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, years)
        binding.spinnerYearOfStudy.setAdapter(adapter)
    }

    override fun onDestroy() {
        super.onDestroy()
        // ViewBinding automatically handles cleanup
    }
}