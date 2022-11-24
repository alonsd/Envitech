package com.envitech.data.source.remote

import com.envitech.model.server_models.MonitorResponse
import retrofit2.http.GET


interface EnvitechApi {

    @GET("config")
    suspend fun getMonitorResponse() : MonitorResponse
}