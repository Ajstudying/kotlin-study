package ch01

fun main() {
    val name = "John" //new 생성자로 문자열 만드는게 안됨.
    val lastName = "Doe"
    val fullName = name + "Doe"

    //템플릿 리터럴
    //`${변수명(함수호출리턴값}`

    val age = 30
    //아래처럼 백틱 없이 쌍따옴표 안에 쓸 수 있다.
    val sentence = "My name is $name and I am $age years old."
    //변수값이면 $만 붙이면 되지만 식을 넣게 되면 ${"$name + "Doe"}
    //${name + lastName}

    val lowerName = "john"
    //대소문자 구분없이 문자열 비교
    lowerName.equals(name, ignoreCase = true)

}