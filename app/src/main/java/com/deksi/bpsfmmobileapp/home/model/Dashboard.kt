package com.deksi.bpsfmmobileapp.home.model

import com.google.gson.annotations.SerializedName

data class Dashboard(

    @SerializedName("message")
    val message: String = "",
    @SerializedName("success")
    val success: Boolean = true,
    @SerializedName("transferObject")
    val transferObject: TransferObject
)

data class TransferObject(
    @SerializedName("accountsCount")
    val accountsCount: Int = 0,
    @SerializedName("serviceRequestCount")
    val serviceRequestCount: Int = 3,
    @SerializedName("vendorsCount")
    val vendorsCount: Int = 1,
    @SerializedName("revenueSummaries")
    val revenueSummaries: List<RevenueSummaries> = listOf(),
    @SerializedName("sumOfServiceRequests")
    val sumOfServiceRequests: Int = 7,
    @SerializedName("sumOfTotalExpenses")
    val sumOfTotalExpenses: Int = 11719,
    @SerializedName("sumOfPreviousYear")
    val sumOfPreviousYear: Double = 459.5541604185411,
    @SerializedName("powerCuts")
    val powerCuts: List<EnergyData> = listOf(),
    @SerializedName("powerCutsNum")
    val powerCutsNum: List<EnergyData> = listOf(),
    @SerializedName("energySavings")
    val energySavings: List<EnergyData> = listOf(),
    @SerializedName("carbonSavings")
    val carbonSavings: List<EnergyData> = listOf(),
    @SerializedName("costSavings")
    val costSavings: List<EnergyData> = listOf(),
    @SerializedName("received")
    val received: List<EnergyData> = listOf(),
    @SerializedName("totalConsumption")
    val totalConsumption: List<EnergyData> = listOf(),
    @SerializedName("totalConsumptionSeparated")
    val totalConsumptionSeparated: List<TotalConsumptionSeparated> = listOf(),
    @SerializedName("expected")
    val expected: List<EnergyData> = listOf(),
    @SerializedName("expectedDiesel")
    val expectedDiesel: List<EnergyData> = listOf(),
    @SerializedName("revenue")
    val revenue: Int = 5600
)

data class TotalConsumptionSeparated(
    @SerializedName("gridTotalConsumption")
    val gridTotalConsumption: List<EnergyData> = listOf(),
    @SerializedName("solarTotalConsumption")
    val solarTotalConsumption: List<EnergyData> = listOf()
)

data class RevenueSummaries(
    @SerializedName("facilityIdFormatted")
    var facilityIdFormatted: String?,
    @SerializedName("facilityName")
    var facilityName: String?,
    @SerializedName("category")
    var category: String?,
    @SerializedName("serviceType")
    var serviceType: String?,
    @SerializedName("serviceRequestNos")
    var serviceRequestNos: Int,
    @SerializedName("totalExpense")
    var totalExpense: Double,
    @SerializedName("previousYear")
    var previousYear: Double
)

data class EnergyData(
    @SerializedName("currentValue")
    var currentValue: Int,
    @SerializedName("previousValue")
    var previousValue: Int,
    @SerializedName("percentageDiff")
    var percentageDiff: Int,
    @SerializedName("name")
    var name: String?,
    @SerializedName("cost")
    var cost: Int,
    @SerializedName("energy")
    var energy: Double,
    @SerializedName("ts")
    var ts: String
)
