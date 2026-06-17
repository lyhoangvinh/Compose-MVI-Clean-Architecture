package com.base.domain.usecase

abstract class BaseUseCase<in Params, out Result> {
    abstract suspend operator fun invoke(params: Params): Result
}

data object NoParams
