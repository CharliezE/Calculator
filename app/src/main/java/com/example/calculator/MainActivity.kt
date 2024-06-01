package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var userNumber: Double = 0.0
    private var multiplyNumber: Double = 1.0
    private var isMultiply: Boolean = false
    private var isDivide: Boolean = false
    private var isError: Boolean = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.black)

        binding.one.setOnClickListener {
            if (isError) resetCalculator()
            if (binding.number.text == "-0") binding.number.text = "-1"
            else if (binding.number.text == "0") binding.number.text = "1"
            else binding.number.text = binding.number.text.toString() + "1"
        }
        binding.two.setOnClickListener {
            if (isError) resetCalculator()
            if (binding.number.text == "-0") binding.number.text = "-2"
            else if (binding.number.text == "0") binding.number.text = "2"
            else binding.number.text = binding.number.text.toString() + "2"
        }
        binding.three.setOnClickListener {
            if (isError) resetCalculator()
            if (binding.number.text == "-0") binding.number.text = "-3"
            else if (binding.number.text == "0") binding.number.text = "3"
            else binding.number.text = binding.number.text.toString() + "3"
        }
        binding.four.setOnClickListener {
            if (isError) resetCalculator()
            if (binding.number.text == "-0") binding.number.text = "-4"
            else if (binding.number.text == "0") binding.number.text = "4"
            else binding.number.text = binding.number.text.toString() + "4"
        }
        binding.five.setOnClickListener {
            if (isError) resetCalculator()
            if (binding.number.text == "-0") binding.number.text = "-5"
            else if (binding.number.text == "0") binding.number.text = "5"
            else binding.number.text = binding.number.text.toString() + "5"
        }
        binding.six.setOnClickListener {
            if (isError) resetCalculator()
            if (binding.number.text == "-0") binding.number.text = "-6"
            else if (binding.number.text == "0") binding.number.text = "6"
            else binding.number.text = binding.number.text.toString() + "6"
        }
        binding.seven.setOnClickListener {
            if (isError) resetCalculator()
            if (binding.number.text == "-0") binding.number.text = "-7"
            else if (binding.number.text == "0") binding.number.text = "7"
            else binding.number.text = binding.number.text.toString() + "7"
        }
        binding.eight.setOnClickListener {
            if (isError) resetCalculator()
            if (binding.number.text == "-0") binding.number.text = "-8"
            else if (binding.number.text == "0") binding.number.text = "8"
            else binding.number.text = binding.number.text.toString() + "8"
        }
        binding.nine.setOnClickListener {
            if (isError) resetCalculator()
            if (binding.number.text == "-0") binding.number.text = "-9"
            else if (binding.number.text == "0") binding.number.text = "9"
            else binding.number.text = binding.number.text.toString() + "9"
        }
        binding.zero.setOnClickListener {
            if (isError) resetCalculator()
            if (binding.number.text != "0" && binding.number.text != "-0")
                binding.number.text = binding.number.text.toString() + "0"
        }
        binding.clear.setOnClickListener {
            resetCalculator()
        }
        binding.plus.setOnClickListener {
            if (isError) return@setOnClickListener
            if (isMultiply) {
                userNumber *= binding.number.text.toString().toDouble()
                isMultiply = false
            } else if (isDivide) {
                if (binding.number.text.toString().toDouble() != 0.0) {
                    userNumber /= binding.number.text.toString().toDouble()
                    isDivide = false
                } else {
                    binding.number.text = "ERROR"
                    isError = true
                    return@setOnClickListener
                }
            } else if (binding.number.text.toString() == "-") {
                binding.number.text = DataChanges.formatNumber(userNumber)
            } else {
                userNumber += binding.number.text.toString().toDouble()
                binding.number.text = "0"
            }
        }
        binding.minus.setOnClickListener {
            if (isError) return@setOnClickListener
            if (isMultiply) {
                userNumber *= binding.number.text.toString().toDouble()
                isMultiply = false
            } else if (isDivide) {
                if (binding.number.text.toString().toDouble() != 0.0) {
                    userNumber /= binding.number.text.toString().toDouble()
                    isDivide = false
                } else {
                    binding.number.text = "ERROR"
                    isError = true
                    return@setOnClickListener
                }
            } else if (binding.number.text.toString() == "-") {
                binding.number.text = DataChanges.formatNumber(userNumber)
            } else {
                userNumber += binding.number.text.toString().toDouble()
                binding.number.text = "-"
            }
        }
        binding.multiply.setOnClickListener {
            if (isError) return@setOnClickListener
            multiplyNumber = binding.number.text.toString().toDouble()
            isMultiply = true
            isDivide = false
            binding.number.text = "0"
        }
        binding.divide.setOnClickListener {
            if (isError) return@setOnClickListener
            multiplyNumber = binding.number.text.toString().toDouble()
            isDivide = true
            isMultiply = false
            binding.number.text = "0"
        }
        binding.point.setOnClickListener {
            if (isError) resetCalculator()
            if (!binding.number.text.contains('.'))
                binding.number.text = binding.number.text.toString() + "."
        }
        binding.plusMinus.setOnClickListener {
            if (isError) return@setOnClickListener
            if (binding.number.text.toString()[0] == '-') {
                binding.number.text = binding.number.text.toString().substring(1)
            } else binding.number.text = '-' + binding.number.text.toString()
        }
        binding.percent.setOnClickListener {
            if (isError) return@setOnClickListener
            binding.number.text = (binding.number.text.toString().toDouble() * 0.01).toString()
        }
        binding.equally.setOnClickListener {
            if (isError) return@setOnClickListener
            lateinit var numberSum: String
            if (binding.number.text != "-") {
                if (isMultiply) {
                    multiplyNumber *= binding.number.text.toString().toDouble()
                    userNumber += multiplyNumber
                    numberSum = DataChanges.formatNumber(userNumber)
                } else if (isDivide) {
                    if (binding.number.text.toString().toDouble() != 0.0) {
                        multiplyNumber /= binding.number.text.toString().toDouble()
                        userNumber += multiplyNumber
                        numberSum = DataChanges.formatNumber(userNumber)
                    } else {
                        binding.number.text = "ERROR"
                        isError = true
                        return@setOnClickListener
                    }
                } else {
                    numberSum = DataChanges.formatNumber(
                        userNumber + binding.number.text.toString().toDouble()
                    )
                }
                binding.number.text = numberSum
                userNumber = 0.0
                multiplyNumber = 1.0
                isMultiply = false
                isDivide = false
            }
        }
    }

    private fun resetCalculator() {
        binding.number.text = "0"
        userNumber = 0.0
        multiplyNumber = 1.0
        isMultiply = false
        isDivide = false
        isError = false
    }

    private object DataChanges {
        fun formatNumber(number: Double): String {
            return if (number == number.toLong().toDouble()) {
                number.toLong().toString()
            } else {
                number.toString()
            }
        }
    }
}
