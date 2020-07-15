package com.admin.monuments.presenter

import com.admin.domain.model.MonumentListDomain
import com.admin.domain.model.MonumentListItemDomain
import com.admin.domain.repository.Repository
import com.admin.domain.repository.RefreshStrategy
import com.admin.monuments.error.ErrorHandler
import com.admin.monuments.mapper.toView
import com.admin.monuments.model.MonumentListItemView
import kotlinx.coroutines.launch

class MonumentListPresenter(
        private val repository: Repository,
        errorHandler: ErrorHandler,
        executor: com.admin.monuments.executor.Executor,
        view: View):
        Presenter<MonumentListPresenter.View>(errorHandler,executor = executor, view = view){

    override fun attach() {
        getMonumentItems()
    }

    private fun getMonumentItems() {
        scope.launch {
            view.showProgress()
            execute { repository.getMonumentList(RefreshStrategy.NETWORK) }.fold(
                    error = {view.showError(it.toString())},
                    success = {showMonumentList(it)}
            )
            view.hideProgress()
        }
    }

    fun onMonumentItemClicked(monumentListItemView: MonumentListItemView) {
        view.navigateToMonumentItem(monumentListItemView.id.toString())
    }

    private fun showMonumentList(monumentListDomain: MonumentListDomain) {
        val itemList = toListItem(monumentListDomain)
        itemList.map {
            view.showMonumentList(it.toView())
        }
    }

    private fun toListItem(monumentListDomain: MonumentListDomain): List<MonumentListItemDomain> {
        val list = monumentListDomain.list.mapIndexed { _, monumentItemDto ->
            MonumentListItemDomain(monumentItemDto.id,monumentItemDto.title,monumentItemDto.geocoordinates)
        }
        return list
    }

    interface View : Presenter.View {
        fun showMonumentItem(monumentListItemView: MonumentListItemView)
        fun navigateToMonumentItem(categoryId: String)
        fun showMonumentList(monumentListItemView: MonumentListItemView)
    }

}