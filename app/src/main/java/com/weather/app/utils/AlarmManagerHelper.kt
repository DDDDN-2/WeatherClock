package com.weather.app.utils

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import com.weather.app.receiver.AlarmReceiver
import com.weather.app.db.AlarmEntity
import java.text.SimpleDateFormat
import java.util.*

class AlarmManagerHelper(private val context: Context) {
    private val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    fun scheduleAlarm(alarm: AlarmEntity) {
        val currentTimeMillis = System.currentTimeMillis()
        
        var targetTimeMillis = alarm.timeInMillis
        if (targetTimeMillis < currentTimeMillis) {
            targetTimeMillis += 24 * 60 * 60 * 1000
        }

        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra(EXTRA_ALARM_ID, alarm.id)
            putExtra(EXTRA_ALARM_TIME, targetTimeMillis)
            putExtra(EXTRA_ALARM_LABEL, alarm.label)
        }

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            alarm.id,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setAlarmClock(
                AlarmManager.AlarmClockInfo(targetTimeMillis, pendingIntent),
                pendingIntent
            )
        } else {
            alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                targetTimeMillis,
                pendingIntent
            )
        }

        Log.d("AlarmManagerHelper", "闹钟已设置: ID=${alarm.id}, " +
            "时间=${SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date(targetTimeMillis))}")
    }

    fun cancelAlarm(alarm: AlarmEntity) {
        val intent = Intent(context, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            alarm.id,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        alarmManager.cancel(pendingIntent)
        Log.d("AlarmManagerHelper", "闹钟已取消: ID=${alarm.id}")
    }

    companion object {
        const val EXTRA_ALARM_ID = "alarm_id"
        const val EXTRA_ALARM_TIME = "alarm_time"
        const val EXTRA_ALARM_LABEL = "alarm_label"
    }
} 