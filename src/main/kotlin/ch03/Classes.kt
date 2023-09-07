package ch03

import java.awt.event.FocusEvent.Cause

//코틀린의 클래스
//기본적으로 public
// Person("", 0)
//Person(val name: String, var age: Int) 그냥 대문자로 시작하는 함수라고 생각하면 편하다.
// 위의 내용은 생성자 선언 겸 필드 선언이 됨.
class Person(
    val name: String, //초기화 이후에 변경불가(immutable)한 필드
    var age: Int = 20 //변경 가능한 (mutable) 필드
){
    fun introduce(){
        println("Hello, I am $name and I am $age years old")
    }
} //클래스에 필드와 생성자만 필요하면 {}는 필요없이 위에 괄호만 선언하면 된다.

//코틀린에서 클래스는 기본적으로 public -> 가져다 쓰는게 가능함
//기본적으로 final -> 상속(extends)해서 사용이 불가능함. 자바도 final class는 상속X
class VisibilityDemo {
    //클래스 외부에서 접근 가능
    val publicVar = "I am public"
    // 클래스 내부에서만
    private val privateVar = "I am private"
    // 모듈 내부에서만 접근 가능
    // sw: module(변수집합, 함수집합, 클래스+함수... 코드의 집합을 모듈)
    // internal 키워드의 모듈: 코틀린 프로젝트 단위
    internal val internalVar = "I am internal"
    // private + 상속 받은 클래스에서 사용 가능.
    //기본클래스( class, public + final)
    protected val protectedVar = "I am protected" //클래스 앞에 open을 붙여 상속이 되어야 protected 단위가 되고, 아니면 private와 동일.
}

class Calculator(val name: String){
    fun printName (){
        println("calc name is $name")
    }
    //싱글턴으로 구현되는 내부 클래스
    //자바 호출방식: Calculator.Operation.getInstance().add(3,4)
    // 자바의 static 키워드 처럼 쓸 수 있는데, 중요한 것은 성능적인 관점에서 싱글턴처럼 작동
    companion object{//스테틱 매서드로 쓰고 싶은 애들만 companinon object를 붙여서 사용
        fun add(a: Int, b: Int): Int {
            return a + b
        }
    }
}
fun main() {
    val person = Person("Alice", 30)
//    person.name = "John" //변경 불가
    person.age = 31 //변경 가능

    person.introduce()
    //named parameter 명명된 매개변수
    val person2 = Person(age = 30, name="John") //new키워드 없이 생성.
    //default value 가 있는 매개변수 제외
    val person3 = Person("Mary")
    person3.age = 33

    var calc = Calculator("공학계산기")
    println(calc.printName())

    println(Calculator.add(2,3))
}