package com.deksi.bpsfmmobileapp.home.api

import com.deksi.bpsfmmobileapp.home.model.Dashboard
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface DashboardApiService {

    @POST("dashboard/getDashboardData")
    fun getDashboardData(@Body dashboardRequest: DashboardRequest): Response<DashboardResponse>
}