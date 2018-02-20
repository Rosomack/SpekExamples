package randoms

import org.amshove.kluent.`should be`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class ActionSpec : Spek({

    on("running the ultimate computation") {
        val actualAnswer = compute()

        it("should equal 42") {
            actualAnswer `should be` 42
        }

        it("should be divisible by 2") {
            actualAnswer % 2 `should be` 0
        }
    }
})

fun compute() = 6 * 7