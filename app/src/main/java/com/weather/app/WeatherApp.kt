package com.weather.app

import android.app.Application
import com.weather.app.db.AlarmDatabase
import com.weather.app.repository.AlarmRepository

class WeatherApp : Application() {
    val database by lazy { AlarmDatabase.getDatabase(this) }
    val repository by lazy { AlarmRepository(database.alarmDao()) }
} 