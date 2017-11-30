import org.amshove.kluent.`should equal to`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


/**
 * This demonstrates another way to use kotlin to generate test cases for us.
 *
 * This test is a bit more efficient than {@see Fizzbuzz3GeneratedKotlinParameterSpec}
 *
 * To be honest this feels a lot like reimplementing the class under test, but it's most likely because it's such a simple
 * example.
 */
class Fizzbuzz3AnotherGeneratedKotlinParameterSpec : Spek({
    val fizzOutput = "Fizz"
    val buzzOutput = "Buzz"
    val fizzbuzzOutput = "FizzBuzz"
    val foobarOutput = "Foobar!"

    val fizzbuzz by memoized { Fizzbuzz3(DivisibilityBy3Tester(), DivisibilityBy5Tester(), Is15Tester()) }

    given("numbers from 1 to 1000") {
        (1..1000).forEach {
            when {
                it == 15 -> given("number $it") {
                    on("converting number $it to fizzbuzz") {
                        val actualString by memoized { fizzbuzz.toString(it) }

                        it("returns foobar") {
                            actualString `should equal to` foobarOutput
                        }
                    }
                }
                it % 3 == 0 && it % 5 == 0 -> given("number $it") {
                    on("converting number $it to fizzbuzz") {
                        val actualString by memoized { fizzbuzz.toString(it) }

                        it("returns fizzbuzz") {
                            actualString `should equal to` fizzbuzzOutput
                        }
                    }
                }
                it % 5 == 0 -> given("number $it") {
                    on("converting number $it to fizzbuzz") {
                        val actualString by memoized { fizzbuzz.toString(it) }

                        it("returns buzz") {
                            actualString `should equal to` buzzOutput
                        }
                    }
                }
                it % 3 == 0 -> given("number $it") {
                    on("converting number $it to fizzbuzz") {
                        val actualString by memoized { fizzbuzz.toString(it) }

                        it("returns fizz") {
                            actualString `should equal to` fizzOutput
                        }
                    }
                }
                else -> given("number $it") {
                    on("converting number $it to fizzbuzz") {
                        val actualString by memoized { fizzbuzz.toString(it) }

                        it("returns \"$it\"") {
                            actualString `should equal to` it.toString()
                        }
                    }
                }
            }
        }
    }
})