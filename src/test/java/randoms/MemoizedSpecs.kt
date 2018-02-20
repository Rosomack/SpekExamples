package randoms

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class NoMemoizationSpek : Spek({

    val subject = SubjectUnderTest()

    it("checks the subject instance") {
        println("Instance: $subject")
    }

    it("checks the subject instance again") {
        println("Instance again: $subject")
    }

})

class SimpleMemoizationSpek : Spek({

    val subject by memoized { SubjectUnderTest() }

    it("checks the subject instance") {
        println("Instance: $subject")
    }

    it("checks the subject instance again") {
        println("Instance again: $subject")
    }

})

class MemoizationWithActionsSpek : Spek({

    val subject by memoized { SubjectUnderTest() }

    on("action 1") {
        println("On instance 1: $subject")

        it("checks the subject instance") {
            println("It instance 1: $subject")
        }
    }

    on("action 2") {
        println("On instance 2: $subject")

        it("checks the subject instance again") {
            println("It instance 2: $subject")
        }
    }
})

class MemoizationWithGivensSpek : Spek({

    val subject by memoized { SubjectUnderTest() }

    given("context 1") {
        println("Given instance 1: $subject")

        it("checks the subject instance") {
            println("It instance 1: $subject")
        }
    }

    given("context 2") {
        println("Given instance 2: $subject")

        it("checks the subject instance again") {
            println("It instance 2: $subject")
        }
    }
})

class MemoizationWithGivensAndBeforeBlocksSpek : Spek({

    val subject by memoized { SubjectUnderTest() }

    given("context 1") {
        beforeEachTest {
            println("Given instance 1: $subject")
        }

        it("checks the subject instance") {
            println("It instance 1: $subject")
        }
    }

    given("context 2") {
        beforeEachTest {
            println("Given instance 2: $subject")
        }

        it("checks the subject instance again") {
            println("It instance 2: $subject")
        }
    }
})

class SubjectUnderTest