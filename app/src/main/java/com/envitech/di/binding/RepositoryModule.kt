package com.envitech.di.binding

import com.envitech.data.repository.EnvitechRepository
import com.envitech.data.repository.EnvitechRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindEnvitechRepository(
        envitechRepositoryImpl: EnvitechRepositoryImpl
    ): EnvitechRepository

}