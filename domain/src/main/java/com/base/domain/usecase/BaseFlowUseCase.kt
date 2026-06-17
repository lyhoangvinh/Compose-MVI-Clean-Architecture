package com.base.domain.usecase

import kotlinx.coroutines.flow.Flow

abstract class BaseFlowUseCase<in Params, out Result> {
    abstract operator fun invoke(params: Params): Flow<Result>
}
