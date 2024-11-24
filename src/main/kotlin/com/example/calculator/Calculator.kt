package com.example.calculator

class Calculator (private val firstNumber: Number, private val secondNumber: Number) {
    fun sum(): Number {
        return firstNumber.toDouble() + secondNumber.toDouble()
    }
    fun subtract(): Number {
        return firstNumber.toDouble() - secondNumber.toDouble()
    }
    fun multiply(): Number {
        return firstNumber.toDouble() * secondNumber.toDouble()
    }
    fun divide(): Any {
        if (secondNumber.toDouble() == 0.0) {
            return "It is not possible to divide by zero! Try another number as denominator"
        }
        return firstNumber.toDouble() / secondNumber.toDouble()
    }
}