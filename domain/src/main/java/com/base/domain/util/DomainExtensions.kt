package com.base.domain.util

import com.base.domain.model.BaseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

fun <T> Flow<T>.asResult(): Flow<BaseResult<T>> =
    this
        .map<T, BaseResult<T>> { BaseResult.Success(it) }
        .onStart { emit(BaseResult.Loading) }
        .catch { emit(BaseResult.Error(message = it.localizedMessage, throwable = it)) }
