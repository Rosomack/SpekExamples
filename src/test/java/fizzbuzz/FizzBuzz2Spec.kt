package fizzbuzz

import org.amshove.kluent.*
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class FizzBuzz2Spec : Spek({
    val testNumber = 1
    val fizzOutput = "Fizz"
    val buzzOutput = "Buzz"
    val fizzbuzzOutput = "FizzBuzz"

    val divisibleBy3Tester by memoized { mock<NumberTester>() }
    val divisibleBy5Tester by memoized { mock<NumberTester>() }
    val fizzbuzz by memoized { Fizzbuzz2(divisibleBy3Tester, divisibleBy5Tester) }

    given("the number is divisible by 5") {
        beforeEachTest {
            When calling divisibleBy5Tester.satisfiesCondition(any()) `it returns` true
        }

        given("the number is divisible by 3") {
            beforeEachTest {
                When calling divisibleBy3Tester.satisfiesCondition(any()) `it returns` true
            }

            on("translating the number to string") {
                val actual by memoized { fizzbuzz.toString(testNumber) }

                it("returns fizzbuzz") {
                    actual `should equal to` fizzbuzzOutput
                }

            }
        }

        given("the number is not divisible by 3") {
            beforeEachTest {
                When calling divisibleBy3Tester.satisfiesCondition(any()) `it returns` false
            }

            on("translating the number to string") {
                val actual by memoized { fizzbuzz.toString(testNumber) }

                it("returns buzz") {
                    actual `should equal to` buzzOutput
                }

            }
        }
    }

    given("the number is not divisible by 5") {
        beforeEachTest {
            When calling divisibleBy5Tester.satisfiesCondition(any()) `it returns` false
        }

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
    }
})