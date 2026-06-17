package com.base.app.ui.detail

import com.base.app.base.UiEffect
import com.base.app.base.UiIntent
import com.base.app.base.UiState

data class DetailState(
    val isLoading: Boolean = false,
    val id: String = "",
    val content: String = "",
    val error: String? = null
) : UiState

sealed interface DetailIntent : UiIntent {
    data class Load(val id: String) : DetailIntent
    data object NavigateBack : DetailIntent
}

sealed interface DetailEffect : UiEffect {
    data object GoBack : DetailEffect
}
