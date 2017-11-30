import org.amshove.kluent.*
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*

class FizzBuzz1Spec : Spek({
    val testNumber = 1
    val fizzOutput = "Fizz"

    val divisibleBy3Tester by memoized { mock<NumberTester>() }
    val fizzbuzz by memoized { Fizzbuzz1(divisibleBy3Tester) }

    given("the number is divisible by 3") {
        beforeEachTest {
            When calling divisibleBy3Tester.satisfiesCondition(any()) `it returns` true
        }

        on("translating the number to string") {
            val actual by memoized { fizzbuzz.toString(testNumber) }

            it("returns fizz") {
                actual `should equal to` fizzOutput
            }

        }
    }

    given("the number is not divisible by 3") {
        beforeEachTest {
            When calling divisibleBy3Tester.satisfiesCondition(any()) `it returns` false
        }

        on("translating the number to string") {
            val actual by memoized { fizzbuzz.toString(testNumber) }

            it("returns the number string") {
                actual `should equal to` testNumber.toString()
            }

        }
    }
})