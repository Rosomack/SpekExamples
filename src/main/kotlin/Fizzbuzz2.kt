class Fizzbuzz2(private val divisibilityBy3Tester: NumberTester,
                private val divisibilityBy5Tester: NumberTester) : FizzBuzzPrinter {

    override fun toString(number: Int): String {
        val divisibleByThree = divisibilityBy3Tester.satisfiesCondition(number)
        val divisibleByFive = divisibilityBy5Tester.satisfiesCondition(number)

        return when {
            divisibleByThree && divisibleByFive -> "FizzBuzz"
            divisibleByThree -> "Fizz"
            divisibleByFive -> "Buzz"
            else -> number.toString()
        }
    }
}

class DivisibilityBy5Tester : NumberTester {
    override fun satisfiesCondition(number: Int) = number % 5 == 0
}