package com.envitech.ui.screens.dashboard.state.data

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.envitech.core.ui.DashboardBottomAppBarSpinner
import com.envitech.model.ui_models.DashboardMonitor

@Composable
fun EnvitechBottomAppBar(dashboardMonitors: List<DashboardMonitor>) {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            dashboardMonitors.forEach { dashboardMonitor ->
                DashboardBottomAppBarSpinner(model = dashboardMonitor) {

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EnvitechBottomAppBarPreview() {
    EnvitechBottomAppBar(emptyList())
}