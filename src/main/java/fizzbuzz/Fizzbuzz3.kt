package fizzbuzz

class Fizzbuzz3(private val divisibilityBy3Tester: NumberTester,
                private val divisibilityBy5Tester: NumberTester,
                private val is15Tester: NumberTester) : FizzBuzzPrinter {

    override fun toString(number: Int): String {
        val divisibleByThree = divisibilityBy3Tester.satisfiesCondition(number)
        val divisibleByFive = divisibilityBy5Tester.satisfiesCondition(number)
        val is15 = is15Tester.satisfiesCondition(number)

        return when {
            is15 -> "Foobar!"
            divisibleByThree && divisibleByFive -> "FizzBuzz"
            divisibleByThree -> "Fizz"
            divisibleByFive -> "Buzz"
            else -> number.toString()
        }
    }
}

class Is15Tester : NumberTester {
    override fun satisfiesCondition(number: Int) = number == 15
}