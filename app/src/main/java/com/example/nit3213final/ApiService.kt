package com.example.nit3213final

import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("sydney/auth")
    fun login(
        @Body request: LoginRequest
    ): Call<LoginResponse>

    @GET(".")
    fun getHome(
        @Header("Authorization") token: String
    ): Call<Map<String, Any>>

    @GET
    fun getProfileData(
        @Url url: String,
        @Header("Authorization") token: String
    ): Call<okhttp3.ResponseBody>
}