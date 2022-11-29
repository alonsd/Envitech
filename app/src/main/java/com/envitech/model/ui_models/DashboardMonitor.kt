package com.envitech.model.ui_models

data class DashboardMonitor(
    val monitorTypeName: String,
    val monitorTypeId: Int,
    var isSelected: Boolean = true,
    var isExpanded: Boolean = false,
    var legends: List<Legend>,
    val monitors: List<Monitor>
) {

    data class Monitor(
        val name: String,
        val secondaryMonitorId: Int,
        val monitorTypeId: Int,
        var isSelected: Boolean = false,
    )

    data class Legend(
        val color: String,
        val label: String
    )
}
