package ch07

// 자바의 인터페이스: 메서드의 설계 -> 맞춰서 구현
// 코틀린의 인터페이스: 메소드 구조(시그니처)/필드명 선언 -> 맞춰서 구현
interface IAnimal { //인터페이스에서는 보통 I를 앞에 붙임
    val name: String // 인터페이스 프로퍼티
    fun makeSound()
}
//클래스 설계자 ↑
//-----------------------------------------------
//클래스 구현 설계자 ↓

//인터페이스 구현
//class 구현클래스명 : 인터페이스명
class AnimalImpl(override val name: String) : IAnimal { //인터페이스의 필드도 오버라이드 해줘야 한다.
    override fun makeSound() { //override 한거는 무조건 붙이게 만들어져 있음. 다른 데서 갖다 써도 명확하게 나올 수 있게 했음.
        println("make sounds")
    }

}