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
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.weather.app.databinding.ActivityMainBinding
import com.weather.app.ui.adapter.AlarmAdapter
import com.weather.app.ui.AlarmSettingFragment
import com.weather.app.ui.viewmodel.AlarmViewModel
import com.weather.app.ui.viewmodel.AlarmViewModelFactory
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt
import com.weather.app.api.WeatherApi
import android.util.Log
import com.weather.app.utils.WeatherIconMapper
import android.view.View
import android.view.WindowManager
import android.graphics.Color
import com.weather.app.utils.AlarmManagerHelper
import com.weather.app.ui.dialog.AlarmRingingDialog
import androidx.recyclerview.widget.ItemTouchHelper
import com.weather.app.ui.helper.SwipeToDeleteCallback
import com.weather.app.ui.dialog.AlarmDetailFragment
import com.weather.app.db.AlarmEntity
import com.weather.app.api.WeatherService
import com.weather.app.utils.WeatherUiHelper
import com.weather.app.data.CaiyunResponse
import kotlin.Result
import com.weather.app.utils.LocationHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var timeUpdateHandler: Handler? = null
    private val weatherService = WeatherService()
    private val viewModel: AlarmViewModel by viewModels {
        AlarmViewModelFactory(
            repository = (application as WeatherApp).repository,
            alarmManagerHelper = AlarmManagerHelper(this)
        )
    }
    private lateinit var locationHelper: LocationHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // 设置状态栏
        setupStatusBar()
        
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

        setupAlarmList()
        setupAddAlarmButton()

        // 检查是否需要显示闹钟对话框
        if (intent?.getBooleanExtra("SHOW_ALARM_DIALOG", false) == true) {
            showAlarmRingingDialog(
                intent.getIntExtra("ALARM_ID", 0),
                intent.getStringExtra("ALARM_LABEL") ?: "闹钟"
            )
        }

        locationHelper = LocationHelper(this)
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
        
        // 获取地点名称
        val locationName = locationHelper.getLocationName(lat, lon)
        
        lifecycleScope.launch {
            try {
                val result: Result<CaiyunResponse> = weatherService.getWeather(lat, lon)
                result.onSuccess { response: CaiyunResponse ->
                    Log.d("WeatherApp", "API响应成功: $response")
                    
                    // 使用WeatherUiHelper更新UI
                    WeatherUiHelper.updateWeatherUi(
                        temperature = response.result.realtime.temperature,
                        skycon = response.result.realtime.skycon,
                        locationName = locationName,
                        tvLocation = binding.tvLocation,
                        tvTemperature = binding.tvTemperature,
                        tvWeatherDesc = binding.tvWeatherDescription,
                        ivWeatherIcon = binding.ivWeatherIcon
                    )
                    
                    Log.d("WeatherApp", "UI更新完成")
                }.onFailure { e: Throwable ->
                    Log.e("WeatherApp", "获取天气数据失败", e)
                    Toast.makeText(
                        this@MainActivity,
                        "获取天气失败: ${e.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e: Exception) {
                Log.e("WeatherApp", "获取天气数据失败", e)
                Toast.makeText(
                    this@MainActivity,
                    "Error: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
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

    private fun setupStatusBar() {
        // 设置状态栏为透明
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setupAlarmList() {
        val adapter = AlarmAdapter(
            onToggleAlarm = { alarm, isEnabled ->
                viewModel.update(alarm.copy(isEnabled = isEnabled))
            },
            onDeleteAlarm = { alarm ->
                viewModel.delete(alarm)
            }
        )

        binding.rvAlarms.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@MainActivity)

            // 添加滑动操作
            val swipeHandler = SwipeToDeleteCallback(
                onDelete = { position ->
                    val alarm = adapter.currentList[position]
                    viewModel.delete(alarm)
                },
                onDetail = { position ->
                    val alarm = adapter.currentList[position]
                    showAlarmDetail(alarm)
                }
            )
            ItemTouchHelper(swipeHandler).attachToRecyclerView(this)
        }

        viewModel.allAlarms.observe(this) { alarms ->
            adapter.submitList(alarms)
        }
    }

    private fun setupAddAlarmButton() {
        binding.btnAddAlarm.setOnClickListener {
            AlarmSettingFragment().show(supportFragmentManager, "alarm_setting")
        }
    }

    private fun showAlarmRingingDialog(alarmId: Int, label: String) {
        AlarmRingingDialog.newInstance(alarmId, label)
            .show(supportFragmentManager, "alarm_ringing")
    }

    private fun showAlarmDetail(alarm: AlarmEntity) {
        // 显示闹钟详情对话框
        AlarmDetailFragment.newInstance(alarm.id)
            .show(supportFragmentManager, "alarm_detail")
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }
} 