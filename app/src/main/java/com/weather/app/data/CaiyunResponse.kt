package com.weather.app.data

data class CaiyunResponse(
    val status: String,
    val api_version: String,
    val result: WeatherResult
)

data class WeatherResult(
    val realtime: Realtime,
    val hourly: Hourly,
    val daily: Daily,
    val alert: Alert
)

data class Realtime(
    val temperature: Double,
    val humidity: Double,
    val cloudrate: Double,
    val skycon: String,
    val visibility: Double,
    val wind: Wind,
    val pressure: Double,
    val apparent_temperature: Double,
    val air_quality: AirQuality
)

data class Wind(
    val speed: Double,
    val direction: Double
)

data class AirQuality(
    val pm25: Int,
    val pm10: Int,
    val o3: Int,
    val so2: Int,
    val no2: Int,
    val co: Double,
    val aqi: AQI
)

data class AQI(
    val chn: Int
)

data class Hourly(
    val temperature: List<HourlyValue>,
    val wind: List<HourlyWind>,
    val skycon: List<HourlySkycon>
)

data class Daily(
    val temperature: List<DailyValue>,
    val skycon: List<DailySkycon>,
    val wind: List<DailyWind>
)

data class Alert(
    val content: List<AlertContent>
)

data class HourlyValue(
    val datetime: String,
    val value: Double
)

data class HourlyWind(
    val datetime: String,
    val speed: Double,
    val direction: Double
)

data class DailyValue(
    val date: String,
    val max: Double,
    val min: Double,
    val avg: Double
)

data class DailyWind(
    val date: String,
    val max: Wind,
    val min: Wind,
    val avg: Wind
)

data class AlertContent(
    val province: String,
    val status: String,
    val code: String,
    val description: String,
    val title: String
)

data class HourlySkycon(
    val datetime: String,
    val value: String
)

data class DailySkycon(
    val date: String,
    val value: String
)