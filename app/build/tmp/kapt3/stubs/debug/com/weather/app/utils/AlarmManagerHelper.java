package com.weather.app.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/weather/app/utils/AlarmManagerHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alarmManager", "Landroid/app/AlarmManager;", "cancelAlarm", "", "alarm", "Lcom/weather/app/db/AlarmEntity;", "scheduleAlarm", "Companion", "app_debug"})
public final class AlarmManagerHelper {
    private final android.content.Context context = null;
    private final android.app.AlarmManager alarmManager = null;
    @org.jetbrains.annotations.NotNull
    public static final com.weather.app.utils.AlarmManagerHelper.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String EXTRA_ALARM_ID = "alarm_id";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String EXTRA_ALARM_TIME = "alarm_time";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String EXTRA_ALARM_LABEL = "alarm_label";
    
    public AlarmManagerHelper(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    public final void scheduleAlarm(@org.jetbrains.annotations.NotNull
    com.weather.app.db.AlarmEntity alarm) {
    }
    
    public final void cancelAlarm(@org.jetbrains.annotations.NotNull
    com.weather.app.db.AlarmEntity alarm) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/weather/app/utils/AlarmManagerHelper$Companion;", "", "()V", "EXTRA_ALARM_ID", "", "EXTRA_ALARM_LABEL", "EXTRA_ALARM_TIME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}