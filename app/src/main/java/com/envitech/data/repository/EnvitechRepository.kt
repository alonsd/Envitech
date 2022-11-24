package com.envitech.data.repository

import com.envitech.core.extensions.Result
import com.envitech.model.server_models.MonitorResponse
import kotlinx.coroutines.flow.Flow

interface EnvitechRepository {

    suspend fun getMonitorResponse(): Flow<Result<MonitorResponse>>

}