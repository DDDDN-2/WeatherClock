package com.weather.app.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/weather/app/viewmodel/AlarmViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/weather/app/repository/AlarmRepository;", "(Lcom/weather/app/repository/AlarmRepository;)V", "allAlarms", "Landroidx/lifecycle/LiveData;", "", "Lcom/weather/app/db/AlarmEntity;", "getAllAlarms", "()Landroidx/lifecycle/LiveData;", "delete", "Lkotlinx/coroutines/Job;", "alarm", "insert", "update", "app_debug"})
public final class AlarmViewModel extends androidx.lifecycle.ViewModel {
    private final com.weather.app.repository.AlarmRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.weather.app.db.AlarmEntity>> allAlarms = null;
    
    public AlarmViewModel(@org.jetbrains.annotations.NotNull
    com.weather.app.repository.AlarmRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.weather.app.db.AlarmEntity>> getAllAlarms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job insert(@org.jetbrains.annotations.NotNull
    com.weather.app.db.AlarmEntity alarm) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job update(@org.jetbrains.annotations.NotNull
    com.weather.app.db.AlarmEntity alarm) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job delete(@org.jetbrains.annotations.NotNull
    com.weather.app.db.AlarmEntity alarm) {
        return null;
    }
}