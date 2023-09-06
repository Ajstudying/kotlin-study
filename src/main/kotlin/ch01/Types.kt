package ch01

fun main() {
    //코틀린의 기본타입은 모두 객체 -> 객체.함수를 자유롭게 사용이 가능. 그렇다고 참조형은 아님 클래스형
    val intValue : Int //타입은 모두 대문자
    intValue = 42
//    val longValue : Long = 42
    val longValue : Long = 42L //이렇게 값을 명확하게 넣어주는게 좋다.

    //변수의 메서드를 호출해서 자유롭게 형변환, 연산처리가 가능함.
    intValue.toLong().toString()

    //실수 자료형
    val floatValue : Float = 3.14f
    val doubleValue : Double = 3.14

    //문자형
    val charValue : Char = 'A'

    //부울형
    val booleanValue : Boolean = true

    //문자형
    val stringValue : String = "Hello, Kotlin"
    val stringValue2 : String = "Hello, Kotlin"

    //기본 자료형이 클래스 타입이지만
    // 어떤 상황이던지 동등비교 연산을 사용할 수 있다.
    if(stringValue == stringValue2){
        println(true)
    }

}