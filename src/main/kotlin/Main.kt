
val feeVisaMir = 0.75

fun main() {
    println("Коммиссия составила: " +
            commissionCalculation(100_000_00) +
            " рублей")

    }

fun commissionCalculation (transfer: Int, cardType: String = "VKPay", transferAmountPerMonth: Int = 0): Int {
    var commission = 0
    when(cardType) {
        "Master", "Maestro" -> {
            if(transfer <= 150_000_00 && transferAmountPerMonth <= 600_000_00){
                if (transferAmountPerMonth > 75_000_00) {
                commission = (transfer * 0.6 / 100 +20).toInt()
                }
            } else println("Привышен лимит перевода")
        }
        "Visa", "Mir" -> {
            if (transfer <= 150_000_00 && transferAmountPerMonth <= 600_000_00) {
                val commisionAmount = (transfer * feeVisaMir / 100).toInt()
                if (commisionAmount <= 35_00) {
                    commission = 35_00/100
                } else {
                    commission = commisionAmount / 100
                }
            } else {
                println("Привышен лимит перевода")
            }
        }
        "VKPay" -> {
            if (transfer <= 15_000_00 && transferAmountPerMonth <= 40_000_00 ) {
                commission = 0
            } else println("Привышен лимит перевода")
        }
    }
    return commission
}