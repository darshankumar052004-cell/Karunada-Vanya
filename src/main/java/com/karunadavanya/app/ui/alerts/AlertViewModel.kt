package com.karunadavanya.app.ui.alerts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karunadavanya.app.data.local.entity.AlertEntity
import com.karunadavanya.app.data.repository.AlertRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlertViewModel @Inject constructor(
    private val alertRepository: AlertRepository
) : ViewModel() {

    val activeAlerts: StateFlow<List<AlertEntity>> = alertRepository.getActiveAlerts()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun reportSighting(animalType: String, location: String, notes: String) {
        viewModelScope.launch {
            val alert = AlertEntity(
                animalType = animalType,
                location = location,
                notes = notes,
                timestamp = System.currentTimeMillis()
            )
            alertRepository.insertAlert(alert)
        }
    }
}
