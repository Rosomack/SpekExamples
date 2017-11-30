fun main(args: Array<String>) {

    val fizzbuzz0 = Fizzbuzz0()
    val fizzbuzz1 = Fizzbuzz1(DivisibilityBy3Tester())
    val fizzbuzz2 = Fizzbuzz2(DivisibilityBy3Tester(), DivisibilityBy5Tester())
    val fizzbuzz3 = Fizzbuzz3(DivisibilityBy3Tester(), DivisibilityBy5Tester(), Is15Tester())

    for (i in 1..100) {
        println(fizzbuzz3.toString(i))
    }
}
