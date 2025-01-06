package com.weather.app.utils

import com.weather.app.R

object WeatherIconMapper {
    fun getWeatherDescription(skycon: String): String {
        return when (skycon) {
            "CLEAR_DAY" -> "晴天"
            "CLEAR_NIGHT" -> "晴夜"
            "PARTLY_CLOUDY_DAY" -> "多云"
            "PARTLY_CLOUDY_NIGHT" -> "多云"
            "CLOUDY" -> "阴天"
            "LIGHT_RAIN" -> "小雨"
            "MODERATE_RAIN" -> "中雨"
            "HEAVY_RAIN" -> "大雨"
            "STORM_RAIN" -> "暴雨"
            "LIGHT_SNOW" -> "小雪"
            "MODERATE_SNOW" -> "中雪"
            "HEAVY_SNOW" -> "大雪"
            "STORM_SNOW" -> "暴雪"
            "FOG" -> "雾"
            "DUST" -> "浮尘"
            else -> "未知天气"
        }
    }

    fun getWeatherIconResource(skycon: String): Int {
        return when (skycon) {
            "CLEAR_DAY" -> R.drawable.ic_clear_day
            "CLEAR_NIGHT" -> R.drawable.ic_clear_night
            "PARTLY_CLOUDY_DAY" -> R.drawable.ic_partly_cloudy_day
            "PARTLY_CLOUDY_NIGHT" -> R.drawable.ic_partly_cloudy_night
            "CLOUDY" -> R.drawable.ic_cloudy
            "LIGHT_RAIN", "MODERATE_RAIN" -> R.drawable.ic_rain
            "HEAVY_RAIN", "STORM_RAIN" -> R.drawable.ic_thunderstorm
            "LIGHT_SNOW", "MODERATE_SNOW", "HEAVY_SNOW", "STORM_SNOW" -> R.drawable.ic_snow
            "FOG" -> R.drawable.ic_fog
            else -> R.drawable.ic_clear_day
        }
    }
} 