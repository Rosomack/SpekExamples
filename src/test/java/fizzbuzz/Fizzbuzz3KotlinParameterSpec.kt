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
                    1 to buzzOutput,
                    1 to "11",
                    1 to fizzOutput,
                    1 to "13",
                    1 to "14",
                    1 to foobarOutput,
                    1 to "16",
                    1 to "17",
                    1 to fizzOutput,
                    1 to "19",
                    2 to buzzOutput,
                    2 to fizzOutput,
                    2 to "22",
                    2 to "23",
                    2 to fizzOutput,
                    2 to buzzOutput,
                    2 to "26",
                    2 to fizzOutput,
                    2 to "28",
                    2 to "29",
                    3 to fizzbuzzOutput
            )

    given("a set of test data") {
        val testData = givenTestData() // No need to be memoized, static data.

        testData.forEach { (number, expectedString) ->
            on("converting number $number to fizzbuzz") {
                val actualString by memoized { fizzbuzz.toString(number) }

                it("returns $expectedString") {
                    actualString `should equal to` expectedString
                }
            }

        }
    }

})