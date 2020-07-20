package com.admin.monuments.presenter

import com.admin.domain.model.MonumentMainListDomain
import com.admin.domain.model.MonumentMainItemDomain
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

    private fun showMonumentList(monumentMainListDomain: MonumentMainListDomain) {
        val itemList = toListItem(monumentMainListDomain)
        itemList.map {
            view.showMonumentList(it.toView())
        }
    }

    private fun toListItem(monumentMainListDomain: MonumentMainListDomain): List<MonumentMainItemDomain> {
        val list = monumentMainListDomain.list.mapIndexed { _, monumentItemDto ->
            MonumentMainItemDomain(monumentItemDto.id,monumentItemDto.title,monumentItemDto.geocoordinates)
        }
        return list
    }

    interface View : Presenter.View {
        fun showMonumentItem(monumentListItemView: MonumentListItemView)
        fun navigateToMonumentItem(categoryId: String)
        fun showMonumentList(monumentListItemView: MonumentListItemView)
    }

}