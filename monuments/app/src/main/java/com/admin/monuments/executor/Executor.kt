package com.admin.monuments.executor

import kotlinx.coroutines.CoroutineDispatcher

interface Executor {
    val main: CoroutineDispatcher
    val background: CoroutineDispatcher
}