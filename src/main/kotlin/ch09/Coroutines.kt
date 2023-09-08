package ch09

import kotlinx.coroutines.*
import java.time.Duration
import java.time.LocalDateTime

//프로세스: 프로그램을 실행해서 메모리에 올라간 것을 프로세스
//스레드: 프로세스의 실행단위를 나눈 것. - 자바 메모리를 많이 먹음.
//컨텍스트: 다중 작업을 싱글스레드로 처리하기 위한 기법(시간분할)
//-------
//코루틴: 스레드가 기본적으로 리소스소모(메모리소모/cpu 리소스 소모가 큼.)가 많기 때문에, 좀 더 작은 단위로 나눈 것
//동시에 여러개의 작업을 처리하기 위한 방법

//1작업시작 -> 1작업끝 -> 2번 작업시작 -> 2번 작업 끝
//1번작업의 완료가 2번 작업에 영향 미침(의존성 관계)

//1번 작업 시작 -> 끝
//2번 작업 시작 -> 끝
// 1/2번 작업간에는 의존관계가 없음
//나눠서 처리한 작업의 결과를 UI에서 보여주거나, 결과 저장하거나 이럴 때 한 번에 보여줘야 함.

//아래의 작업을 프레임 워크에서 해줘서 그동안 스레드 관리를 안해도 됐음.
//a 사람이 첫번째 API 호출 - thread 1
//a 사람이 두번째 API 호출 - thread 2
//b 사람이 첫번째 API 호출 - thread 3
//스피링MVC - 스레드풀을 500
fun main() {
    val start = LocalDateTime.now()
    //코루틴들이 모두 끝날 때까지 현재 스레드에서 대기 - 1500L이 끝나고 실행됨.
    runBlocking {
        //코루틴을 실행
        launch {
            delay(500L)
            println("launch - ${Thread.currentThread().name}")
        }
        launch {
            delay(1500L) // 이 작업이 가장 마지막에 끝나고 오래걸리는 작업.
        }
        launch {
            delay(700L)
        }
        launch {
            delay(100L)
        }
        println("runBlocking - ${Thread.currentThread().name}")
    }
    //- 1500L이 끝나고 실행됨.
    val end = LocalDateTime.now()
    println(Duration.between(start, end).toMillis())
}