package ch06

fun main() {
    //mapof(키 to 값......)
    val person = mapOf("name" to "Alice", "age" to 30)
    val person2 = mutableMapOf<String, Any>() //초기값 없을 때
    person2["name"] = "Alice"
    person2["age"] = 30

    for (key in person2.keys) {
        println(person2[key])
    }
    val num = person2["age"].toString().toInt() +  3 //Any 타입이다 보니 이렇게 타입을 바꿔줘야 한다.
    println(num)

    val people = mutableListOf<MutableMap<String, Any>>()
    people.add(mutableMapOf("name" to "Alice", "age" to 30))
    people.add(mutableMapOf("name" to "Bob", "age" to 30))
}