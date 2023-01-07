package recipe3

/**
 * 레시피 3.6 나중 초기화를 위한 lateinit 사용
 * - 생성자에 속성 초기화를 위한 정보가 충분하지 않으면 해당 속성을 널 비허용 속성으로 만들고 싶은 경우
 *   속성에 lateinit 변경자를 사용할 수 있다.
 * - lateinit은 꼭 필요한 경우에만 사용하는 것이 좋다. 대안으로 지연 평가를 고려 (레시피 8.2)
 * - lateinit은 클래스 바디에서만 선언할 수 있고, 커스텀 getter/setter가 없는 var 속성에서만 사용가능하다
 * - lateinit을 사용할 수 있는 속성은 널 할당이 불가능한 타입만 가능하다.
 * - lateinit을 원시타입에 사용할 수 없다
 * - lateinit을 추가하면 해당 변수가 처음 사용되기 전에 초기화 할 수 있다.
 * - lateinit이 추가된 속성을 사용 전 초기화에 실패하는 경우 에러가 발생한다. (UninitializedPropertyAccessException)
 * - isInitialized를 사용하여 해당 속성이 초기화 되었는지 알 수 있다.
 *
 * lateinit과 lazy의 차이
 * - lateinit 변경자는 레시피 3.6에서 설명한 제약 사항과 함께 var 속성에 사용된다.
 * - lateinit은 속성에 접근할 수 있는 모든 곳에서 초기화 할 수 있기때문에 아래 예제처럼 객체 바깥에서도 초기화가 가능하다.
 *
 * - lazy 대리자는 속성에 처음 접근할때 평가되는 람다를 받는다 (???)
 * - 초기화 비용이 높은경우 lazy를 사용하면 초기화에 실패할 수 있다.
 * - lazy는 val 속성에 사용할 수 있다.
 * - lazy 추가 설명은 8.2 참고
 */

fun main() {
    LateInitDemo().initializeName()
}
class LateInitDemo {
    lateinit var name : String

    fun initializeName() {
        println("Before assignment: ${::name.isInitialized}")
        name = "World"
        println("After assignment: ${::name.isInitialized}")
    }
}