package com.admin.monuments.presenter

import com.admin.domain.model.MonumentItemDto
import com.admin.domain.repository.MonumentRepository
import com.admin.domain.repository.RefreshStrategy
import com.admin.monuments.error.ErrorHandler
import com.admin.monuments.mapper.toView
import com.admin.monuments.model.MonumentView
import kotlinx.coroutines.launch

class DetailPresenter(private val repository: MonumentRepository,
                      errorHandler: ErrorHandler,
                      executor: com.admin.monuments.executor.Executor,
                      view: DetailPresenter.View):
        Presenter<DetailPresenter.View>(errorHandler,executor = executor, view = view){

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
        /*
        //view.showItem(fakeItem())
        //view.hideProgress()
        var id = view.getId()
        view.showProgress()
        getMonumentItemUseCase.execute(
                id = id,
                refreshStrategy = RefreshStrategy.NETWORK,
                onNext = {
                    showItem(it)
                },
                onComplete = {
                    view.hideProgress()
                },
                onError = onError{
                    view.showError(it)
                }

        )*/
    }

    fun fakeItem(): MonumentView =
            MonumentView(1,"FakeMonument","FakeAddress","FakeTransport","FakeEmail","000.000; 000.000","Fake description","FakePhone")

    private  fun showItem(monumentItemDto: MonumentItemDto) {
        view.showItem(monumentItemDto.toView())
    }


    interface View : Presenter.View {
        fun showItem(monumentView: MonumentView)
        fun getId():Long//coge el extra
    }

}