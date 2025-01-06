package com.weather.app.utils

import android.widget.ImageView
import android.widget.TextView
import com.weather.app.R

/**
 * 天气UI更新助手类
 * 负责处理天气相关的UI更新操作
 */
class WeatherUiHelper {
    companion object {
        /**
         * 更新天气UI
         * @param temperature 温度
         * @param skycon 天气代码
         * @param locationName 地点名称
         * @param tvLocation 地点文本视图
         * @param tvTemperature 温度文本视图
         * @param tvWeatherDesc 天气描述文本视图
         * @param ivWeatherIcon 天气图标视图
         */
        fun updateWeatherUi(
            temperature: Double,
            skycon: String,
            locationName: String,
            tvLocation: TextView,
            tvTemperature: TextView,
            tvWeatherDesc: TextView,
            ivWeatherIcon: ImageView
        ) {
            // 更新位置
            tvLocation.text = locationName
            
            // 更新温度
            tvTemperature.text = "${temperature.toInt()}°C"
            
            // 更新天气描述
            tvWeatherDesc.text = WeatherIconMapper.getWeatherDescription(skycon)
            
            // 更新天气图标
            ivWeatherIcon.setImageResource(
                WeatherIconMapper.getWeatherIconResource(skycon)
            )
        }

        /**
         * 更新天气预报项UI
         * @param temperature 温度
         * @param skycon 天气代码
         * @param tvTemp 温度文本视图
         * @param ivIcon 天气图标视图
         */
        fun updateForecastItemUi(
            temperature: Double,
            skycon: String,
            tvTemp: TextView,
            ivIcon: ImageView
        ) {
            tvTemp.text = "${temperature.toInt()}°C"
            ivIcon.setImageResource(
                WeatherIconMapper.getWeatherIconResource(skycon)
            )
        }
    }
}