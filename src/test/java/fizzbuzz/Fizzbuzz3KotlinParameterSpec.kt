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
                    Pair(1, "1"),  // We can always create custom data classes here if we want to be more descriptive
                    Pair(2, "2"),
                    Pair(3, fizzOutput),
                    Pair(4, "4"),
                    Pair(5, buzzOutput),
                    Pair(6, fizzOutput),
                    Pair(7, "7"),
                    Pair(8, "8"),
                    Pair(9, fizzOutput),
                    Pair(10, buzzOutput),
                    Pair(11, "11"),
                    Pair(12, fizzOutput),
                    Pair(13, "13"),
                    Pair(14, "14"),
                    Pair(15, foobarOutput),
                    Pair(16, "16"),
                    Pair(17, "17"),
                    Pair(18, fizzOutput),
                    Pair(19, "19"),
                    Pair(20, buzzOutput),
                    Pair(21, fizzOutput),
                    Pair(22, "22"),
                    Pair(23, "23"),
                    Pair(24, fizzOutput),
                    Pair(25, buzzOutput),
                    Pair(26, "26"),
                    Pair(27, fizzOutput),
                    Pair(28, "28"),
                    Pair(29, "29"),
                    Pair(30, fizzbuzzOutput)
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