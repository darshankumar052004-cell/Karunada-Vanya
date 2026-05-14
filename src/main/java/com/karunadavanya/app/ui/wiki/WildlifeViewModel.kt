package com.karunadavanya.app.ui.wiki

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karunadavanya.app.data.local.entity.WildlifeEntity
import com.karunadavanya.app.data.repository.WildlifeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class WildlifeViewModel @Inject constructor(
    private val wildlifeRepository: WildlifeRepository
) : ViewModel() {

    private val _currentFilter = MutableStateFlow("All")
    val currentFilter: StateFlow<String> = _currentFilter

    val wildlifeList: StateFlow<List<WildlifeEntity>> = _currentFilter.flatMapLatest { filter ->
        if (filter == "All") {
            wildlifeRepository.getAllWildlife()
        } else {
            wildlifeRepository.getWildlifeByType(filter)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun setFilter(filterType: String) {
        _currentFilter.value = filterType
    }
}
