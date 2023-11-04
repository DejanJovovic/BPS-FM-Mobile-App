package com.deksi.bpsfmmobileapp.home.api

import com.deksi.bpsfmmobileapp.home.model.Dashboard
import com.deksi.bpsfmmobileapp.home.model.transferObject
import com.google.gson.annotations.SerializedName

data class DashboardResponse(
    @SerializedName("transferObject") var transferObject: transferObject? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("success") var success: Boolean? = null
)