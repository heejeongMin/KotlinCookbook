package recipe3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CustomerTest {

    @Test
    fun `load messages`() {
        val customer = Customer("Fred").apply { messages } //인스턴스를 새성하면서 message를 바로 불러오기
        println(customer)
        assertEquals(3, customer.messages.size)

        val customer2 = Customer("Pancho")
        println(customer2)
        assertEquals(3, customer2.messages.size)
    }
}