package com.admin.domain.model

sealed class Result {
    data class Success<T>(val value: T) : Result()
    sealed class Error : Result() {
        data class Default(val messageError: String = ""): Error()
        object NoInternet : Error()
    }
}