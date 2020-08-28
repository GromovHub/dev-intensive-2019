package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?) : Pair<String?, String?> {
        //TODO FIX ME (победи null)
        val parts = fullName?.split(" ")

        val firstName = parts?.getOrNull(0) ?:"Unknown"
        val lastName = parts?.getOrNull(1) ?:"Unknown"

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " ") {
//TODO реализовать эту шнягу
    }

    fun toInitials(firstName: String?, lastName: String?) {
//TODO реализовать эту шнягу
    }
}
