package com.envitech.ui.screens.dashboard.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
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

    when (uiState) {
        is DashboardViewModel.UiState.Data -> {
            try {
                val dashboardMonitors = (uiState as DashboardViewModel.UiState.Data).dashboardMonitors
                Log.d("defaultAppDebuger", "data: $dashboardMonitors")
            } catch (e: Exception) {

            }
        }
        is DashboardViewModel.UiState.Error -> {

        }
        DashboardViewModel.UiState.Loading -> {

        }
    }
}

