package com.envitech.data.source.remote

import com.envitech.model.server_models.MonitorResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EnvitechRemoteDataSourceImpl @Inject constructor(
    private val envitechApi: EnvitechApi
) : EnvitechRemoteDataSource {

    override suspend fun getMonitorResponse(): Flow<MonitorResponse> = flow {
        emit(envitechApi.getMonitorResponse())
    }


}