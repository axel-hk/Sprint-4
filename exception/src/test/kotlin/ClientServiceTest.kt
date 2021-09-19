import com.google.gson.Gson
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class ClientServiceTest {

    private val gson = Gson()
    private val clientService = ClientService()

    @Test
    fun `success save client`() {
        val client = getClientFromJson("/success/user.json")
        val result = clientService.saveClient(client)
        assertNotNull(result)
    }

    @Test
    fun `fail save client - validation error`() {
        val client = getClientFromJson("/fail/user_with_bad_phone.json")
        assertThrows<ValidationException>("Ожидаемая ошибка") {
            clientService.saveClient(client)
        }
    }



    @Test
    fun `fail save client with null data`(){
        val client = getClientFromJson("/fail/user_null_data.json")
        val exception = assertFailsWith<ValidationException>("Ожидаемая ошибка") {
            clientService.saveClient(client)
        }
        assertEquals(exception.errorCode[0], ErrorCode.NULL_PHONE_NUMBER_LENGTH)
        assertEquals(exception.errorCode[1], ErrorCode.NULL_NAME_LENGTH)
        assertEquals(exception.errorCode[2], ErrorCode.NULL_SURNAME_LENGTH)
        assertEquals(exception.errorCode[3], ErrorCode.NULL_EMAIL_LENGTH)
        assertEquals(exception.errorCode[4], ErrorCode.NULL_SNILS_LENGTH)
    }

    @Test
    fun `fail with bad name`(){
        val client = getClientFromJson("/fail/user_with_bad_name.json")
        val exception = assertFailsWith<ValidationException>("Ожидаемая ошибка") {
            clientService.saveClient(client)
        }
        assertEquals(exception.errorCode[0], ErrorCode.WRONG_NAME_LENGTH)
        assertEquals(exception.errorCode[1], ErrorCode.INVALID_NAME)
    }

    @Test
    fun `fail with bad surname`(){
        val client = getClientFromJson("/fail/user_with_bad_surnam.json")
        val exception = assertFailsWith<ValidationException>("Ожидаемая ошибка") {
            clientService.saveClient(client)
        }
        assertEquals(exception.errorCode[0], ErrorCode.WRONG_SURNAME_LENGTH)
        assertEquals(exception.errorCode[1], ErrorCode.INVALID_SURNAME)
    }
    @Test
    fun `fail with bad email`(){
        val client = getClientFromJson("/fail/user_with_bad_email.json")
        val exception = assertFailsWith<ValidationException>("Ожидаемая ошибка") {
            clientService.saveClient(client)
        }
        assertEquals(exception.errorCode[0], ErrorCode.WRONG_EMAIL_LENGTH)
        assertEquals(exception.errorCode[1], ErrorCode.INVALID_EMAIL)
    }
    @Test
    fun `fail with bad snils`(){
        val client = getClientFromJson("/fail/user_with_bad_snils.json")
        val exception = assertFailsWith<ValidationException>("Ожидаемая ошибка") {
            clientService.saveClient(client)
        }
        assertEquals(exception.errorCode[0], ErrorCode.WRONG_SNILS_LENGTH)
        assertEquals(exception.errorCode[1], ErrorCode.WRONG_SNILS_CONTROL_NUMBER)
    }

    private fun getClientFromJson(fileName: String): Client = this::class.java.getResource(fileName)
        .takeIf { it != null }
        ?.let { gson.fromJson(it.readText(), Client::class.java) }
        ?: throw Exception("Что-то пошло не так))")

}