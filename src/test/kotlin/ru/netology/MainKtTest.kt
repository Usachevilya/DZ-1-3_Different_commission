package ru.netology

import commissionCalculation
import junit.framework.TestCase.assertEquals
import org.junit.Test

class MainKtTest {

    @Test
    fun commissionCalculationTest_VM_Do600() {
        //arrange
        val cardType = "VisaMir"
        val transferAmountPerMonth = 10_000_00
        val transfer = 5_000_00
        //act
        val result = commissionCalculation(
            transfer,cardType, transferAmountPerMonth
        )
        //assert
        assertEquals(37, result)
    }
    @Test
    fun commissionCalculationTest_VM_3500() {
        //arrange
        val cardType = "VisaMir"
        val transferAmountPerMonth = 10_000_00
        val transfer = 1_000_00
        //act
        val result = commissionCalculation(
            transfer, cardType, transferAmountPerMonth
        )
        //assert
        assertEquals(35, result)
    }
    @Test
    fun commissionCalculationTest_VM_Exceeded_the_limit() {
        //arrange
        val cardType = "VisaMir"
        val transferAmountPerMonth = 700_000_00
        val transfer = 5_000_00
        //act
        val result = commissionCalculation(
            transfer, cardType, transferAmountPerMonth
        )
        //assert
        assertEquals(0, result)
    }


    @Test
    fun commissionCalculationTest_MM_Do600() {
        //arrange
        val cardType = "MasterMaestro"
        val transferAmountPerMonth = 10_000_00
        val transfer = 5_000_00
        //act
        val result = commissionCalculation(
            transfer, cardType, transferAmountPerMonth
        )
        //assert
        assertEquals(0, result)
    }
    @Test
    fun commissionCalculationTest_MM_Exceeded_the_limit() {
        //arrange
        val cardType = "MasterMaestro"
        val transferAmountPerMonth = 1_100_000_00
        val transfer = 1_000_000_00
        //act
        val result = commissionCalculation(
            transfer, cardType, transferAmountPerMonth
        )
        //assert
        assertEquals(0, result)
    }
    @Test
    fun commissionCalculationTest_MM_transferSum_75_000_00() {
        //arrange
        val cardType = "MasterMaestro"
        val transferAmountPerMonth = 100_000_00
        val transfer = 5_000_00
        //act
        val result = commissionCalculation(
            transfer, cardType, transferAmountPerMonth
        )
        //assert
        assertEquals(3020, result)
    }

    @Test
    fun commissionCalculationTest_VK_Do15000() {
        //arrange
        val cardType = "VKPay"
        val transferAmountPerMonth = 10_000_00
        val transfer = 5_000_00
        //act
        val result = commissionCalculation(
            transfer, cardType, transferAmountPerMonth
        )
        //assert
        assertEquals(0, result)
    }
    @Test
    fun commissionCalculationTest_VK_Exceeded_the_limit() {
        //arrange
        val cardType = "VKPay"
        val transferAmountPerMonth = 45_000_00
        val transfer = 50_000_00
        //act
        val result = commissionCalculation(
            transfer, cardType, transferAmountPerMonth
        )
        //assert
        assertEquals(0, result)
    }
}