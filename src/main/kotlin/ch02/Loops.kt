package ch02

fun main() {
    //요소가 여러개인 객체를 탐색
    val arr = intArrayOf(1, 2, 3)
    for(num in arr){
        println(num)
    }
    //forEach, for(let i=0; i < 5; i++){}
    //범위를 이용한 반복문 1..5 < 이렇게 쓰면 다섯번 반복을 할 수 있다..
    for(i in 1..5){
        println(i)
    }
    //2씩 증가하는 것
    for(i in 1..5 step 2){
        println(i)
    }
    //-로 돌리는 반복문(하향식) (여기도 step이 가능함)
    for(i in 10 downTo 1){
        println(i)
    }

    arr.forEach { number -> println(number) }
    arr.forEachIndexed() { index, number -> println("$index, $number") }

}