package com.weather.app.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u000bH\u00c6\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001J\t\u0010#\u001a\u00020$H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012\u00a8\u0006%"}, d2 = {"Lcom/weather/app/data/AirQuality;", "", "pm25", "", "pm10", "o3", "so2", "no2", "co", "", "aqi", "Lcom/weather/app/data/AQI;", "(IIIIIDLcom/weather/app/data/AQI;)V", "getAqi", "()Lcom/weather/app/data/AQI;", "getCo", "()D", "getNo2", "()I", "getO3", "getPm10", "getPm25", "getSo2", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class AirQuality {
    private final int pm25 = 0;
    private final int pm10 = 0;
    private final int o3 = 0;
    private final int so2 = 0;
    private final int no2 = 0;
    private final double co = 0.0;
    @org.jetbrains.annotations.NotNull
    private final com.weather.app.data.AQI aqi = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.weather.app.data.AirQuality copy(int pm25, int pm10, int o3, int so2, int no2, double co, @org.jetbrains.annotations.NotNull
    com.weather.app.data.AQI aqi) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public AirQuality(int pm25, int pm10, int o3, int so2, int no2, double co, @org.jetbrains.annotations.NotNull
    com.weather.app.data.AQI aqi) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getPm25() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getPm10() {
        return 0;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getO3() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getSo2() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getNo2() {
        return 0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double getCo() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.weather.app.data.AQI component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.weather.app.data.AQI getAqi() {
        return null;
    }
}