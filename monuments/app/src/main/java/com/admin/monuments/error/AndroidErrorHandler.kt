package com.admin.monuments.error

import android.content.Context
import com.admin.domain.model.Result
import com.admin.monuments.R

/**
 * AndroidErrorHandler.
 */
class AndroidErrorHandler(val context: Context) : ErrorHandler {
    override fun convert(e: Result.Error): String =
            when (e) {
                else -> context.getString(R.string.default_error)
            }

}