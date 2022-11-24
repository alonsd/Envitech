package com.envitech.model.ui_models

data class DashboardMonitors(
    val rootMonitorName: String,
    val secondaryMonitors: List<SecondaryMonitor>
) {

    data class SecondaryMonitor(val name: String, val secondaryMonitorId: Int)
}
