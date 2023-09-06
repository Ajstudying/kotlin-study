package ch02

// fun 함수명(매개변수) : 반환타입 {...}
// 글로벌 함수 => 메인에 가서도 사용 가능.
// 클래스, 객체 내부에 있지 않은 함수
fun add(a: Int, b: Int): Int {
    return a + b
}

//단일 표현식 함수
//함수 본체가 1개의 식과 식의 결과가 반환값인 경우
fun addInline(a: Int, b: Int) = a + b

fun printInfo(firstName: String, lastname: String, age: Int){
    println("$firstName $lastname is $age years old.")
}

//vararg : 매개변수의 갯수가 variable하다. 매개변수가 가변인자 => 배열처럼 작동됨.
fun sum(vararg numbers : Int ): Int {
    //가변인자는 배열처럼 인식됨.
    return numbers.sum()
}

//디폴트 매개변수
fun greet(name : String = "Guest"){
    println("Hello, $name")
}

//확장 함수(Extension Function)
//상속없이 메서드만 추가해서 사용 가능함.
fun String.addExclamation() : String {
    return "$this!"
}

fun main() {
    println(add(1,2))
    println(addInline(1, 2))
    greet()
    greet("John")

    //명명된 인자(Named Argumaents)
    printInfo(age = 10, lastname = "Doe", firstName = "John")
    //값만 넣으려면 순서는 맞춰줘야 함.
    printInfo("John", "Bill", 10)
    printInfo("John", "Bill", age = 10)

    sum(1, 2)
    sum(1,2,3,5,6)

    //문자열의 기본함수만 쓸 수 있는 게 아니라, 추가적으로 함수를 등록할 수 있음
    //**외부라이브러리 참조한 클래스의 메서드를 소스코드 안 고치고 추가할 수 있다.
    // HttClient.get(url : String) {} << 이렇게 사용 가능. 상속을 거칠 필요 없이 확장함수를 쓰면 된다.
    val str = "Hello"
    println(str.addExclamation())
}