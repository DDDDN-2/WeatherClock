package com.weather.app;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0017H\u0014J\b\u0010 \u001a\u00020\u0017H\u0002J\b\u0010!\u001a\u00020\u0017H\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006&"}, d2 = {"Lcom/weather/app/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/weather/app/databinding/ActivityMainBinding;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "timeUpdateHandler", "Landroid/os/Handler;", "viewModel", "Lcom/weather/app/ui/viewmodel/AlarmViewModel;", "getViewModel", "()Lcom/weather/app/ui/viewmodel/AlarmViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "weatherApi", "Lcom/weather/app/api/WeatherApi;", "getWeatherApi", "()Lcom/weather/app/api/WeatherApi;", "weatherApi$delegate", "checkLocationPermission", "", "fetchWeatherData", "", "lat", "", "lon", "getCurrentLocation", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "requestLocationPermission", "setupAddAlarmButton", "setupAlarmList", "setupStatusBar", "updateCurrentTime", "Companion", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.weather.app.databinding.ActivityMainBinding binding;
    private com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient;
    private android.os.Handler timeUpdateHandler;
    private final kotlin.Lazy weatherApi$delegate = null;
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final com.weather.app.MainActivity.Companion Companion = null;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    
    public MainActivity() {
        super();
    }
    
    private final com.weather.app.api.WeatherApi getWeatherApi() {
        return null;
    }
    
    private final com.weather.app.ui.viewmodel.AlarmViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void updateCurrentTime() {
    }
    
    private final void getCurrentLocation() {
    }
    
    private final void fetchWeatherData(double lat, double lon) {
    }
    
    private final boolean checkLocationPermission() {
        return false;
    }
    
    private final void requestLocationPermission() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    private final void setupStatusBar() {
    }
    
    private final void setupAlarmList() {
    }
    
    private final void setupAddAlarmButton() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/weather/app/MainActivity$Companion;", "", "()V", "LOCATION_PERMISSION_REQUEST_CODE", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}