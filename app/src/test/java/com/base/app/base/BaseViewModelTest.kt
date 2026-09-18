package com.base.app.base

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class BaseViewModelTest {
    @Test
    fun `intent reduces the single source of truth`() = runTest {
        val viewModel = TestViewModel()

        viewModel.handleIntent(TestIntent.Increment)

        assertEquals(TestState(count = 1), viewModel.state.value)
    }

    private class TestViewModel : BaseViewModel<TestState, TestIntent, TestEffect>(TestState()) {
        override fun handleIntent(intent: TestIntent) {
            if (intent == TestIntent.Increment) setState { copy(count = count + 1) }
        }
    }

    private data class TestState(val count: Int = 0) : UiState
    private sealed interface TestIntent : UiIntent { data object Increment : TestIntent }
    private sealed interface TestEffect : UiEffect
}
