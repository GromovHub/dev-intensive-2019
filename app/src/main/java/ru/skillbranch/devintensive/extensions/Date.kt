package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = SECOND * 60
const val HOUR = MINUTE * 60
const val DAY = HOUR * 24

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    // возвращает отформатированную дату по паттерну
    // передаваемому в качестве аргумента
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {
    //2 метод должен возвращать условное время отправки/получения сообщения
    //2 -> разницу между временем текущего экземпляра и переданным временем
    //2 в виде
    //2 -> ("только что", "$n час/часа назад", мб и другие категории)


    var timeSystem = date.time
    var timeMessage = Date().time
    var diffValue = timeSystem - timeMessage

    //relative values
    var R_SECOND = diffValue / SECOND
    val R_MINUTE = diffValue / MINUTE
    val R_HOUR = (diffValue / HOUR)
    val R_DAY = diffValue / DAY

    val humanizeDiffString: String =
        //2 вроде дорисовал
        when (diffValue) {

            in 0 until  SECOND -> "только что"
            in SECOND until (45 * SECOND) -> "несколько секунд назад"
            in (45 * SECOND) until (75 * SECOND) -> "минуту назад"
            in (75 * SECOND) until (5 * MINUTE) -> "$R_MINUTE минуты назад"
            in (5 * MINUTE) until (45 * MINUTE) -> "$R_MINUTE минут назад"
            in (45 * MINUTE) until (75 * MINUTE) -> "час назад"
            in (75 * MINUTE) until (5 * HOUR) -> "$R_HOUR часа назад"
            in (5 * HOUR) until (22 * HOUR) -> "$R_HOUR часов назад"
            in (22 * HOUR) until (26 * HOUR) -> "день назад"
            in (26 * HOUR) until (5 * DAY) -> "$R_DAY дня назад"
            in (5 * DAY) until (360 * DAY) -> "$R_DAY дней назад"
            in (360 * DAY) until (1000 * DAY) -> "более года назад"

            else -> "неизвестно когда"
        }

    return humanizeDiffString
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;
}