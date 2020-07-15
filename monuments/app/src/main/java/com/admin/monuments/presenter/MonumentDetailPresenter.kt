package com.admin.monuments.presenter

import com.admin.domain.model.MonumentItemDomain
import com.admin.domain.repository.Repository
import com.admin.domain.repository.RefreshStrategy
import com.admin.monuments.error.ErrorHandler
import com.admin.monuments.mapper.toView
import com.admin.monuments.model.MonumentView
import kotlinx.coroutines.launch

class MonumentDetailPresenter(private val repository: Repository,
                              errorHandler: ErrorHandler,
                              executor: com.admin.monuments.executor.Executor,
                              view: View):
        Presenter<MonumentDetailPresenter.View>(errorHandler,executor = executor, view = view){

    override fun attach() {
        view.getId()
        getItems()
    }

    private fun getItems(){

        scope.launch {
            view.showProgress()
            execute { repository.getMonumentItem(view.getId(), RefreshStrategy.NETWORK) }.fold(
                    error = {view.showError(it.toString())},
                    success = {showItem(it)}
            )
            view.hideProgress()
        }
    }

    private  fun showItem(monumentItemDto: MonumentItemDomain) {
        view.showItem(monumentItemDto.toView())
    }


    interface View : Presenter.View {
        fun showItem(monumentView: MonumentView)
        fun getId():Long
    }

}