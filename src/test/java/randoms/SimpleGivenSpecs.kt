package randoms

import org.amshove.kluent.`should be`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class SimpleGivenSpec : Spek({

    given("the number x equal 6") {
        val x = 6

        given("the number y equal 7") {
            val y = 7

            on("multiplying x and y") {
                val actualAnswer = multiply(x, y)

                it("should equal 42") {
                    actualAnswer `should be` 42
                }
            }
        }
    }
})

class SimpleGivenSpec2 : Spek({

    given("the number x equal 2") {
        val x = 2

        on("squaring x") {
            val actualAnswer = squared(x)

            it("should equal 4") {
                actualAnswer `should be` 4
            }
        }
        on("cubing x") {
            val actualAnswer = cubed(x)

            it("should equal 8") {
                actualAnswer `should be` 8
            }
        }
    }
})

fun multiply(a: Int, b: Int) = a * b

fun squared(a: Int) = a * a

fun cubed(a: Int) = a * a * a