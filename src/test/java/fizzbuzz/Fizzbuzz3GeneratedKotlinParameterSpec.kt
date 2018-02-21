package fizzbuzz

import org.amshove.kluent.`should equal to`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

/**
 * This demonstrates how we can use kotlin to generate test cases for us.
 *
 * This test is not super efficient but does the job.
 *
 * It seems also like a slithly awkward implementation. See {@see fizzbuzz.Fizzbuzz3AnotherGeneratedKotlinParameterSpec}
 */
class Fizzbuzz3GeneratedKotlinParameterSpec : Spek({
    val fizzOutput = "Fizz"
    val buzzOutput = "Buzz"
    val fizzbuzzOutput = "FizzBuzz"
    val foobarOutput = "Foobar!"

    val fizzbuzz by memoized { Fizzbuzz3(DivisibilityBy3Tester(), DivisibilityBy5Tester(), Is15Tester()) }

    given("numbers from 1 to 1000 divisible by 3") {
        val numbersDivBy3 = arrayListOf(3..1000 step 3).flatten()

        given(" only numbers that are also divisible by 5") {
            val numbersDivBy3And5 = arrayListOf(5..1000 step 5).flatten().filter { it in numbersDivBy3 }
            println(numbersDivBy3And5)

            given("it's not the number 15") {
                val numbersDivBy3And5Not15 = numbersDivBy3And5.filterNot { it == 15 }

                numbersDivBy3And5Not15.forEach {
                    on("converting number $it to fizzbuzz") {
                        val actualString = fizzbuzz.toString(it)

                        it("returns fizzbuzz") {
                            actualString `should equal to` fizzbuzzOutput
                        }
                    }
                }
            }

            given("it's the number 15") {
                on("converting number 15 to fizzbuzz") {
                    val actualString = fizzbuzz.toString(15)

                    it("returns foobar") {
                        actualString `should equal to` foobarOutput
                    }
                }
            }
        }

        given(" only numbers that are not divisible by 5") {
            val numbersDivBy3AndNotBy5 = numbersDivBy3.filterNot { it in (5..1000 step 5) }

            numbersDivBy3AndNotBy5.forEach {
                on("converting number $it to fizzbuzz") {
                    val actualString = fizzbuzz.toString(it)

                    it("returns fizz") {
                        actualString `should equal to` fizzOutput
                    }
                }
            }
        }
    }

    given("numbers from 1 to 1000 divisible by 5") {
        val numbersDivBy5 = arrayListOf(5..1000 step 5).flatten()

        given("only numbers that are not divisible by 3") {
            val numbersDivBy5AndNotBy3 = numbersDivBy5.filterNot { it in (3..1000 step 3) }

            numbersDivBy5AndNotBy3.forEach {
                on("converting number $it to fizzbuzz") {
                    val actualString = fizzbuzz.toString(it)

                    it("returns fizz") {
                        actualString `should equal to` buzzOutput
                    }
                }
            }
        }
    }

    given("numbers from 1 to 1000 not divisible by 5") {
        val numbersNotDivBy5 = arrayListOf(1..1000).flatten().filterNot { it in 5..1000 step 5 }

        given("only numbers that are not divisible by 3") {
            val numbersNotDivBy5AndNotBy3 = numbersNotDivBy5.filterNot { it in (3..1000 step 3) }

            numbersNotDivBy5AndNotBy3.forEach {
                on("converting number $it to fizzbuzz") {
                    val actualString = fizzbuzz.toString(it)

                    it("returns \"$it\"") {
                        actualString `should equal to` it.toString()
                    }
                }
            }
        }
    }
})