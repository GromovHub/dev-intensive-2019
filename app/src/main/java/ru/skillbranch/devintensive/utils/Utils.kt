package ru.skillbranch.devintensive.utils

import java.io.Serializable

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        //Необходимо реализовать утилитный метод parseFullName(fullName)
        // принимающий в качестве аргумента полное имя пользователя
        // и возвращающий пару значений "firstName lastName"

        val parts = fullName?.split(" ")

        val firstName = parts?.getOrNull(0) ?: null
        val lastName = parts?.getOrNull(1) ?: null

        return firstName to lastName //Pair
    }

    fun transliteration(payload: String, divider: String = " ") {
        //Реализуй метод принимающий в качестве аргумента строку (divider по умолчанию " ")
        // и возвращающий преобразованную строку из латинских символов,
        // словарь символов соответствия алфовитов доступен в ресурсах к заданию
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
