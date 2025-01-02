package com.weather.app

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.weather.app.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt
import com.weather.app.api.WeatherApi
import com.weather.app.data.WeatherResponse
import android.util.Log
import com.weather.app.utils.WeatherIconMapper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var timeUpdateHandler: Handler? = null
    private val weatherApi: WeatherApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        
        // 初始化Handler
        timeUpdateHandler = Handler(Looper.getMainLooper())
        
        // 更新当前时间
        updateCurrentTime()
        
        // 请求位置权限
        if (checkLocationPermission()) {
            getCurrentLocation()
        } else {
            requestLocationPermission()
        }
    }

    private fun updateCurrentTime() {
        // 创建时间更新的Runnable
        val timeUpdateRunnable = object : Runnable {
            override fun run() {
                val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
                binding.tvCurrentTime.text = currentTime
                // 每秒更新一次
                timeUpdateHandler?.postDelayed(this, 1000)
            }
        }

        // 立即开始更新时间
        timeUpdateHandler?.post(timeUpdateRunnable)
    }

    private fun getCurrentLocation() {
        Log.d("WeatherApp", "开始获取位置信息")
        
        if (ActivityCompat.checkSelfPermission(this, 
            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            
            Log.d("WeatherApp", "已获得位置权限，正在请求位置...")
            
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                if (location != null) {
                    Log.d("WeatherApp", "成功获取位置: lat=${location.latitude}, lon=${location.longitude}")
                    fetchWeatherData(location.latitude, location.longitude)
                } else {
                    Log.d("WeatherApp", "位置为空，使用默认位置（北京）")
                    // 使用北京的经纬度作为默认值
                    fetchWeatherData(39.9042, 116.4074)
                }
            }.addOnFailureListener { e ->
                Log.e("WeatherApp", "获取位置失败，使用默认位置", e)
                // 使用北京的经纬度作为默认值
                fetchWeatherData(39.9042, 116.4074)
            }
        } else {
            Log.w("WeatherApp", "没有位置权限，使用默认位置")
            // 使用北京的经纬度作为默认值
            fetchWeatherData(39.9042, 116.4074)
        }
    }

    private fun fetchWeatherData(lat: Double, lon: Double) {
        Log.d("WeatherApp", "开始获取天气数据: lat=$lat, lon=$lon")
        
        lifecycleScope.launch {
            try {
                Log.d("WeatherApp", "正在调用天气API...")
                val response = weatherApi.getCurrentWeather(
                    lat = lat,
                    lon = lon,
                    apiKey = "7b2397a91df632710a076feb9283d4fc"
                )
                
                Log.d("WeatherApp", "API响应成功: $response")
                Log.d("WeatherApp", "城市: ${response.name}")
                Log.d("WeatherApp", "温度: ${response.main.temp}°C")
                Log.d("WeatherApp", "天气描述: ${response.weather.firstOrNull()?.description}")
                
                binding.apply {
                    tvLocation.text = response.name
                    tvTemperature.text = "${response.main.temp.roundToInt()}°C"
                    tvWeatherDescription.text = response.weather.firstOrNull()?.description
                        ?.capitalize(Locale.getDefault())
                    
                    // 设置天气图标
                    response.weather.firstOrNull()?.icon?.let { iconCode ->
                        ivWeatherIcon.setImageResource(WeatherIconMapper.getWeatherIconResource(iconCode))
                    }
                }
                
                Log.d("WeatherApp", "UI更新完成")
            } catch (e: Exception) {
                Log.e("WeatherApp", "获取天气数据失败", e)
                Log.e("WeatherApp", "错误详情: ${e.message}")
                e.printStackTrace()
                Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun checkLocationPermission(): Boolean {
        return ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            LOCATION_PERMISSION_REQUEST_CODE
        )
    }

    override fun onDestroy() {
        // 清理Handler，避免内存泄漏
        timeUpdateHandler?.removeCallbacksAndMessages(null)
        timeUpdateHandler = null
        super.onDestroy()
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }
} 