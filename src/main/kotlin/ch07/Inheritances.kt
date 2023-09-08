package ch07

//덮어씌우고 싶으면 아래처럼 오픈해서 쓰고, 그게 아니면 확장함수를 써라. 라는 의미로 아래처럼 만들어짐.
//함수를 덮어씌우고 싶으면 함수도 open 해야함. 클래스만 오픈해서는 함수는 변경이 안됨.
open class Animal(val name: String) {
    open fun sound() {
        println("$name makes a sound")
    }
}

//상속
//class 자식클래스: 부모클래스 생성자 호출 구문
class Dog(name: String) : Animal(name) { //이렇게 명시적으로 해줘야 함.
    override fun sound() {
        println("$name barks")
    }
}

fun main() {
    val myAnimal = Animal("Cat")
    myAnimal.sound()

    val myDog = Dog("Dog")
    myDog.sound()
}