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
        if (ActivityCompat.checkSelfPermission(this, 
            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                location?.let {
                    fetchWeatherData(it.latitude, it.longitude)
                }
            }
        }
    }

    private fun fetchWeatherData(lat: Double, lon: Double) {
        lifecycleScope.launch {
            try {
                val response = weatherApi.getCurrentWeather(
                    lat = lat,
                    lon = lon,
                    apiKey = "7b2397a91df632710a076feb9283d4fc"
                )
                
                binding.tvLocation.text = response.name
                binding.tvTemperature.text = "${response.main.temp.roundToInt()}°C"
                binding.tvWeatherDescription.text = response.weather.firstOrNull()?.description
                    ?.capitalize(Locale.getDefault())
            } catch (e: Exception) {
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