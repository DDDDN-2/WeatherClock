package com.weather.app.utils

import com.weather.app.R

object WeatherIconMapper {
    fun getWeatherDescription(weatherId: String): String {
        return when (weatherId) {
            "01d", "01n" -> "晴天"
            "02d", "02n" -> "少云"  // few clouds (11-25% 云量)
            "03d", "03n" -> "多云"  // scattered clouds (25-50% 云量)
            "04d", "04n" -> "阴天"  // broken clouds (51-84% 云量)
            "09d", "09n" -> "小雨"
            "10d", "10n" -> "雨"
            "11d", "11n" -> "雷雨"
            "13d", "13n" -> "雪"
            "50d", "50n" -> "雾"
            else -> "未知天气"
        }
    }

    fun getWeatherIconResource(iconCode: String): Int {
        return when (iconCode) {
            "01d" -> R.drawable.ic_clear_day
            "01n" -> R.drawable.ic_clear_night
            "02d" -> R.drawable.ic_partly_cloudy_day  // few clouds
            "02n" -> R.drawable.ic_partly_cloudy_night  // few clouds
            "03d", "03n" -> R.drawable.ic_cloudy      // scattered clouds
            "04d", "04n" -> R.drawable.ic_cloudy      // broken clouds
            "09d", "09n" -> R.drawable.ic_rain
            "10d", "10n" -> R.drawable.ic_rain
            "11d", "11n" -> R.drawable.ic_thunderstorm
            "13d", "13n" -> R.drawable.ic_snow
            "50d", "50n" -> R.drawable.ic_fog
            else -> R.drawable.ic_clear_day
        }
    }
} 