class ValidationException(val errorCode: Array<ErrorCode>) : RuntimeException(errorCode.joinToString(",") { it.msg })

enum class ErrorCode(val code: Int, val msg: String) {
    INVALID_CHARACTER(100, "Недопустимый символ"),
    INVALID_NAME(101, "Имя не написано кирилицей"),
    INVALID_SURNAME(102, "Фамилия не написана кирилицей"),
    WRONG_NAME_LENGTH(103, "Длинна имени не должна превышать 16 символов"),
    WRONG_SURNAME_LENGTH(103, "Длинна фамилии не должна превышать 16 символов"),
    WRONG_TELEPHONE_NUMBER_LENGTH(104, "Длинна телефонного номера должна быть ровно 11 цифр"),
    INVALID_TELEPHONE_NUMBER(105, "Телефонный номер не начинается с 7 или 8"),
    INVALID_EMAIL(106, "Недопустимый формат домена"),
    WRONG_EMAIL_LENGTH(107, "Длинна эмейла не должна превышать 32 символа"),
    WRONG_SNILS_LENGTH(108, "Длина снилса должна быть ровно 11 символов"),
    WRONG_SNILS_CONTROL_NUMBER(109, "Неверное контрольное число"),
    NULL_NAME_LENGTH(110, "Имя не должно быть пустым"),
    NULL_SURNAME_LENGTH(111, "Фамилия не должна быть пустой"),
    NULL_EMAIL_LENGTH(112, "Эмейл не должен быть пустым"),
    NULL_SNILS_LENGTH(113, "СНИЛС не должен быть пустым"),
    NULL_PHONE_NUMBER_LENGTH(114, "Телефонный номер не должен быть пустым")
}
