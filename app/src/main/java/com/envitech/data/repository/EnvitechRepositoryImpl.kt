package com.envitech.data.repository

import com.envitech.core.extensions.Result
import com.envitech.core.extensions.asResult
import com.envitech.data.source.remote.EnvitechRemoteDataSource
import com.envitech.model.server_models.MonitorResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EnvitechRepositoryImpl @Inject constructor(
    private val envitechRemoteDataSource: EnvitechRemoteDataSource,
) : EnvitechRepository {

    override suspend fun getMonitorResponse(): Flow<Result<MonitorResponse>> =
        envitechRemoteDataSource.getMonitorResponse().asResult()
}

