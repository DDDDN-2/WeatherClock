# Weather App

这是一个简单的天气APP，提供以下功能：
- 显示当前时间
- 显示当前位置
- 显示实时天气信息（温度、天气状况）
- 显示未来天气预报
- 闹钟功能（支持天气感知）

## 技术架构
- 开发语言：Kotlin
- 最低支持Android版本：Android 6.0 (API 23)
- 网络请求：Retrofit
- 位置服务：Google Play Services Location
- 数据存储：Room Database
- UI组件：Material Design Components

## API使用说明
本应用使用彩云天气 API 获取天气数据：
- API Key: TAkhjf8d1nlSlspN
- API文档: https://docs.caiyunapp.com/
- 示例请求: https://api.caiyunapp.com/v2.6/TAkhjf8d1nlSlspN/116.3176,39.9760/weather?alert=true&dailysteps=1&hourlysteps=24

## 权限说明
应用需要以下权限：
- INTERNET：获取天气数据
- ACCESS_FINE_LOCATION：获取精确位置
- ACCESS_COARSE_LOCATION：获取大致位置 