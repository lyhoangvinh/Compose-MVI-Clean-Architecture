package com.base.app.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest

/**
 * Connects a ViewModel to a Composable screen.
 * Handles state collection and one-time effects automatically.
 *
 * Usage:
 *   BaseScreen(viewModel = hiltViewModel()) { state, onIntent ->
 *       MyScreenContent(state, onIntent)
 *   }
 */
@Composable
fun <S : UiState, I : UiIntent, E : UiEffect> BaseScreen(
    viewModel: BaseViewModel<S, I, E>,
    onEffect: (suspend (E) -> Unit)? = null,
    content: @Composable (state: S, onIntent: (I) -> Unit) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    if (onEffect != null) {
        LaunchedEffect(viewModel) {
            viewModel.effect.collectLatest { onEffect(it) }
        }
    }

    content(state, viewModel::handleIntent)
}
