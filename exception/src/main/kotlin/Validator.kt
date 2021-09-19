abstract class Validator<T> {
    abstract fun validate(value: T?): List<ErrorCode>
}

class PhoneValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val result = mutableListOf<ErrorCode>()
        if(value.isNullOrEmpty()) result.add(ErrorCode.NULL_PHONE_NUMBER_LENGTH)
        else if(value?.length!=11) result.add(ErrorCode.WRONG_TELEPHONE_NUMBER_LENGTH)
        else if(!Regex("""[7,8]\d{10}""").matches(value.orEmpty())) result.add(ErrorCode.INVALID_TELEPHONE_NUMBER)
        return result
    }
}

class NameValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val result = mutableListOf<ErrorCode>()
        if(value.isNullOrEmpty()) result.add(ErrorCode.NULL_NAME_LENGTH)
        else {
            if (value.length > 16 ) result.add(ErrorCode.WRONG_NAME_LENGTH)
            if(!Regex("""[а-яёА-ЯЁ]{1,16}""").matches(value.orEmpty())) result.add(ErrorCode.INVALID_NAME)
        }
        return result
    }
}

class SurNameValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val result = mutableListOf<ErrorCode>()
        if(value.isNullOrEmpty()) result.add(ErrorCode.NULL_SURNAME_LENGTH)
        else {
            if (value.length > 16 ) result.add(ErrorCode.WRONG_SURNAME_LENGTH)
            if(!Regex("""[а-яёА-ЯЁ]{1,16}""").matches(value.orEmpty())) result.add(ErrorCode.INVALID_SURNAME)
        }
        return result
    }
}
class EmailValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val result = mutableListOf<ErrorCode>()
        if(value.isNullOrEmpty()) result.add(ErrorCode.NULL_EMAIL_LENGTH)
        else {
            if (value.length > 32 ) result.add(ErrorCode.WRONG_EMAIL_LENGTH)
            if(!Regex("""\w+([.-]?\w+)*@\w+([.-]?\w+)*\.\w{2,4}""").matches(value.orEmpty())) result.add(ErrorCode.INVALID_EMAIL)
        }
        return result
    }
}

class SnilsValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val result = mutableListOf<ErrorCode>()
        if(value.isNullOrEmpty()) result.add(ErrorCode.NULL_SNILS_LENGTH)
        else {
            if (value.length > 11 ) result.add(ErrorCode.WRONG_SNILS_LENGTH)
            if(!isValid(value.orEmpty())) result.add(ErrorCode.WRONG_SNILS_CONTROL_NUMBER)
        }
        return result
    }
    fun isValid(snils: String):Boolean{
        var sum = 0
        val controlNumber = snils.substring(9,11)
        val numbers = snils.substring(0,9)
        if (snils.length!=11) return false
        else{
            for(i in 1..9){
                sum+= numbers[9-i].digitToInt()*i
            }

            while (sum > 99) {
                when (sum) {
                    100 -> sum = 0
                    101 -> sum = 0
                    else -> sum %= 101
                }
            }

        }
        return sum==controlNumber.toInt()
    }

}