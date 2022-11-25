package com.envitech.ui.screens.dashboard.state

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.envitech.model.ui_models.DashboardMonitors

@Composable
fun DashboardDataState(dashboardMonitors: List<DashboardMonitors>) {

    BottomAppBar(modifier = Modifier.fillMaxSize()) {

    }
}

@Preview(showBackground = true)
@Composable
fun DashboardDataStatePreview() {
    DashboardDataState(emptyList())
}