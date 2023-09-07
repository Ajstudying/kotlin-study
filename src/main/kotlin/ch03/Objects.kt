package ch03


//자바의 싱글턴 생성패턴을 사용하는 클래스를
//object 키워드로 선언할 수 있음. 근데 사용은 static처럼 .찍고 메서드 사용! 처럼 사용하면 된다.
//코틀린에서는 static과 싱글턴을 합침.
//static처럼 키워드만으로 선언이 편하고, 코드작성 생산성 메모리사용 최적화는 싱글턴처럼 가능하게 해놓음.
object Singleton {
    var value : String = "I am a singleton!"

    fun showMessage() {
        println("Message from singleton: $value")
    }
}

fun main() {
    Singleton.showMessage() //원래는 Singleton.getinstance().showMessage() 이렇게 써야 하는데 코틀린에서는 getinstance()를 안 씀
    Singleton.value = "New value"
    Singleton.showMessage()

    //object expression(객체 표현식)
    // js: 변수 = 함수식, 함수 표현식
    //코틀린: 변수 = 객체식, 객체 표현식
    val myObject = object {
        var value : String = "I am a annonymouse object"

        fun showMessage(){
            println("Message from annonymouse object: $value")
        }
    }

    myObject.showMessage()
}