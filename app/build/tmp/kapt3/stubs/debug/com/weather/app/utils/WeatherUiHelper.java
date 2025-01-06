package com.weather.app.utils;

import java.lang.System;

/**
 * 天气UI更新助手类
 * 负责处理天气相关的UI更新操作
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/weather/app/utils/WeatherUiHelper;", "", "()V", "Companion", "app_debug"})
public final class WeatherUiHelper {
    @org.jetbrains.annotations.NotNull
    public static final com.weather.app.utils.WeatherUiHelper.Companion Companion = null;
    
    public WeatherUiHelper() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ>\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\f\u00a8\u0006\u0013"}, d2 = {"Lcom/weather/app/utils/WeatherUiHelper$Companion;", "", "()V", "updateForecastItemUi", "", "temperature", "", "skycon", "", "tvTemp", "Landroid/widget/TextView;", "ivIcon", "Landroid/widget/ImageView;", "updateWeatherUi", "locationName", "tvLocation", "tvTemperature", "tvWeatherDesc", "ivWeatherIcon", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
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
        public final void updateWeatherUi(double temperature, @org.jetbrains.annotations.NotNull
        java.lang.String skycon, @org.jetbrains.annotations.NotNull
        java.lang.String locationName, @org.jetbrains.annotations.NotNull
        android.widget.TextView tvLocation, @org.jetbrains.annotations.NotNull
        android.widget.TextView tvTemperature, @org.jetbrains.annotations.NotNull
        android.widget.TextView tvWeatherDesc, @org.jetbrains.annotations.NotNull
        android.widget.ImageView ivWeatherIcon) {
        }
        
        /**
         * 更新天气预报项UI
         * @param temperature 温度
         * @param skycon 天气代码
         * @param tvTemp 温度文本视图
         * @param ivIcon 天气图标视图
         */
        public final void updateForecastItemUi(double temperature, @org.jetbrains.annotations.NotNull
        java.lang.String skycon, @org.jetbrains.annotations.NotNull
        android.widget.TextView tvTemp, @org.jetbrains.annotations.NotNull
        android.widget.ImageView ivIcon) {
        }
    }
}