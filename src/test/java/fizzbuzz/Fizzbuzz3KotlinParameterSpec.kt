package fizzbuzz

import org.amshove.kluent.`should equal to`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

/**
 * Black-box testing. Uses a kotlin foreach loop.
 *
 * I don't see a big reason for using Spek's data driven extension {@see fizzbuzz.Fizzbuzz3DataDrivenExtensionSpec}.
 * What little it offers can be done effortlessly using
 * pure Kotlin. In fact, it demonstrates that a lot of what used to be difficult JUnit can be achieved easily using
 * no frameworks. The test (spec) is in fact a pure lambda function, it liberates us from framework constraints.
 */
class Fizzbuzz3KotlinParameterSpec : Spek({
    val fizzOutput = "Fizz"
    val buzzOutput = "Buzz"
    val fizzbuzzOutput = "FizzBuzz"
    val foobarOutput = "Foobar!"

    val fizzbuzz by memoized { Fizzbuzz3(DivisibilityBy3Tester(), DivisibilityBy5Tester(), Is15Tester()) }

    fun givenTestData() =
            arrayOf(
                    1 to "1",  // We can always create custom data classes here if we want to be more descriptive
                    2 to "2",
                    3 to fizzOutput,
                    4 to "4",
                    5 to buzzOutput,
                    6 to fizzOutput,
                    7 to "7",
                    8 to "8",
                    9 to fizzOutput,
                    10 to buzzOutput,
                    11 to "11",
                    12 to fizzOutput,
                    13 to "13",
                    14 to "14",
                    15 to foobarOutput,
                    16 to "16",
                    17 to "17",
                    18 to fizzOutput,
                    19 to "19",
                    20 to buzzOutput,
                    21 to fizzOutput,
                    22 to "22",
                    23 to "23",
                    24 to fizzOutput,
                    25 to buzzOutput,
                    26 to "26",
                    27 to fizzOutput,
                    28 to "28",
                    29 to "29",
                    30 to fizzbuzzOutput
            )

    given("a set of test data") {
        val testData = givenTestData() // No need to be memoized, static data.

        testData.forEach { (number, expectedString) ->
            on("converting number $number to fizzbuzz") {
                val actualString = fizzbuzz.toString(number)

                it("returns $expectedString") {
                    actualString `should equal to` expectedString
                }
            }

        }
    }

})