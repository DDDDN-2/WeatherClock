package com.weather.app.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0013B3\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\u00072\n\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/weather/app/ui/adapter/AlarmAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/weather/app/db/AlarmEntity;", "Lcom/weather/app/ui/adapter/AlarmAdapter$ViewHolder;", "onToggleAlarm", "Lkotlin/Function2;", "", "", "onDeleteAlarm", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class AlarmAdapter extends androidx.recyclerview.widget.ListAdapter<com.weather.app.db.AlarmEntity, com.weather.app.ui.adapter.AlarmAdapter.ViewHolder> {
    private final kotlin.jvm.functions.Function2<com.weather.app.db.AlarmEntity, java.lang.Boolean, kotlin.Unit> onToggleAlarm = null;
    private final kotlin.jvm.functions.Function1<com.weather.app.db.AlarmEntity, kotlin.Unit> onDeleteAlarm = null;
    
    public AlarmAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super com.weather.app.db.AlarmEntity, ? super java.lang.Boolean, kotlin.Unit> onToggleAlarm, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.weather.app.db.AlarmEntity, kotlin.Unit> onDeleteAlarm) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.weather.app.ui.adapter.AlarmAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.weather.app.ui.adapter.AlarmAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/weather/app/ui/adapter/AlarmAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/weather/app/databinding/ItemAlarmBinding;", "(Lcom/weather/app/ui/adapter/AlarmAdapter;Lcom/weather/app/databinding/ItemAlarmBinding;)V", "bind", "", "alarm", "Lcom/weather/app/db/AlarmEntity;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.weather.app.databinding.ItemAlarmBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.weather.app.databinding.ItemAlarmBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.weather.app.db.AlarmEntity alarm) {
        }
    }
}