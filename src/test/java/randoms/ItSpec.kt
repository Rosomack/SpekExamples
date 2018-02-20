package randoms

import org.amshove.kluent.`should equal to`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it

class ItSpec : Spek({

    it("tests the universe") {
        true `should equal to` true
    }
})