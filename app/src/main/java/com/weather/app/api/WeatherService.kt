package com.weather.app.api

import android.util.Log
import com.weather.app.data.CaiyunResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherService {
    private val caiyunApi: CaiyunApi = Retrofit.Builder()
        .baseUrl("https://api.caiyunapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CaiyunApi::class.java)

    suspend fun getWeather(lat: Double, lon: Double): Result<CaiyunResponse> {
        return try {
            Log.d("WeatherService", "正在获取天气数据: lat=$lat, lon=$lon")
            val response = caiyunApi.getWeather(
                token = "W83G9Mwtpb2ZHBWi",
                location = "$lon,$lat",
                alert = true,
                dailySteps = 1,
                hourlySteps = 24
            )
            Log.d("WeatherService", "成功获取天气数据: $response")
            Result.success(response)
        } catch (e: Exception) {
            Log.e("WeatherService", "获取天气数据失败", e)
            Result.failure(e)
        }
    }
}