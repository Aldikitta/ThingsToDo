package com.aldikitta.thingstodo.features.splash.di

import com.aldikitta.thingstodo.features.splash.repository.SplashEnvironmentRepository
import com.aldikitta.thingstodo.features.splash.repository.SplashEnvironmentRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class SplashModule {
    @Binds
    abstract fun provideEnvironment(
        environment: SplashEnvironmentRepositoryImpl
    ): SplashEnvironmentRepository
}