package com.base.app.ui.home

import com.base.app.base.UiEffect
import com.base.app.base.UiIntent
import com.base.app.base.UiState

data class HomeState(
    val isLoading: Boolean = false,
    val items: List<String> = emptyList(),
    val error: String? = null
) : UiState

sealed interface HomeIntent : UiIntent {
    data object LoadData : HomeIntent
    data class OnItemClick(val id: String) : HomeIntent
    data object Refresh : HomeIntent
}

sealed interface HomeEffect : UiEffect {
    data class NavigateToDetail(val id: String) : HomeEffect
    data class ShowSnackbar(val message: String) : HomeEffect
}
