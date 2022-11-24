package com.envitech.di.binding

import com.envitech.data.source.remote.EnvitechRemoteDataSource
import com.envitech.data.source.remote.EnvitechRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindEnvitechRemoteDataSource(
        envitechRemoteDataSourceImpl: EnvitechRemoteDataSourceImpl
    ): EnvitechRemoteDataSource
}