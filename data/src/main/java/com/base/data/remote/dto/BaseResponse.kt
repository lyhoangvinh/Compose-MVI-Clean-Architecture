package com.base.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseResponse<T>(
    @Json(name = "status")  val status: String? = null,
    @Json(name = "message") val message: String? = null,
    @Json(name = "data")    val data: T? = null
)
