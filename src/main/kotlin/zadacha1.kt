fun main() {
    val timeAgo = 3600 * 5 //ввод секунд
    val message = agoToText(timeAgo)
    println("был в сети: $message")
}

fun agoToText(timeAgo: Int): String {

    val timeAgoMessage = when {
        timeAgo in 0..59 -> "только что"
        timeAgo in 60..3599 -> "${minuteText(timeAgo)} назад"
        timeAgo >= 3600 && timeAgo < 3600 * 24 -> "${hourText(timeAgo)} назад"
        timeAgo >= 3600 * 24 && timeAgo <= 3600 * 24 * 2 -> "вчера"
        timeAgo >= (3600 * 24) * 2 + 1 && timeAgo <= (3600 * 24) * 3 -> "позавчера"
        else -> "давно"
    }
    return timeAgoMessage
}

fun minuteText(timeAgo: Int): String {
    val minuteVal = timeAgo / 60
    val lastChar = minuteVal % 10
    val last2Char = minuteVal % 100
    val minuteEnding = when (timeAgo in 60..3599) {
        (lastChar == 1 && last2Char != 11) -> "$minuteVal минуту"
        (lastChar in 2..4 && last2Char !in 12..14) -> "$minuteVal минуты"
        else -> "$minuteVal минут"
    }
    return minuteEnding
}

fun hourText(timeAgo: Int): String {
    val hourVal = timeAgo / 3600
    val lastChar = hourVal % 10
    val last2Char = hourVal % 100
    val hourEnding = when (timeAgo in 3600 until (3600 * 24) - 1) {
        (lastChar == 1 && last2Char != 11) -> "$hourVal час"
        (lastChar in 2..4 && last2Char !in 12..14) -> "$hourVal часа"
        else -> "$hourVal часов"
    }
    return hourEnding
}