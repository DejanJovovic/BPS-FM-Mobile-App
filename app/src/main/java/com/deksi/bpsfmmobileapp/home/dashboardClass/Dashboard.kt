package com.deksi.bpsfmmobileapp.home.dashboardClass

class Dashboard {

    var message: String = ""
    var success: Boolean = true

    class transferObject {
        val accountsCount: Int = 0
        val serviceRequestCount: Int = 3
        val vendorsCount: Int = 1
        val revenueSummaries: List<RevenueSummaries> = listOf()
        val sumOfServiceRequests: Int = 7
        val sumOfTotalExpenses: Int = 11719
        val sumOfPreviousYear: Double = 459.5541604185411
        val powerCuts: List<EnergyData> = listOf()
        val powerCutsNum: List<EnergyData> = listOf()
        val energySavings: List<EnergyData> = listOf()
        val carbonSavings: List<EnergyData> = listOf()
        val costSavings: List<EnergyData> = listOf()
        val received: List<EnergyData> = listOf()
        val totalConsumption: List<EnergyData> = listOf()
        val totalConsumptionSeparated: List<TotalConsumptionSeparated> = listOf()
        val expected: List<EnergyData> = listOf()
        val expectedDiesel: List<EnergyData> = listOf()
        val revenue: Int = 5600
    }

    data class TotalConsumptionSeparated(
        val gridTotalConsumption: List<EnergyData> = listOf(),
        val solarTotalConsumption: List<EnergyData> = listOf()
    )

    data class RevenueSummaries(
        var facilityIdFormatted: String?,
        var facilityName: String?,
        var category: String?,
        var serviceType: String?,
        var serviceRequestNos: Int,
        var totalExpense: Double,
        var previousYear: Double
    )

    data class EnergyData(
        var currentValue: Int,
        var previousValue: Int,
        var percentageDiff: Int,
        var name: String?,
        var cost: Int,
        var energy: Double,
        var ts: String
    )

}