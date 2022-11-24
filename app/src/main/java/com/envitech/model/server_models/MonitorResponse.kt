package com.envitech.model.server_models


import com.google.gson.annotations.SerializedName

data class MonitorResponse(
    @SerializedName("Legends")
    val legends: List<Legend>,
    @SerializedName("Monitor")
    val monitor: List<Monitor>,
    @SerializedName("MonitorType")
    val monitorType: List<MonitorType>
) {
    data class Legend(
        @SerializedName("Id")
        val id: Int,
        @SerializedName("tags")
        val tags: List<Tag>
    ) {
        data class Tag(
            @SerializedName("Color")
            val color: String,
            @SerializedName("Label")
            val label: String
        )
    }

    data class Monitor(
        @SerializedName("Desc")
        val desc: String,
        @SerializedName("Id")
        val id: Int,
        @SerializedName("MonitorTypeId")
        val monitorTypeId: Int,
        @SerializedName("Name")
        val name: String
    )

    data class MonitorType(
        @SerializedName("description")
        val description: String,
        @SerializedName("Id")
        val id: Int,
        @SerializedName("LegendId")
        val legendId: Int,
        @SerializedName("Name")
        val name: String
    )
}