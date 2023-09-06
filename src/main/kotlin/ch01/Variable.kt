package ch01

fun main() {
    //코틀린 변수, 불변변수/가변변수

    //가변변수(variable)
    var mutableVar = 10 //변수선언 및 대입, 타입 추론(type inference)
    //타입추론
    //변수의 대입 값에 따라서 타입이 지정됨
    //var mutableVar : Int = 10 // 타입 작성시 이렇게, mutableVar에 문자열을 넣으면 오류가 생김. 타입 고정.

    //불변변수(value)
    val immutableVar = 20

    //----------------------------------------------------

    //코틀린에서는 var/val 변수명 : 타입
    // null이 가능한 타입과 null이 불가능한 타입 분리
    // 자바: int 기본값 0, Int 기본이 null

//    var str : String = null //기본적으로 모든 타입은 null이 불가능하다.

    //null이 불가능하기 때문에 null체크 필요가 없음. 물음표가 없으면 null체크 안해도 됨.
    var str2 : String = ""

    //null을 사용하려면 타입 뒤에?를 붙임 -> null체크 해야 함. 물음표가 있으면 null가능.
    var nullableStr : String? = null

}