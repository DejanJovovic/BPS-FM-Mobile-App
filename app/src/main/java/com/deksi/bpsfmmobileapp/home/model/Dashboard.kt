package com.deksi.bpsfmmobileapp.home.model

import com.google.gson.annotations.SerializedName

data class Dashboard(
    @SerializedName("transferObject") var transferObject: transferObject? = transferObject(),
    @SerializedName("message") var message: String? = null,
    @SerializedName("success") var success: Boolean? = null

)

data class transferObject(

    @SerializedName("accountsCount") var accountsCount: Int? = null,
    @SerializedName("serviceRequestsCount") var serviceRequestsCount: Int? = null,
    @SerializedName("vendorsCount") var vendorsCount: Int? = null,
    @SerializedName("revenueSummaries") var revenueSummaries: ArrayList<revenueSummaries> = arrayListOf(),
    @SerializedName("sumOfServiceRequests") var sumOfServiceRequests: Int? = null,
    @SerializedName("sumOfTotalExpenses") var sumOfTotalExpenses: Int? = null,
    @SerializedName("sumOfPreviousYear") var sumOfPreviousYear: Double? = null,
    @SerializedName("powerCuts") var powerCuts: powerCuts? = powerCuts(),
    @SerializedName("powerCutsNum") var powerCutsNum: powerCutsNum? = powerCutsNum(),
    @SerializedName("energySavings") var energySavings: energySavings? = energySavings(),
    @SerializedName("carbonSavings") var carbonSavings: carbonSavings? = carbonSavings(),
    @SerializedName("costSavings") var costSavings: ArrayList<costSavings> = arrayListOf(),
    @SerializedName("energySources") var energySources: ArrayList<energySources> = arrayListOf(),
    @SerializedName("received") var received: ArrayList<received> = arrayListOf(),
    @SerializedName("totalConsumption") var totalConsumption: ArrayList<totalConsumption> = arrayListOf(),
    @SerializedName("totalConsumptionSeparated") var totalConsumptionSeparated: totalConsumptionSeparated? = totalConsumptionSeparated(),
    @SerializedName("expected") var expected: ArrayList<expected> = arrayListOf(),
    @SerializedName("expectedDiesel") var expectedDiesel: ArrayList<expectedDiesel> = arrayListOf(),
    @SerializedName("revenue") var revenue: Int? = null

)

data class revenueSummaries(

    @SerializedName("facilityIdFormatted") var facilityIdFormatted: String? = null,
    @SerializedName("facilityName") var facilityName: String? = null,
    @SerializedName("category") var category: String? = null,
    @SerializedName("serviceType") var serviceType: String? = null,
    @SerializedName("serviceRequestNos") var serviceRequestNos: Int? = null,
    @SerializedName("totalExpense") var totalExpense: Int? = null,
    @SerializedName("previousYear") var previousYear: Double? = null

)


data class powerCuts(

    @SerializedName("currentValue") var currentValue: Int? = null,
    @SerializedName("previousValue") var previousValue: Int? = null,
    @SerializedName("percentageDiff") var percentageDiff: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("cost") var cost: Int? = null,
    @SerializedName("energy") var energy: Int? = null,
    @SerializedName("ts") var ts: String? = null

)


data class powerCutsNum(

    @SerializedName("currentValue") var currentValue: Int? = null,
    @SerializedName("previousValue") var previousValue: Int? = null,
    @SerializedName("percentageDiff") var percentageDiff: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("cost") var cost: Int? = null,
    @SerializedName("energy") var energy: Int? = null,
    @SerializedName("ts") var ts: String? = null

)

data class energySavings(

    @SerializedName("currentValue") var currentValue: Int? = null,
    @SerializedName("previousValue") var previousValue: Int? = null,
    @SerializedName("percentageDiff") var percentageDiff: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("cost") var cost: Int? = null,
    @SerializedName("energy") var energy: Int? = null,
    @SerializedName("ts") var ts: String? = null

)


data class carbonSavings(

    @SerializedName("currentValue") var currentValue: Int? = null,
    @SerializedName("previousValue") var previousValue: Int? = null,
    @SerializedName("percentageDiff") var percentageDiff: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("cost") var cost: Int? = null,
    @SerializedName("energy") var energy: Int? = null,
    @SerializedName("ts") var ts: String? = null

)

data class costSavings(

    @SerializedName("currentValue") var currentValue: Int? = null,
    @SerializedName("previousValue") var previousValue: Int? = null,
    @SerializedName("percentageDiff") var percentageDiff: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("cost") var cost: Int? = null,
    @SerializedName("energy") var energy: Int? = null,
    @SerializedName("ts") var ts: String? = null

)

data class energySources(

    @SerializedName("currentValue") var currentValue: Int? = null,
    @SerializedName("previousValue") var previousValue: Int? = null,
    @SerializedName("percentageDiff") var percentageDiff: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("cost") var cost: Int? = null,
    @SerializedName("energy") var energy: Double? = null,
    @SerializedName("ts") var ts: String? = null

)


data class received(

    @SerializedName("currentValue") var currentValue: Int? = null,
    @SerializedName("previousValue") var previousValue: Int? = null,
    @SerializedName("percentageDiff") var percentageDiff: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("cost") var cost: Int? = null,
    @SerializedName("energy") var energy: Int? = null,
    @SerializedName("ts") var ts: String? = null

)

data class totalConsumption(

    @SerializedName("currentValue") var currentValue: Int? = null,
    @SerializedName("previousValue") var previousValue: Int? = null,
    @SerializedName("percentageDiff") var percentageDiff: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("cost") var cost: Int? = null,
    @SerializedName("energy") var energy: Double? = null,
    @SerializedName("ts") var ts: String? = null

)

data class totalConsumptionSeparated(

    @SerializedName("gridTotalConsumption") var gridTotalConsumption: ArrayList<gridTotalConsumption> = arrayListOf(),
    @SerializedName("solarTotalConsumption") var solarTotalConsumption: ArrayList<solarTotalConsumption> = arrayListOf()

)


data class gridTotalConsumption(

    @SerializedName("currentValue") var currentValue: Int? = null,
    @SerializedName("previousValue") var previousValue: Int? = null,
    @SerializedName("percentageDiff") var percentageDiff: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("cost") var cost: Int? = null,
    @SerializedName("energy") var energy: Double? = null,
    @SerializedName("ts") var ts: String? = null

)


data class solarTotalConsumption(

    @SerializedName("currentValue") var currentValue: Int? = null,
    @SerializedName("previousValue") var previousValue: Int? = null,
    @SerializedName("percentageDiff") var percentageDiff: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("cost") var cost: Int? = null,
    @SerializedName("energy") var energy: Int? = null,
    @SerializedName("ts") var ts: String? = null

)

data class expected(

    @SerializedName("currentValue") var currentValue: Int? = null,
    @SerializedName("previousValue") var previousValue: Int? = null,
    @SerializedName("percentageDiff") var percentageDiff: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("cost") var cost: Int? = null,
    @SerializedName("energy") var energy: Int? = null,
    @SerializedName("ts") var ts: String? = null

)

data class expectedDiesel(

    @SerializedName("currentValue") var currentValue: Int? = null,
    @SerializedName("previousValue") var previousValue: Int? = null,
    @SerializedName("percentageDiff") var percentageDiff: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("cost") var cost: Int? = null,
    @SerializedName("energy") var energy: Int? = null,
    @SerializedName("ts") var ts: String? = null

)



