var commissionVisaMir = 0.75
var commissionMasterMaestro = 0.6
val maximumTransferAmountPerDay = 150_000_00
val maximumTransferAmountPerMonth = 600_000_00
val minimumCommissionVisaMir = 35_00
val maximumTransferWithZeroCommissionMasterMaestro = 75_000_00
val maximumTransferAmountPerDayVK = 15_000_00
val maximumTransferAmountPerMonthVK = 40_000_00


fun main() {
    println(
        "Коммиссия составила: " +
                commissionCalculation(100_000_00) +
                " рублей"
    )
}

fun commissionCalculation(transfer: Int, cardType: String = "VKPay", transferAmountPerMonth: Int = 0): Int {
    var commission = 0
    when (cardType) {
        "Master", "Maestro" -> {
            if (transfer <= maximumTransferAmountPerDay && transferAmountPerMonth <= maximumTransferAmountPerMonth) {
                if (transferAmountPerMonth > maximumTransferWithZeroCommissionMasterMaestro) {
                    commission = (transfer * commissionMasterMaestro / 100 + 2000).toInt()
                }
            } else println("Превышен лимит перевода")
        }
        "Visa", "Mir" -> {
            if (transfer <= maximumTransferAmountPerDay && transferAmountPerMonth <= maximumTransferAmountPerMonth) {
                val commisionAmount = (transfer * commissionVisaMir / 100).toInt()
                if (commisionAmount <= minimumCommissionVisaMir) {
                    commission = minimumCommissionVisaMir
                } else {
                    commission = commisionAmount
                }
            } else {
                println("Превышен лимит перевода")
            }
        }
        "VKPay" -> {
            if (transfer <= maximumTransferAmountPerDayVK && transferAmountPerMonth <= maximumTransferAmountPerMonthVK) {
                commission = 0
            } else println("Превышен лимит перевода")
        }
    }
    return commission
}