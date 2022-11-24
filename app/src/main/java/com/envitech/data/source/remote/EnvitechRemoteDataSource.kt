package com.envitech.data.source.remote

import com.envitech.model.server_models.MonitorResponse
import kotlinx.coroutines.flow.Flow

interface EnvitechRemoteDataSource {

    suspend fun getMonitorResponse() : Flow<MonitorResponse>

}