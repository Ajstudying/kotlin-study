package ch04

import kotlin.math.PI
import kotlin.math.round

fun sum (){
    println("첫번째 숫자를 입력하세요: ")
    var add1 = readln().toInt()
    println("두번째 숫자를 입력하세요: ")
    var add2 = readln().toInt()
    println("$add1 과 $add2 의 합은 ${add1+add2} 입니다.")
}

fun circle() {
    println("원의 넓이를 구할 반지름을 입력하세요: ")
    var radius = readln().toDouble()
    var extent = radius * radius * PI
    println(PI)
    println("$radius 의 원의 넓이는 $extent 입니다.")
}

fun even(number: Int) : Boolean {
    if(number % 2 == 0){
        return true
    }else{
        return false
    }
}

fun length(str: String) : Int{
    return str.length
}
fun combineList(list1: MutableList<Int>, list2: MutableList<Int>): List<Int>{
    val myList = list1 + list2
    println(myList)
    val joinedList = list1.union(list2)
    println(joinedList)
    println(myList.toSet())
    val seen = mutableSetOf<Int>()
    val mySet = mutableSetOf<Int>()
    return myList.filter { !mySet.add(it) }
//리스트 반환 Set으로 반환하려면 형변환 해줘야 하고, 위에 return 타입을 리스트가 아니고 Set으로 바꿔줘야 한다.
}
fun commonMultiple() : Int {
    for(i in 1 until 101){
        if(i % 3 == 0 && i % 5 == 0){
            return i
        }
    }
    return 0
}
fun factorial(number: Int) : Int{
    if(number == 0){
        return 1
    }else{
        return number * factorial(number - 1)
    }
}
//fun palindrome(str: String): Boolean {
//    val reversedStr = str.reversed()
//    return str == reversedStr
//} 이렇게 간단하게 작성 가능함.
fun palindrome(str: String): Boolean{
    var strList = str.toMutableList()
    var str1 = mutableListOf<Char>()
    for (i in str.length - 1 downTo 0){
        str1.add(str[i])
    }
    println(str1)
    // 아래의 코드를 간단하게  return strList == str1 이렇게 할 수 있음.
    if(strList == str1){
        return true
    }else{
        return false
    }
}
//val sqrtNumber = sqrt(number)
//    return (round(sqrtNumber * 100)) / 100
fun squareRoot(number: Double) : Double{
    var num = number * number
    return (round(num * 100))/100
}
//fun maxAndMin(a: Int, b: Int) {
//    val max = maxOf(a, b)
//    val min = minOf(a, b)
//    println("큰 수는 $max, 작은 수는 $min")
//}
fun maxAndMin(a: Int , b: Int){
    var max: Int
    var min: Int
    if(a > b) {
        max = a
        min = b
    }else{
        max = b
        min = a
    }
    println("큰 수는 $max, 작은 수는 $min")
}
fun main() {
//    println("숫자를 입력해주세요.")
//    var number = readln().toInt()
//    if(even(number)){
//        println("입력하신 숫자는 짝수입니다.")
//    }else{
//        println("입력하신 숫자는 홀수입니다.")
//    }

//    println("문자열을 입력하세요")
//    println("입력하신 문자의 길이는 ${length(readln())} 입니다.")

//    val list1 = mutableListOf(1,2,3,4,5)
//    val list2 = mutableListOf(4,5,6,7,8)
//    println(combineList(list1, list2))

//    println(commonMultiple())
//    println("정수를 입력해주세요.")
//    println("입력한 정수의 팩토리얼 값은 ${factorial(readln().toInt())} 입니다.")

//    println("문자를 입력해주세요")
//    var verify = if(palindrome(readln())){"맞습니다."}else{"아닙니다."}
//    println("입력한 문자는 회문이 $verify")

//    println(squareRoot(4.5678))
    maxAndMin(5,8)

}