package com.example.bmicalculatetor

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmicalculatetor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calBtn.setOnClickListener {

            val weight = binding.weightEt.text.toString()
            val height = binding.heightEt.text.toString()

            // startActivity(Intent(this@MainActivity, ResultActivity::class.java))
            if (validateInput(weight, height)) {
                binding.calCard.setVisibility(View.VISIBLE)
                val bmi =
                    weight.toDouble() / ((height.toDouble() / 100) * (height.toDouble() / 100))
                val bmiDigit = String.format("%.2f", bmi).toDouble()
                displayResult(bmiDigit)
            }

        }
    }

    private fun displayResult(bmiDigit: Double) {
        var result = ""
        var color = 0
        var range = ""

        when {
            bmiDigit < 18.50 -> {
                result = "Underweight"
                color = R.color.under_weight
                range = "(Underweight range is less than 18.50)"
            }

            bmiDigit in 18.50..24.99 -> {
                result = "Healthy"
                color = R.color.normal
                range = "(Healthy range is 18.50 -24.99)"
            }

            bmiDigit in 25.00..29.99 -> {
                result = "Overweight"
                color = R.color.over_weight
                range = "(Overweight range is 25.00-29.99)"
            }

            bmiDigit > 29.99 -> {
                result = "Obese"
                color = R.color.obese
                range = "(Obese range is greater than 29.99)"
            }
        }
        binding.countTxt.setTextColor(ContextCompat.getColor(this, color))
        binding.countTxt.text = bmiDigit.toString()
        binding.resultTxt.setTextColor(ContextCompat.getColor(this, color))
        binding.resultTxt.text = result
        binding.rangeTxt.setTextColor(ContextCompat.getColor(this, color))
        binding.rangeTxt.text = range
    }

    private fun validateInput(weight: String, height: String): Boolean {
        when {
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Weight is empty", Toast.LENGTH_SHORT).show()
                return false
            }

            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty", Toast.LENGTH_SHORT).show()
                return false
            }

            else -> {
                return true
            }
        }
    }
}