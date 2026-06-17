package com.base.app.ui.home

import com.base.app.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    // Inject use cases here, e.g.: private val getItemsUseCase: GetItemsUseCase
) : BaseViewModel<HomeState, HomeIntent, HomeEffect>(HomeState()) {

    init {
        handleIntent(HomeIntent.LoadData)
    }

    override fun handleIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.LoadData -> loadData()
            is HomeIntent.Refresh  -> loadData()
            is HomeIntent.OnItemClick -> {
                sendEffect(HomeEffect.NavigateToDetail(intent.id))
            }
        }
    }

    private fun loadData() {
        launchIO {
            setState { copy(isLoading = true, error = null) }
            try {
                // Replace with real use case call:
                // val result = getItemsUseCase(NoParams)
                delay(1000L) // simulate network
                setState { copy(isLoading = false, items = listOf("Item 1", "Item 2", "Item 3")) }
            } catch (e: Exception) {
                setState { copy(isLoading = false, error = e.localizedMessage) }
                sendEffect(HomeEffect.ShowSnackbar("Failed to load data"))
            }
        }
    }
}
