package com.admin.monuments.presenter

import com.admin.domain.model.Either
import com.admin.domain.model.Result
import com.admin.monuments.error.ErrorHandler
import com.admin.monuments.executor.Executor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.withContext

/**
 * Presenter
 */
abstract class Presenter<out V : Presenter.View>(
        protected val errorHandler: ErrorHandler,
        protected val executor: Executor,
        val view: V
) {

    private val job = SupervisorJob()

    protected val scope = CoroutineScope(job + executor.main)

    abstract fun attach()

    fun detach() = job.cancel()

    protected suspend fun <T> execute(f: suspend () -> Either<Result.Error, T>): Either<Result.Error, T> = withContext(executor.background) { f() }

    protected fun onError(callback: (String) -> Unit): (Result.Error) -> Unit = {
        view.hideProgress()

        val message = errorHandler.convert(it)

        callback(message)
    }

    interface View {
        fun showProgress()

        fun hideProgress()

        fun showError(error: String)

        fun showError(errorId: Int)

        fun showMessage(message: String)

        fun showMessage(messageId: Int)
    }
}