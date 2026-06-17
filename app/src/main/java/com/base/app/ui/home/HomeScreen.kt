package com.base.app.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.base.app.base.BaseScreen
import com.base.app.ui.components.ErrorView
import com.base.app.ui.components.LoadingIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToDetail: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    BaseScreen(
        viewModel = viewModel,
        onEffect = { effect ->
            when (effect) {
                is HomeEffect.NavigateToDetail -> onNavigateToDetail(effect.id)
                is HomeEffect.ShowSnackbar     -> scope.launch { snackbarHostState.showSnackbar(effect.message) }
            }
        }
    ) { state, onIntent ->
        Scaffold(
            topBar = { TopAppBar(title = { Text("Home") }) },
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { padding ->
            when {
                state.isLoading -> LoadingIndicator(modifier = Modifier.padding(padding))
                state.error != null -> ErrorView(
                    message = state.error,
                    onRetry = { onIntent(HomeIntent.Refresh) },
                    modifier = Modifier.padding(padding)
                )
                state.items.isEmpty() -> com.base.app.ui.components.EmptyView(
                    modifier = Modifier.padding(padding)
                )
                else -> LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(padding)
                ) {
                    items(state.items) { item ->
                        ListItem(
                            headlineContent = { Text(item) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onIntent(HomeIntent.OnItemClick(item)) }
                        )
                        HorizontalDivider()
                    }
                }
            }
        }
    }
}
