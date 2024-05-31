package com.example.calculator

import kotlin.math.pow
import kotlin.math.roundToInt

internal class DataChanges {
    internal companion object {
        fun formatNumber(number: Double): String {
            val decimalPlaces: Int = 5
            return if (number == number.toLong().toDouble()) {
                number.toLong().toString()
            } else {
                val factor = 10.0.pow(decimalPlaces.toDouble())
                val roundedNumber = (number * factor).roundToInt() / factor
                if (decimalPlaces > 0) {
                    "%.${decimalPlaces}f".format(roundedNumber).removeSuffix("0")
                        .removeSuffix(".")
                } else {
                    roundedNumber.toLong().toString()
                }
            }
        }
    }
}
