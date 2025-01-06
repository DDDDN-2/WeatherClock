package com.weather.app.utils

import android.content.Context
import android.location.Geocoder
import android.util.Log
import java.util.Locale

class LocationHelper(private val context: Context) {
    fun getLocationName(latitude: Double, longitude: Double): String {
        return try {
            val geocoder = Geocoder(context, Locale.getDefault())
            val addresses = geocoder.getFromLocation(latitude, longitude, 1)
            if (!addresses.isNullOrEmpty()) {
                val address = addresses[0]
                when {
                    !address.locality.isNullOrEmpty() -> address.locality
                    !address.subAdminArea.isNullOrEmpty() -> address.subAdminArea
                    !address.adminArea.isNullOrEmpty() -> address.adminArea
                    else -> "未知位置"
                }
            } else {
                "未知位置"
            }
        } catch (e: Exception) {
            Log.e("LocationHelper", "获取地点名称失败", e)
            "未知位置"
        }
    }
} 