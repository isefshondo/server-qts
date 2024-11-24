package com.example

import com.example.calculator.CalculatorAPI
import io.ktor.server.application.*

fun Application.configureRouting() {
    CalculatorAPI()
}
