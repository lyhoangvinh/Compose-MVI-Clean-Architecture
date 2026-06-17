package com.base.app.ui.detail

import com.base.app.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() :
    BaseViewModel<DetailState, DetailIntent, DetailEffect>(DetailState()) {

    override fun handleIntent(intent: DetailIntent) {
        when (intent) {
            is DetailIntent.Load -> loadDetail(intent.id)
            is DetailIntent.NavigateBack -> sendEffect(DetailEffect.GoBack)
        }
    }

    private fun loadDetail(id: String) {
        launchIO {
            setState { copy(isLoading = true, id = id) }
            delay(500L) // simulate
            setState { copy(isLoading = false, content = "Detail content for: $id") }
        }
    }
}
