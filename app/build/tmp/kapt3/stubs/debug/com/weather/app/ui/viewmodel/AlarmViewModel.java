package com.weather.app.ui.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/weather/app/ui/viewmodel/AlarmViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/weather/app/repository/AlarmRepository;", "alarmManagerHelper", "Lcom/weather/app/utils/AlarmManagerHelper;", "(Lcom/weather/app/repository/AlarmRepository;Lcom/weather/app/utils/AlarmManagerHelper;)V", "allAlarms", "Landroidx/lifecycle/LiveData;", "", "Lcom/weather/app/db/AlarmEntity;", "getAllAlarms", "()Landroidx/lifecycle/LiveData;", "delete", "Lkotlinx/coroutines/Job;", "alarm", "getAlarmById", "alarmId", "", "insert", "update", "app_debug"})
public final class AlarmViewModel extends androidx.lifecycle.ViewModel {
    private final com.weather.app.repository.AlarmRepository repository = null;
    private final com.weather.app.utils.AlarmManagerHelper alarmManagerHelper = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.weather.app.db.AlarmEntity>> allAlarms = null;
    
    public AlarmViewModel(@org.jetbrains.annotations.NotNull
    com.weather.app.repository.AlarmRepository repository, @org.jetbrains.annotations.NotNull
    com.weather.app.utils.AlarmManagerHelper alarmManagerHelper) {
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
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.weather.app.db.AlarmEntity> getAlarmById(int alarmId) {
        return null;
    }
}