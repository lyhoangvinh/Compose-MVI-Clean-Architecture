package com.base.data.repository

import com.base.domain.model.BaseResult
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

abstract class BaseRepositoryImpl {

    protected suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): BaseResult<T> {
        return try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) BaseResult.Success(body)
                else BaseResult.Error(code = response.code(), message = "Empty response body")
            } else {
                BaseResult.Error(code = response.code(), message = response.message())
            }
        } catch (e: HttpException) {
            BaseResult.Error(code = e.code(), message = e.message())
        } catch (e: IOException) {
            BaseResult.Error(message = "Network error: ${e.localizedMessage}", throwable = e)
        } catch (e: Exception) {
            BaseResult.Error(message = e.localizedMessage, throwable = e)
        }
    }

    protected suspend fun <T> safeDbCall(dbCall: suspend () -> T): BaseResult<T> {
        return try {
            BaseResult.Success(dbCall())
        } catch (e: Exception) {
            BaseResult.Error(message = e.localizedMessage, throwable = e)
        }
    }
}
