package fizzbuzz

class Fizzbuzz0 : FizzBuzzPrinter {

    override fun toString(number: Int): String {
        val divisibleByThree = number % 3 == 0

        return when {
            divisibleByThree -> "Fizz"
            else -> number.toString()
        }
    }
}