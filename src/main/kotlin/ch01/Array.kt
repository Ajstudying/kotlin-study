package ch01

fun main() {
    //{ }
    //init: (Int) -> Int : 초기화 함수
    //IntArray(size) {초기화 함수}
    //초기화 방법 첫번째 IntArray 생성자 사용
    val intArray = IntArray(5){ 0 } //초기값을 0으로 초기화한 배열 {it -> it + 1} 같은 코드가 많음.
    //it 첫번째 매개변수
    //IntArray()<- 생성자명 {} <- 안에 함수식 이런식의 구조가 많음.

    //초기화 방법 두번째
    val intArray2 = intArrayOf(1, 2, 3, 4, 5) //초기값을 가지는 배열, 만드는 데 크기적 제한이 없음

    //인덱스로 요소 접근
    intArray2[2]
    intArray2[3] = 3

    //반복 순회(js 객체 속성 반복자와 비슷함)
    for(intVal in intArray2){
        println(intVal)
    }

    val intArray3 : IntArray? = null //이렇게 해야만 null초기화가 가능.


}