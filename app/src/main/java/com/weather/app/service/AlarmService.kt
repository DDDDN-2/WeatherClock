package com.weather.app.service

import android.app.*
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.os.*
import androidx.core.app.NotificationCompat
import com.weather.app.MainActivity
import com.weather.app.R

class AlarmService : Service() {
    private var mediaPlayer: MediaPlayer? = null
    private var vibrator: Vibrator? = null
    private val CHANNEL_ID = "AlarmChannel"
    private val NOTIFICATION_ID = 1

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        
        // 使用系统默认闹钟声音
        val alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        mediaPlayer = MediaPlayer.create(this, alarmUri)
        mediaPlayer?.isLooping = true
        
        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val alarmId = intent?.getIntExtra("ALARM_ID", 0) ?: 0
        val label = intent?.getStringExtra("ALARM_LABEL") ?: "闹钟"

        // 创建通知
        val notification = createNotification(label)
        startForeground(NOTIFICATION_ID, notification)

        // 开始播放声音和振动
        mediaPlayer?.start()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator?.vibrate(VibrationEffect.createWaveform(longArrayOf(0, 1000, 1000), 0))
        } else {
            @Suppress("DEPRECATION")
            vibrator?.vibrate(longArrayOf(0, 1000, 1000), 0)
        }

        // 显示闹钟响铃对话框
        showAlarmDialog(alarmId, label)

        return START_STICKY
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "闹钟提醒",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "用于显示闹钟提醒"
                enableVibration(true)
            }
            
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun createNotification(label: String): Notification {
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("闹钟响铃")
            .setContentText(label)
            .setSmallIcon(R.drawable.ic_alarm)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_ALARM)
            .setAutoCancel(true)
            .setOngoing(true)
            .setContentIntent(pendingIntent)
            .build()
    }

    private fun showAlarmDialog(alarmId: Int, label: String) {
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            putExtra("SHOW_ALARM_DIALOG", true)
            putExtra("ALARM_ID", alarmId)
            putExtra("ALARM_LABEL", label)
        }
        startActivity(intent)
    }

    override fun onDestroy() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        vibrator?.cancel()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null
} 