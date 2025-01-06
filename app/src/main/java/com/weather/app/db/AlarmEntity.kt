package com.weather.app.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "alarms")
data class AlarmEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    
    @ColumnInfo(name = "timeInMillis")
    val timeInMillis: Long,
    
    @ColumnInfo(name = "label")
    val label: String,
    
    @ColumnInfo(name = "isEnabled")
    val isEnabled: Boolean,
    
    @ColumnInfo(name = "repeatDays")
    val repeatDays: String, // Comma-separated list of days
    
    @ColumnInfo(name = "weatherAwareEnabled", defaultValue = "0")
    val weatherAwareEnabled: Boolean = false,
    
    @ColumnInfo(name = "weatherType", defaultValue = "")
    val weatherType: String = "",
    
    @ColumnInfo(name = "advanceMinutes", defaultValue = "0")
    val advanceMinutes: Int = 0
) 