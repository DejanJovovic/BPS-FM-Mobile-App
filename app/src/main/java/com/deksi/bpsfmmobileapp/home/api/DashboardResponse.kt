package com.deksi.bpsfmmobileapp.home.api

import com.deksi.bpsfmmobileapp.home.model.Dashboard
import com.deksi.bpsfmmobileapp.home.model.transferObject
import com.google.gson.annotations.SerializedName

data class DashboardResponse(
    @SerializedName("transferObject") var transferObject: transferObject? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("success") var success: Boolean? = null
//    @SerializedName("transferObject")
//    var transferObject: List<TransferObject>? = null,
//    @SerializedName("revenueSummaries")
//    var revenueSummaries: List<RevenueSummaries>? = null,
//    @SerializedName("powerCuts")
//    var powerCuts: List<PowerCuts>? = null,
//    @SerializedName("powerCutsNum")
//    var powerCutsNum: List<PowerCutsNum>? = null,
//    @SerializedName("energySavings")
//    var energySavings: List<EnergySavings>? = null,
//    @SerializedName("carbonSavings")
//    var carbonSavings: List<CarbonSavings>? = null,
//    @SerializedName("costSavings")
//    var costSavings: List<CostSavings>? = null,
//    @SerializedName("energySources")
//    var energySources: List<EnergySources>? = null,
//    @SerializedName("received")
//    var received: List<Received>? = null,
//    @SerializedName("totalConsumption")
//    var totalConsumption: List<TotalConsumption>? = null,
//    @SerializedName("totalConsumptionSeparated")
//    var totalConsumptionSeparated: List<TotalConsumptionSeparated>? = null,
//    @SerializedName("gridTotalConsumption")
//    var gridTotalConsumption: List<GridTotalConsumption>? = null,
//    @SerializedName("solarTotalConsumption")
//    var solarTotalConsumption: List<SolarTotalConsumption>? = null,
//    @SerializedName("expected")
//    var expected: List<Expected>? = null,
//    @SerializedName("expectedDiesel")
//    var expectedDiesel: List<ExpectedDiesel>? = null,

//
//    var dashboard: Dashboard,
//


)
