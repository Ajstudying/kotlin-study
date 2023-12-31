package ch04

import jdk.dynalink.Operation

//고차 함수(Higher-Order Functions)
// 다른 함수를 매개변수로 받거나 함수를 반환하는 함수
//function1 -> function2 -> function2 + function1

//람다 함수가 가장 마지막 매개변수이면
// 매개변수로 받는 함수는 함수명 뒤에 {... 함수식}
//operation 대신 block을 쓰기도 함.
fun applyOperation(a: Int, b: Int, operation: (Int, Int) -> Int) : Int {
    return operation(a, b)
}

fun String.removeFirstAndLast() : String {
    return this.substring(1, this.length - 1)
}

fun main() {
    //Int 매개변수 2개를 받고, Int로 반환하는 함수 타입을 선언
    // 변수: 함수타입 = { 함수식 }
    // {매개변수 -> 식(식의결과가 반환값) }

    //람다함수(lambda function)
    // : 매개변수와 1개의 식으로 구성이 되어있고, 식의 결과가 반환값인 함수
    // : 수학적으로 함수와 일치하는 개념
    val sum: (Int, Int) -> Int = { a, b -> a + b }

    val sum2 = applyOperation(3, 4){ a, b -> a + b }
    val mul = applyOperation(3, 4){ a, b -> a * b }
//    val squareTwo = applyOperation{ a, b -> a * b } 매개변수에 디폴트값이 있으면 이렇게도 작성 가능함.

    val myString = "Hello"
    println(myString.removeFirstAndLast()) //ell


}