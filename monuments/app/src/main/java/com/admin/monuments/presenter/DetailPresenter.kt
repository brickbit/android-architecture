package com.admin.monuments.presenter

import com.admin.domain.interactor.monuments.GetMonumentItemUseCase
import com.admin.domain.model.MonumentItemDto
import com.admin.domain.repository.RefreshStrategy
import com.admin.monuments.error.ErrorHandler
import com.admin.monuments.mapper.toView
import com.admin.monuments.model.MonumentView

class DetailPresenter(private val getMonumentItemUseCase: GetMonumentItemUseCase,
                      errorHandler: ErrorHandler,
                      view: DetailPresenter.View):
        Presenter<DetailPresenter.View>(errorHandler,view){
    override fun initialize() {
        view.getId()
        getItems()
    }

    override fun resume() {
        //Nothing to do yet
    }

    override fun stop() {
        //Nothing to do yet
    }

    override fun destroy() {
        //getMonumentItemUseCase.clear()
    }

    private fun getItems(){
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

        )
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