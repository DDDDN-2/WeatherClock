package com.weather.app.api

import com.weather.app.data.CaiyunResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CaiyunApi {
    @GET("v2.6/{token}/{location}/weather")
    suspend fun getWeather(
        @Path("token") token: String,
        @Path("location") location: String,
        @Query("alert") alert: Boolean,
        @Query("dailysteps") dailySteps: Int,
        @Query("hourlysteps") hourlySteps: Int
    ): CaiyunResponse
} 