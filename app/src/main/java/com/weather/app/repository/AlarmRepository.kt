package com.weather.app.repository

import com.weather.app.db.AlarmDao
import com.weather.app.db.AlarmEntity
import kotlinx.coroutines.flow.Flow

class AlarmRepository(private val alarmDao: AlarmDao) {
    val allAlarms: Flow<List<AlarmEntity>> = alarmDao.getAllAlarms()

    suspend fun insert(alarm: AlarmEntity) {
        alarmDao.insert(alarm)
    }

    suspend fun update(alarm: AlarmEntity) {
        alarmDao.update(alarm)
    }

    suspend fun delete(alarm: AlarmEntity) {
        alarmDao.delete(alarm)
    }
} 