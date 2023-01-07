package recipe3

/**
 * 레시피 3.4 지원 속성 기법
 * - BackingProperty.kt에서 설명한 것이 lazy loading을 어렵게 구현한 방법이고,
 * 코틀린에서 간단히 lazy 키워드를 사용하여 구현 할 수 있다.
 */

class Customer2(val name : String) {
    val _messages : List<String> by lazy { loadMessages() }

    private fun loadMessages() : MutableList<String> =
        mutableListOf(
            "Initial contact",
            "Convinced them to use Kotlin",
            "Sold training class. Sweet."
        ).also { println("Loaded messages")}
}