package ru.skillbranch.devintensive.utils

import java.io.Serializable

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        //Необходимо реализовать утилитный метод parseFullName(fullName)
        // принимающий в качестве аргумента полное имя пользователя
        // и возвращающий пару значений "firstName lastName"
        if (fullName == null) {
            val firstName = null
            val lastName = null
            return Pair(firstName, lastName)
        } else
            if (fullName.trim() == "") {
                val firstName = null
                val lastName = null
                return Pair(firstName, lastName)
            } else {
                val parts = fullName.split(" ")

                val firstName = parts.getOrNull(0)
                val lastName = parts.getOrNull(1)

                return firstName to lastName //Pair
            }


    }

    fun transliteration(payload: String, divider: String = " ") : String =
        //Реализуй метод принимающий в качестве аргумента строку (divider по умолчанию " ")
        // и возвращающий преобразованную строку из латинских символов,
        // словарь символов соответствия алфовитов доступен в ресурсах к заданию



         payload.replace(Regex("[а-я]")) {
            when (it.value) {
                "а" -> "a"
                "б" -> "b"
                "в" -> "v"
                "г" -> "g"
                "д" -> "d"
                "е" -> "e"
                "ё" -> "e"
                "ж" -> "zh"
                "з" -> "z"
                "и" -> "i"
                "й" -> "i"
                "к" -> "k"
                "л" -> "l"
                "м" -> "m"
                "н" -> "n"
                "о" -> "o"
                "п" -> "p"
                "р" -> "r"
                "с" -> "s"
                "т" -> "t"
                "у" -> "u"
                "ф" -> "f"
                "х" -> "h"
                "ц" -> "c"
                "ч" -> "ch"
                "ш" -> "sh"
                "щ" -> "sh'"
                "ъ" -> ""
                "ы" -> "i"
                "ь" -> ""
                "э" -> "e"
                "ю" -> "yu"
                "я" -> "ya"
                else -> it.value
            }
        }



    fun toInitials(firstName: String?, lastName: String?): String? {
//Реализуй метод Utils.toInitials(firstName lastName)
// принимающий в качестве аргументов имя и фамилию пользователя (null, пустую строку)
// и возвращающий строку с первыми буквами имени и фамилии в верхнем регистре
// (если один из аргументов null то вернуть один инициал,
// если оба аргумента null вернуть null)

        if (firstName == null && lastName == null) {
            return null
        } else
            if (firstName != null && lastName == null) {
                return "${firstName.toCharArray().first().toUpperCase()}"
            } else
                if (firstName != null && lastName?.trim() == "") {
                    return "${firstName.toCharArray().first().toUpperCase()}"
                } else
                    if (firstName?.trim() == "" && lastName?.trim() == "") {
                        return null
                    } else
                        if (firstName != null && lastName != null) {
                            return "${firstName.toCharArray().first().toUpperCase()}" +
                                    "${lastName.toCharArray().first().toUpperCase()}"
                        } else return null
    }
}
