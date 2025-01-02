package com.weather.app.utils

import com.weather.app.R

object WeatherIconMapper {
    fun getWeatherIconResource(iconCode: String): Int {
        return when (iconCode) {
            "01d" -> R.drawable.ic_clear_day
            "01n" -> R.drawable.ic_clear_night
            "02d" -> R.drawable.ic_partly_cloudy_day
            "02n" -> R.drawable.ic_partly_cloudy_night
            "03d", "03n" -> R.drawable.ic_cloudy
            "04d", "04n" -> R.drawable.ic_cloudy
            "09d", "09n" -> R.drawable.ic_rain
            "10d", "10n" -> R.drawable.ic_rain
            "11d", "11n" -> R.drawable.ic_thunderstorm
            "13d", "13n" -> R.drawable.ic_snow
            "50d", "50n" -> R.drawable.ic_fog
            else -> R.drawable.ic_clear_day
        }
    }
} 