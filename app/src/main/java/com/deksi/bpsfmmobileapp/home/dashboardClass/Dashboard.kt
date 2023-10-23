package com.deksi.bpsfmmobileapp.home.dashboardClass

class Dashboard {

    var message: String = ""
    var success: Boolean = true

    class transferObject {
        val accountsCount: Int = 0
        val serviceRequestCount: Int = 3
        val vendorsCount: Int = 1
        val revenueSummaries: List<revenueSummaries> = listOf()
        val sumOfServiceRequests: Int = 7
        val sumOfTotalExpenses: Int = 11719
        val sumOfPreviousYear: Double = 459.5541604185411
        val powerCuts: List<powerCuts> = listOf()
        val powerCutsNum: List<powerCutsNum> = listOf()
        val energySavings: List<energySavings> = listOf()
        val carbonSavings: List<carbonSavings> = listOf()
        val costSavings: List<costSavings> = listOf()
        val received: List<received> = listOf()
        val totalConsumption: List<totalConsumption> = listOf()

        class totalConsumptionSeparated {
            val gridTotalConsumption: List<gridTotalConsumption> = listOf()
            val solarTotalConsumption: List<solarTotalConsumption> = listOf()
        }

        val expected: List<expected> = listOf()
        val expectedDiesel: List<expectedDiesel> = listOf()
        val revenue: Int = 5600
    }

    data class revenueSummaries (
        var facilityIdFormatted: String,
        var facilityName: String,
        var category: String,
        var serviceType: String,
        var serviceRequestNos: Int,
        var totalExpense: Int,
        var previousYear: Int
    )

    data class powerCuts (
        var currentValue: Int,
        var previousValue: Int,
        var percentageDiff: Int,
        var name: String,
        var cost: Int,
        var energy: Int,
        var ts: String
    )

    data class powerCutsNum (
        var currentValue: Int,
        var previousValue: Int,
        var percentageDiff: Int,
        var name: String,
        var cost: Int,
        var energy: Int,
        var ts: String

    )

    data class energySavings (
        var currentValue: Int,
        var previousValue: Int,
        var percentageDiff: Int,
        var name: String,
        var cost: Int,
        var energy: Int,
        var ts: String

    )

    data class carbonSavings (
        var currentValue: Int,
        var previousValue: Int,
        var percentageDiff: Int,
        var name: String,
        var cost: Int,
        var energy: Int,
        var ts: String

    )

    data class costSavings (
        var currentValue: Int,
        var previousValue: Int,
        var percentageDiff: Int,
        var name: String,
        var cost: Int,
        var energy: Int,
        var ts: String

    )

    data class received (
        var currentValue: Int,
        var previousValue: Int,
        var percentageDiff: Int,
        var name: String,
        var cost: Int,
        var energy: Int,
        var ts: String

    )

    data class totalConsumption (
        var currentValue: Int,
        var previousValue: Int,
        var percentageDiff: Int,
        var name: String,
        var cost: Int,
        var energy: Int,
        var ts: String

    )

    data class gridTotalConsumption (
        var currentValue: Int,
        var previousValue: Int,
        var percentageDiff: Int,
        var name: String,
        var cost: Int,
        var energy: Int,
        var ts: String

    )

    data class solarTotalConsumption (
        var currentValue: Int,
        var previousValue: Int,
        var percentageDiff: Int,
        var name: String,
        var cost: Int,
        var energy: Int,
        var ts: String

    )

    data class expected (
        var currentValue: Int,
        var previousValue: Int,
        var percentageDiff: Int,
        var name: String,
        var cost: Int,
        var energy: Int,
        var ts: String

    )

    data class expectedDiesel (
        var currentValue: Int,
        var previousValue: Int,
        var percentageDiff: Int,
        var name: String,
        var cost: Int,
        var energy: Int,
        var ts: String

    )

}