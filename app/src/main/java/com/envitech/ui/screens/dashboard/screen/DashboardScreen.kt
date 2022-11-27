package com.envitech.ui.screens.dashboard.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.envitech.ui.screens.dashboard.state.data.DashboardDataState
import com.envitech.ui.screens.dashboard.viewmodel.DashboardViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph


@RootNavGraph(start = true)
@Destination
@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    when (val state = uiState) {
        is DashboardViewModel.UiState.Data -> {
            DashboardDataState(state.dashboardMonitors)
        }
        is DashboardViewModel.UiState.Error -> {

        }
        DashboardViewModel.UiState.Loading -> {

        }
    }
}

