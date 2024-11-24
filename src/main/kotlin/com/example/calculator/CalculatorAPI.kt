package com.example.calculator

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.CalculatorAPI() {
    routing {
        get("/") {
            call.respondText("Welcome to the CalculatorAPI! Available functionalities: Sum - Subtraction - Multiplication - Division")
        }
        get("/sum/{firstNumber}/{secondNumber}") {
            val firstNumber = call.parameters["firstNumber"]?.toDoubleOrNull()
            val secondNumber = call.parameters["secondNumber"]?.toDoubleOrNull()

            if (firstNumber == null || secondNumber == null) {
                call.respondText("Invalid values! Both numbers should be provided", status = HttpStatusCode.BadRequest)
                return@get
            }

            val sumCalculator = Calculator(firstNumber, secondNumber).sum()
            call.respondText("Sum: $sumCalculator", status = HttpStatusCode.OK)
        }
        get("/subtract/{firstNumber}/{secondNumber}") {
            val firstNumber = call.parameters["firstNumber"]?.toDoubleOrNull()
            val secondNumber = call.parameters["secondNumber"]?.toDoubleOrNull()

            if (firstNumber == null || secondNumber == null) {
                call.respondText("Invalid values! Both numbers should be provided", status = HttpStatusCode.BadRequest)
                return@get
            }

            val subtractCalculator = Calculator(firstNumber, secondNumber).subtract()
            call.respondText("Subtraction: $subtractCalculator", status = HttpStatusCode.OK)
        }
        get("/multiply/{firstNumber}/{secondNumber}") {
            val firstNumber = call.parameters["firstNumber"]?.toDoubleOrNull()
            val secondNumber = call.parameters["secondNumber"]?.toDoubleOrNull()

            if (firstNumber == null || secondNumber == null) {
                call.respondText("Invalid values! Both numbers should be provided", status = HttpStatusCode.BadRequest)
                return@get
            }

            val multiplyCalculator = Calculator(firstNumber, secondNumber).multiply()
            call.respondText("Multiplication: $multiplyCalculator", status = HttpStatusCode.OK)
        }
        get("/divide/{firstNumber}/{secondNumber}") {
            val firstNumber = call.parameters["firstNumber"]?.toDoubleOrNull()
            val secondNumber = call.parameters["secondNumber"]?.toDoubleOrNull()

            if (firstNumber == null || secondNumber == null) {
                call.respondText("Invalid values! Both numbers should be provided", status = HttpStatusCode.BadRequest)
                return@get
            }

            val divideCalculator = Calculator(firstNumber, secondNumber).divide()
            call.respondText("Division: $divideCalculator", status = HttpStatusCode.OK)
        }
    }
}