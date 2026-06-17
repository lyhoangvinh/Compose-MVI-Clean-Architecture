package com.base.data.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// Bind repository interfaces to implementations here as you create features:
// @Binds @Singleton abstract fun bindXxxRepository(impl: XxxRepositoryImpl): XxxRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule
