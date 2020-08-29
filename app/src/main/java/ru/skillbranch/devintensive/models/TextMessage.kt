package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

class TextMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var text: String?
) : BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessage(): String {
        //2 метод должен возвращать строку,
        //2 содержащую id сообщения и имя адресата/адресанта,
        //2 виде сообщения ("получил/отправил") и
        //2 типе сообщения ("текст")
        //2 (некорректное условие) времени отправки сообщения
        return "id: $id ${from?.firstName} " +
                "${if (isIncoming) "получил" else "отправил"} " +
                "сообщение \"$text\" ${date.humanizeDiff(Date().add(1, TimeUnits.SECOND))}"
    }
}