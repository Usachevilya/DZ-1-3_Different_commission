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
                commissionCalculation(10_000_00,    "VKPay", 1222222222) +
                " копеек"
    )
}

fun commissionCalculation(transfer: Int, cardType: String = "VKPay", transferAmountPerMonth: Int = 0): Int {
    var commission = 0
    when (cardType) {
        "Master", "Maestro" -> {
            if (limit(transfer, cardType, transferAmountPerMonth) == false) {
                if (transferAmountPerMonth > maximumTransferWithZeroCommissionMasterMaestro) {
                    commission = (transfer * commissionMasterMaestro / 100 + 2000).toInt()
                }
            }
        }
        "Visa", "Mir" -> {
            if (limit(transfer, cardType, transferAmountPerMonth) == false) {
                val commisionAmount = (transfer * commissionVisaMir / 100).toInt()
                if (commisionAmount <= minimumCommissionVisaMir) {
                    commission = minimumCommissionVisaMir
                } else {
                    commission = commisionAmount
                }
            }
        }
        "VKPay" -> {
            if (limit(transfer, cardType, transferAmountPerMonth) == false) {
                commission = 0
            }
        }
    }
    return commission
}

fun limit(transfer: Int, cardType: String, transferAmountPerMonth: Int): Boolean {
    when (cardType) {
        "Master", "Maestro", "Visa", "Mir" -> {


            if (transfer >= maximumTransferAmountPerDay || transferAmountPerMonth >= maximumTransferAmountPerMonth) {
                println("Превышен лимит перевода")
                return true
            }
            return false
        }
        "VKPay" -> {
            if (transfer >= maximumTransferAmountPerDayVK || transferAmountPerMonth >= maximumTransferAmountPerMonthVK) {
                println("Превышен лимит перевода")
                return true
            }
            return false
        }
    }
    println("Не правильно выбрана карта")
    return false
}