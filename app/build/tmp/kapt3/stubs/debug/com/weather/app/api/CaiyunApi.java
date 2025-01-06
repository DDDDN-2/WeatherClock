package com.weather.app.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JC\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/weather/app/api/CaiyunApi;", "", "getWeather", "Lcom/weather/app/data/CaiyunResponse;", "token", "", "location", "alert", "", "dailySteps", "", "hourlySteps", "(Ljava/lang/String;Ljava/lang/String;ZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface CaiyunApi {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "v2.6/{token}/{location}/weather")
    public abstract java.lang.Object getWeather(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "token")
    java.lang.String token, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "location")
    java.lang.String location, @retrofit2.http.Query(value = "alert")
    boolean alert, @retrofit2.http.Query(value = "dailysteps")
    int dailySteps, @retrofit2.http.Query(value = "hourlysteps")
    int hourlySteps, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.weather.app.data.CaiyunResponse> continuation);
}