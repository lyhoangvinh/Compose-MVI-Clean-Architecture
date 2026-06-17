package com.base.data.remote.api

import retrofit2.Response
import retrofit2.http.GET

// Stub — add endpoints per feature
interface ApiService {
    @GET("ping")
    suspend fun ping(): Response<Unit>
}
