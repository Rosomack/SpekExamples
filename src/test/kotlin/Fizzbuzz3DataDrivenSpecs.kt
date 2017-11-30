import org.amshove.kluent.`should equal to`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.data_driven.data
import org.jetbrains.spek.data_driven.on

class Fizzbuzz3DataDrivenExtensionSpec : Spek({
    val fizzOutput = "Fizz"
    val buzzOutput = "Buzz"
    val fizzbuzzOutput = "FizzBuzz"
    val foobarOutput = "Foobar!"

    val fizzbuzz by memoized { Fizzbuzz3(DivisibilityBy3Tester(), DivisibilityBy5Tester(), Is15Tester()) }

    fun givenTestData() =
            arrayOf(
                    data(1, expected = "1"),
                    data(2, expected = "2"),
                    data(3, expected = fizzOutput),
                    data(4, expected = "4"),
                    data(5, expected = buzzOutput),
                    data(6, expected = fizzOutput),
                    data(7, expected = "7"),
                    data(8, expected = "8"),
                    data(9, expected = fizzOutput),
                    data(10, expected = buzzOutput),
                    data(11, expected = "11"),
                    data(12, expected = fizzOutput),
                    data(13, expected = "13"),
                    data(14, expected = "14"),
                    data(15, expected = foobarOutput),
                    data(16, expected = "16"),
                    data(17, expected = "17"),
                    data(18, expected = fizzOutput),
                    data(19, expected = "19"),
                    data(20, expected = buzzOutput),
                    data(21, expected = fizzOutput),
                    data(22, expected = "22"),
                    data(23, expected = "23"),
                    data(24, expected = fizzOutput),
                    data(25, expected = buzzOutput),
                    data(26, expected = "26"),
                    data(27, expected = fizzOutput),
                    data(28, expected = "28"),
                    data(29, expected = "29"),
                    data(30, expected = fizzbuzzOutput)
            )

    given("a set of test data") {
        val testData = givenTestData() // No need to be memoized, static data.

        on("converting number %d to fizzbuzz", with = *testData) { number, expectedString ->
            val actualString by memoized { fizzbuzz.toString(number) }

            it("returns $expectedString") {
                actualString `should equal to` expectedString
            }
        }

    }

})

