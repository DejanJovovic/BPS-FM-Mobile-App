package com.deksi.bpsfmmobileapp.home.api

import com.deksi.bpsfmmobileapp.home.model.Dashboard
import com.deksi.bpsfmmobileapp.home.model.TransferObject

data class DashboardResponse(
    val transferObject: List<Dashboard>
)
