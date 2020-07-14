package com.admin.monuments.error

import com.admin.domain.model.Result

/**
 * ErrorHandler.
 */
interface ErrorHandler {
    fun convert(e: Result.Error): String
}