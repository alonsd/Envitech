package com.envitech.ui.screens.dashboard.state.data

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.envitech.model.ui_models.DashboardMonitors

@Composable
fun DashboardDataState(dashboardMonitors: List<DashboardMonitors>) {
    Scaffold(
        bottomBar = { EnvitechBottomAppBar() },
        content = { paddingValues ->
            DashboardDataStateContent(modifier = Modifier.padding(paddingValues))
        })

}


@Preview(showBackground = true)
@Composable
fun DashboardDataStatePreview() {
    DashboardDataState(emptyList())
}