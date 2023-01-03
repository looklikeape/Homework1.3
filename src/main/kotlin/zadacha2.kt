fun main() {
    val result = feeCalculation(transferAmount = 1251)
    println("размер комиссии составит: $result")
}

fun feeCalculation(payType: String = "VK pay", currentMonthTransfer: Int = 0, transferAmount: Int): Any {
    val feeAmount = when {
        payType == "VISA" && transferAmount * 0.075 > 35 -> 0.075 * transferAmount
        payType == "VISA" && transferAmount * 0.075 <= 35 -> 35
        payType == "MIR" && transferAmount * 0.075 > 35 -> 0.075 * transferAmount
        payType == "MIR" && transferAmount * 0.075 <= 35 -> 35
        payType == "VK pay" -> 0
        payType == "Mastercard" && currentMonthTransfer > 75000 -> 0.06 * transferAmount + 20
        payType == "Mastercard" && currentMonthTransfer <= 75000 -> 0
        payType == "Maestro" && currentMonthTransfer > 75000 -> 0.06 * transferAmount + 20
        payType == "Maestro" && currentMonthTransfer <= 75000 -> 0

        else -> {
            "некорректный ввод"
        }
    }
    return feeAmount
}