package com.envitech.ui.screens.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.envitech.core.extensions.Result
import com.envitech.data.repository.EnvitechRepository
import com.envitech.model.server_models.MonitorResponse
import com.envitech.model.ui_models.DashboardMonitor
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

    val flowTest = flow { emit("sdfsdfsdf") }
    fun flowFunctionTest() = flowTest.stateIn(viewModelScope)

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
                    val dashboardMonitorsModels = getDashboardMonitorsModels(result.data)
                    submitUiState(UiState.Data(dashboardMonitors = emptyList()))
                }
            }
        }.collect()
    }

    private fun getDashboardMonitorsModels(response: MonitorResponse): List<DashboardMonitor> {
        val serverMonitors = response.monitor.toHashSet()
        val legends = response.legends.toHashSet()
        val dashboardMonitors = mutableListOf<DashboardMonitor>()
        response.monitorType.forEach { type ->
            val monitorsWithSameTypeId = serverMonitors.filter { it.id == type.id }
            val monitors = mutableListOf<DashboardMonitor.Monitor>()
            monitorsWithSameTypeId.forEach { monitor ->
                monitors.add(
                    DashboardMonitor.Monitor(
                        monitor.name,
                        monitor.id,
                        monitor.monitorTypeId
                    )
                )
            }
            val legend = legends.find { it.id == type.legendId } ?: return@forEach
            val dashboardLegends = mutableListOf<DashboardMonitor.Legend>()
            legend.tags.forEach { tag ->
                dashboardLegends.add(DashboardMonitor.Legend(tag.color, tag.label))
            }
            val dashboardMonitor = DashboardMonitor(
                monitorTypeName = type.name,
                monitorTypeId = type.id,
                legends = dashboardLegends,
                monitors = monitors)
            dashboardMonitors.add(dashboardMonitor)
        }
        return dashboardMonitors
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
        data class Data(val dashboardMonitors: List<DashboardMonitor>) : UiState
        data class Error(val reason: String) : UiState
        object Loading : UiState
    }
}