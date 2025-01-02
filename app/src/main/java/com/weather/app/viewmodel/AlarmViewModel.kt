package com.weather.app.viewmodel

import androidx.lifecycle.*
import com.weather.app.db.AlarmEntity
import com.weather.app.repository.AlarmRepository
import kotlinx.coroutines.launch

class AlarmViewModel(private val repository: AlarmRepository) : ViewModel() {
    val allAlarms: LiveData<List<AlarmEntity>> = repository.allAlarms.asLiveData()

    fun insert(alarm: AlarmEntity) = viewModelScope.launch {
        repository.insert(alarm)
    }

    fun update(alarm: AlarmEntity) = viewModelScope.launch {
        repository.update(alarm)
    }

    fun delete(alarm: AlarmEntity) = viewModelScope.launch {
        repository.delete(alarm)
    }
}

class AlarmViewModelFactory(private val repository: AlarmRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlarmViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AlarmViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
} 