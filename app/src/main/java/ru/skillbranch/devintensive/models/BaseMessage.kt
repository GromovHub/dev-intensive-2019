package ru.skillbranch.devintensive.models

import java.util.*

abstract class BaseMessage(
    //2 поля созданы согласно второму заданию
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
) {
    abstract fun formatMessage(): String
    //2 заготовка бстрактного метода
    //2 переопределение происходит в классах
    //2 -> TextMessage.kt
    //2 -> ImageMessage.kt

    companion object AbstractFactory {
        //2 паттерн AbstractFactory с методом makeMessage,

        var lastId = -1
        fun makeMessage(
            from: User?, //2 принимает объект User создателя сообщения
            chat: Chat, //2 чат, содержащий сообщение
            date: Date = Date(), //2 дату сообщения
            type: String = "text", //2 тип сообщения
            payload: Any? = "valiable", //2 полезную нагрузку
            isIncoming: Boolean = false //2 (некорректное условие)
        ): BaseMessage {
            lastId++
            return when (type) {
                "image" -> ImageMessage(
                    "$lastId",
                    from,
                    chat,
                    date = date,
                    image = payload as String
                )
                else -> TextMessage(
                    "$lastId",
                    from,
                    chat,
                    date = date,
                    text = payload as String
                )
            }
        }
    }
}
