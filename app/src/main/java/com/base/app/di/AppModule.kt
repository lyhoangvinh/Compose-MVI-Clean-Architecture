package com.base.app.di

import com.base.app.BuildConfig
import com.base.data.di.DebugLogging
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    /** Prevents request/response bodies and credentials from reaching release logs. */
    @Provides
    @DebugLogging
    fun provideDebugLogging(): Boolean = BuildConfig.DEBUG
}
