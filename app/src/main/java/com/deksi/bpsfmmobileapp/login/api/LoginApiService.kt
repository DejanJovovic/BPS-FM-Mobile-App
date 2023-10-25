package com.deksi.bpsfmmobileapp.login.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiService {

    @POST("auth/login")
    fun login(@Body loginRequest: LoginRequest):Call<LoginResponse>


}