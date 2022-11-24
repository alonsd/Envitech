package com.envitech.ui.screens.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.envitech.core.extensions.Result
import com.envitech.data.repository.EnvitechRepository
import com.envitech.model.ui_models.DashboardMonitors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val envitechRepository: EnvitechRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    private val uiEvent = _uiEvent.asSharedFlow()

    init {
        observeUiEvents()
        getDashboardMonitors()
    }

    private fun getDashboardMonitors() = viewModelScope.launch {
        envitechRepository.getMonitorResponse().map { result ->
            when (result) {
                is Result.Error -> {
                    submitUiState(UiState.Error(result.exception?.localizedMessage ?: ""))
                }
                Result.Loading -> {
                    submitUiState(UiState.Loading)
                }
                is Result.Success -> {
                    submitUiState(UiState.Data(dashboardMonitors = emptyList()))
                }
            }
        }.collect()
    }


    private fun observeUiEvents() = viewModelScope.launch {
        uiEvent.collect { event ->
            when (event) {

                else -> {}
            }
        }
    }

    fun submitUiState(uiState: UiState) = viewModelScope.launch {
        _uiState.emit(uiState)
    }

    fun submitEvent(uiEvent: UiEvent) = viewModelScope.launch {
        _uiEvent.emit(uiEvent)
    }

    sealed interface UiEvent {
        object OnSecondaryMonitorClicked : UiEvent
    }

    sealed interface UiState {
        data class Data(val dashboardMonitors: List<DashboardMonitors>) : UiState
        data class Error(val reason: String) : UiState
        object Loading : UiState
    }
}