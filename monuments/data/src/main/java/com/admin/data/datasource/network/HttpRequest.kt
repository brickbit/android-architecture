package com.admin.data.datasource.network

import com.admin.domain.model.Either
import com.admin.domain.model.Result

suspend fun <R> execute(f: suspend () -> R): Either<Result.Error, R> =
        try {
            Either.Right(f())
        } catch (requestError: Throwable) {
            val error: Result.Error = Result.Error.Default(requestError.message ?: "")
            Either.Left(error)
        }