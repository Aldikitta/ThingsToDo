package com.aldikitta.thingstodo.features.localized.setting.di

import com.aldikitta.thingstodo.features.localized.setting.data.LocalizedSettingEnvironmentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class LocalizedSettingModule {
    @Binds
    abstract fun provideEnvironment(
        environment: LocalizedSettingEnvironmentRepository
    ): LocalizedSettingEnvironmentRepository
}