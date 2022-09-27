package com.aldikitta.thingstodo.features.host.di

import com.aldikitta.thingstodo.features.host.repository.HostEnvironmentImpl
import com.aldikitta.thingstodo.features.host.repository.HostEnvironmentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class HostModule {

    @Binds
    abstract fun provideEnvironment(
        environment: HostEnvironmentImpl
    ): HostEnvironmentRepository
}