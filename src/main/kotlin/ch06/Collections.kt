package ch06

data class Person(val name: String, val age: Int)
fun main() {
    //요소를 변경가능한 컬렉션(리스트)
    val mutableList = mutableListOf(1,2,3,4)
    //요소 추가
    mutableList.add(5)
    //요소 삭제
    mutableList.removeAt(0) // 인덱스 지우기
    mutableList.remove(1) //해당 값 지우기

    //mutableListOf이 아니고 ListOf를 쓰면 remove가 되지 않는다.
    val people =
        mutableListOf<Person>(Person("Alice", 30),
            Person("Bob",35),
            Person("John",32))

//    people.remove(Person("Alice", 30))
//    people.removeAt(0)

    // Person 빈 목록 리스트
//    var people = mutableListOf<Person>()

    //변경 불가한 리스트
//    val people =
//        listOf(Person("Alice", 30),
//            Person("Bob",35),
//            Person("John",32))
    //요소접근
    mutableList.get(1) //자바스타일 컬렉션(리스트) 요소접근
    mutableList[1] //배열처럼 인덱스로 접근

    //map
    // 이름 목록, List<String>
    // js 스타일 val names = People.map{ p -> p.name}

    //람다함수에서 매개변수가 1개이면 it으로 사용할 수 있음.
    val names = people.map{ it.name }

    //sort
    //나이기준으로 정렬된 List<Person>
    val sortedByAge = people.sortedBy { it.age }

    //find
    //이름으로 찾은 Person 객체 반환, 없을스도 있기 때문에 안에서는 실제로 Person? <<이 형식으로 돌아감.
    val findByName = people.find{ it.name == "Alice" }

    //filter
    val youngPeople = people.filter { it.age < 30 }

    //groupBy
    //Map<그룹핑값, 그룹핑된 객체목록>
    //Map<Int, List<Person>>
    val groupByAge = people.groupBy { it.age }

    println("------------")
    for (group in groupByAge){
        println("age: ${group.key}")
        for(person in group.value){
            println(person)
        }
    }

}