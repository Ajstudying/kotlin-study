package ch05

//메서드 없이 필드값만 사용하는 클래스
// val p = Person("Alice", 30)
//자바에서 println(p) // Person@ah9393h 참조값
//롬복으로 toString()을 쓸 수 있게 됐던 것. @Data -> toString() -> Person(name="Alice", age=30)

//data class 아래의 기능을 쓰지 않아도 쓸 수 있게 만들어줌.
//toString(필드출력), copy(필드카피), equals(필드레벨비교)
// --------------------------------------
// componentN()(필드의 순서)-구조분해할당과 연관, hashCode
// 함수를 생성해줌
// 데이터이기 때문에 참조가 기준이 아닌, 필드값으로 처리되는 함수를 만들어줌.
data class Person(val name: String, val age : Int)
fun main() {
    //객체 생성
    val person1 = Person("Alice", 30)
    val person2 = Person("Bob", 40)
    val person3 = Person("Alice", 30)

    //toString 구현됨
    println(person1)

    //필드 값 수준의 동등비교
    println(person1 == person3)
    println(person1 == person2)

    //js
    //const arr = [1 ,2]
    //const [first, second] = arr;
    //코틀린은 componentN() 이 함수가 자동으로 되기 때문에 아래처럼 사용할 수 있다.
    val (name, age) = person1
    println(name)
    println(age)

    //copy
    val person4 = person1.copy(age = 35)
    println(person4)
}