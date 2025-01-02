# Weather App

这是一个简单的天气APP，提供以下功能：
- 显示当前时间
- 显示当前位置
- 显示实时天气信息（温度、天气状况）
- 显示未来天气预报

## 技术架构
- 开发语言：Kotlin
- 最低支持Android版本：Android 6.0 (API 23)
- 网络请求：Retrofit
- 位置服务：Google Play Services Location
- 数据存储：SharedPreferences
- UI组件：Material Design Components

## API使用说明
本应用使用OpenWeatherMap API获取天气数据：
- API Key: 7b2397a91df632710a076feb9283d4fc
- API文档: https://openweathermap.org/api

## 权限说明
应用需要以下权限：
- INTERNET：获取天气数据
- ACCESS_FINE_LOCATION：获取精确位置
- ACCESS_COARSE_LOCATION：获取大致位置 