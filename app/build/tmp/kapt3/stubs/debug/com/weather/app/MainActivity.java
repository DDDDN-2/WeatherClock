package com.weather.app;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0016H\u0014J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020\u00162\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/weather/app/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/weather/app/databinding/ActivityMainBinding;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "locationHelper", "Lcom/weather/app/utils/LocationHelper;", "timeUpdateHandler", "Landroid/os/Handler;", "viewModel", "Lcom/weather/app/ui/viewmodel/AlarmViewModel;", "getViewModel", "()Lcom/weather/app/ui/viewmodel/AlarmViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "weatherService", "Lcom/weather/app/api/WeatherService;", "checkLocationPermission", "", "fetchWeatherData", "", "lat", "", "lon", "getCurrentLocation", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "requestLocationPermission", "setupAddAlarmButton", "setupAlarmList", "setupStatusBar", "showAlarmDetail", "alarm", "Lcom/weather/app/db/AlarmEntity;", "showAlarmRingingDialog", "alarmId", "", "label", "", "updateCurrentTime", "Companion", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.weather.app.databinding.ActivityMainBinding binding;
    private com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient;
    private android.os.Handler timeUpdateHandler;
    private final com.weather.app.api.WeatherService weatherService = null;
    private final kotlin.Lazy viewModel$delegate = null;
    private com.weather.app.utils.LocationHelper locationHelper;
    @org.jetbrains.annotations.NotNull
    public static final com.weather.app.MainActivity.Companion Companion = null;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    
    public MainActivity() {
        super();
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
    
    private final void showAlarmRingingDialog(int alarmId, java.lang.String label) {
    }
    
    private final void showAlarmDetail(com.weather.app.db.AlarmEntity alarm) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/weather/app/MainActivity$Companion;", "", "()V", "LOCATION_PERMISSION_REQUEST_CODE", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}