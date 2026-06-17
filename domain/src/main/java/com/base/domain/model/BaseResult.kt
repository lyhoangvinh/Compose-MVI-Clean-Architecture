package com.base.domain.model

sealed class BaseResult<out T> {
    data class Success<out T>(val data: T) : BaseResult<T>()
    data class Error(
        val code: Int? = null,
        val message: String? = null,
        val throwable: Throwable? = null
    ) : BaseResult<Nothing>()
    data object Loading : BaseResult<Nothing>()
}

inline fun <T> BaseResult<T>.onSuccess(action: (T) -> Unit): BaseResult<T> {
    if (this is BaseResult.Success) action(data)
    return this
}

inline fun <T> BaseResult<T>.onError(action: (BaseResult.Error) -> Unit): BaseResult<T> {
    if (this is BaseResult.Error) action(this)
    return this
}

inline fun <T> BaseResult<T>.onLoading(action: () -> Unit): BaseResult<T> {
    if (this is BaseResult.Loading) action()
    return this
}
