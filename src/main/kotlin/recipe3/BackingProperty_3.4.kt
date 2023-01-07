package recipe3

/**
 * 레시피 3.4 지원 속성 기법
 * - 클래스의 속성을 클라이언트에게 노출 하고 싶지만, 속성의 초기화/접근을 제어하고 싶을때 사용
 * - 같은 타입의 속성을 하나 더 정의하고 사용자 정의 획득자와 설정자를 이용해 원하는 속성에 접근
 */

class Customer(val name : String) {
    private var _messages : List<String>? = null // 생성 즉 시 초기화 되지 않게 널 허용 타입 추가 (lazy loading)

    val messages : List<String>
        get() {
            if(_messages == null) {
                _messages = loadMessages()
            }
            return _messages!!
        }

    private fun loadMessages() : MutableList<String> =
        mutableListOf(
            "Initial contact",
            "Convinced them to use Kotlin",
            "Sold training class. Sweet."
        ).also { println("Loaded messages")}
}