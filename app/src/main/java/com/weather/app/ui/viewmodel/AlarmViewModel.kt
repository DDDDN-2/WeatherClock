package com.weather.app.ui.viewmodel

import androidx.lifecycle.*
import com.weather.app.db.AlarmEntity
import com.weather.app.repository.AlarmRepository
import com.weather.app.utils.AlarmManagerHelper
import kotlinx.coroutines.launch

class AlarmViewModel(
    private val repository: AlarmRepository,
    private val alarmManagerHelper: AlarmManagerHelper
) : ViewModel() {
    val allAlarms: LiveData<List<AlarmEntity>> = repository.allAlarms.asLiveData()

    fun insert(alarm: AlarmEntity) = viewModelScope.launch {
        repository.insert(alarm)
        alarmManagerHelper.scheduleAlarm(alarm)
    }

    fun update(alarm: AlarmEntity) = viewModelScope.launch {
        repository.update(alarm)
        alarmManagerHelper.scheduleAlarm(alarm)
    }

    fun delete(alarm: AlarmEntity) = viewModelScope.launch {
        repository.delete(alarm)
        alarmManagerHelper.cancelAlarm(alarm)
    }

    fun getAlarmById(alarmId: Int): LiveData<AlarmEntity> = repository.getAlarmById(alarmId)
}

class AlarmViewModelFactory(
    private val repository: AlarmRepository,
    private val alarmManagerHelper: AlarmManagerHelper
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlarmViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AlarmViewModel(repository, alarmManagerHelper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
} 