package com.deksi.bpsfmmobileapp.home.api

import okhttp3.Headers
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface DashboardApiService {

    @POST("dashboard/getDashboardData")
    fun getDashboardData(
        @Body dashboardRequest: DashboardRequest,
        @HeaderMap headers: Headers): Call<DashboardResponse>
}