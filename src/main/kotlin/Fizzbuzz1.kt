class Fizzbuzz1(private val divisibilityBy3Tester: NumberTester) : FizzBuzzPrinter {

    override fun toString(number: Int): String {
        val divisibleByThree = divisibilityBy3Tester.satisfiesCondition(number)

        return when {
            divisibleByThree -> "Fizz"
            else -> number.toString()
        }
    }
}

interface NumberTester {
    fun satisfiesCondition(number: Int): Boolean
}

class DivisibilityBy3Tester : NumberTester {
    override fun satisfiesCondition(number: Int) = number % 3 == 0
}