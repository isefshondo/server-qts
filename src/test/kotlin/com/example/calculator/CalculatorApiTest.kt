package com.example.calculator

import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import junit.framework.TestCase
import kotlin.test.Test

class CalculatorApiTest {
    @Test
    fun `should return correct values for sum route`() = testApplication {
        application {
            CalculatorAPI()
        }
        client.get("/sum/5/10").apply {
            TestCase.assertEquals(HttpStatusCode.OK, status)
            TestCase.assertEquals("Sum: 15.0", bodyAsText())
        }
    }

    @Test
    fun `should return correct values for sum route when both values are negative`() = testApplication {
        application {
            CalculatorAPI()
        }
        client.get("/sum/-5/-10").apply {
            TestCase.assertEquals(HttpStatusCode.OK, status)
            TestCase.assertEquals("Sum: -15.0", bodyAsText())
        }
    }

    @Test
    fun `should return correct values for sum route when one of the values is negative`() = testApplication {
        application {
            CalculatorAPI()
        }
        client.get("/sum/-5/10").apply {
            TestCase.assertEquals(HttpStatusCode.OK, status)
            TestCase.assertEquals("Sum: 5.0", bodyAsText())
        }
    }

    @Test
    fun `should return a string for sum route when values are invalid`() = testApplication {
        application {
            CalculatorAPI()
        }
        client.get("/sum/a/b").apply {
            TestCase.assertEquals(HttpStatusCode.BadRequest, status)
            TestCase.assertEquals("Invalid values! Both numbers should be provided", bodyAsText())
        }
    }

    @Test
    fun `should return correct values for subtract route`() = testApplication {
        application {
            CalculatorAPI()
        }
        client.get("/subtract/10/5").apply {
            TestCase.assertEquals(HttpStatusCode.OK, status)
            TestCase.assertEquals("Subtraction: 5.0", bodyAsText())
        }
    }

    @Test
    fun `should sum values in subtract route when first number is negative`() = testApplication {
        application {
            CalculatorAPI()
        }
        client.get("/subtract/-5/10").apply {
            TestCase.assertEquals(HttpStatusCode.OK, status)
            TestCase.assertEquals("Subtraction: -15.0", bodyAsText())
        }
    }

    @Test
    fun `should sum value in subtract route when second number is negative`() = testApplication {
        application {
            CalculatorAPI()
        }
        client.get("/subtract/5/-10").apply {
            TestCase.assertEquals(HttpStatusCode.OK, status)
            TestCase.assertEquals("Subtraction: 15.0", bodyAsText())
        }
    }

    @Test
    fun `should return a string for subtraction route when values are invalid`() = testApplication {
        application {
            CalculatorAPI()
        }
        client.get("/subtract/a/b").apply {
            TestCase.assertEquals(HttpStatusCode.BadRequest, status)
            TestCase.assertEquals("Invalid values! Both numbers should be provided", bodyAsText())
        }
    }

    @Test
    fun `should return correct values for multiplication route`() = testApplication {
        application {
            CalculatorAPI()
        }
        client.get("/multiply/5/10").apply {
            TestCase.assertEquals(HttpStatusCode.OK, status)
            TestCase.assertEquals("Multiplication: 50.0", bodyAsText())
        }
    }

    @Test
    fun `should return negative values when one of the number is negative in multiplication route`() = testApplication {
        application {
            CalculatorAPI()
        }
        client.get("/multiply/-5/10").apply {
            TestCase.assertEquals(HttpStatusCode.OK, status)
            TestCase.assertEquals("Multiplication: -50.0", bodyAsText())
        }
    }

    @Test
    fun `should return positive values when both numbers are negative in multiplication route`() = testApplication {
        application {
            CalculatorAPI()
        }
        client.get("/multiply/-5/-10").apply {
            TestCase.assertEquals(HttpStatusCode.OK, status)
            TestCase.assertEquals("Multiplication: 50.0", bodyAsText())
        }
    }

    @Test
    fun `should return a string for multiplication route when values are invalid`() = testApplication {
        application {
            CalculatorAPI()
        }
        client.get("/multiply/a/b").apply {
            TestCase.assertEquals(HttpStatusCode.BadRequest, status)
            TestCase.assertEquals("Invalid values! Both numbers should be provided", bodyAsText())
        }
    }

    @Test
    fun `should return correct values for division route`() = testApplication {
        application {
            CalculatorAPI()
        }
        client.get("/divide/4/2").apply {
            TestCase.assertEquals(HttpStatusCode.OK, status)
            TestCase.assertEquals("Division: 2.0", bodyAsText())
        }
    }

    @Test
    fun `should return a string for division route when denominator is zero`() = testApplication {
        application {
            CalculatorAPI()
        }
        client.get("/divide/4/0").apply {
            TestCase.assertEquals(HttpStatusCode.OK, status)
            TestCase.assertEquals("Division: It is not possible to divide by zero! Try another number as denominator", bodyAsText())
        }
    }

    @Test
    fun `should return a string for division route when values are invalid`() = testApplication {
        application {
            CalculatorAPI()
        }
        client.get("/divide/a/b").apply {
            TestCase.assertEquals(HttpStatusCode.BadRequest, status)
            TestCase.assertEquals("Invalid values! Both numbers should be provided", bodyAsText())
        }
    }
}