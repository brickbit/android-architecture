package com.admin.monuments.presenter

import com.admin.domain.model.MonumentListDto
import com.admin.domain.model.MonumentListItemDto
import com.admin.domain.repository.MonumentRepository
import com.admin.domain.repository.RefreshStrategy
import com.admin.monuments.error.ErrorHandler
import com.admin.monuments.mapper.toView
import com.admin.monuments.model.MonumentListItemView
import com.admin.monuments.model.MonumentListView
import kotlinx.coroutines.launch

class MainPresenter(
        private val repository: MonumentRepository,
        errorHandler: ErrorHandler,
        executor: com.admin.monuments.executor.Executor,
        view: View):
        Presenter<MainPresenter.View>(errorHandler,executor = executor, view = view){

    override fun attach() {
        getMonumentItems()
    }

    private fun getMonumentItems() {
        /*fakeMonumentItems().forEach {
            view.showMonumentItem(it)
        }
        view.hideProgress()*/

        scope.launch {
            view.showProgress()
            execute { repository.getMonumentList(RefreshStrategy.NETWORK) }.fold(
                    error = {view.showError(it.toString())},
                    success = {showMonumentList(it)}
            )
            view.hideProgress()
        }
        /*getMonumentListUseCase.execute(
                onNext = {
                    showMonumentList(it)
                },
                onComplete = {
                    view.hideProgress()
                },
                onError = onError{
                    view.showError(it)
                }
        )*/
    }

    fun fakeMonumentItems(): List<MonumentListView> = listOf(
           /* MonumentListView(0, "Sagrada Familia", "6234,89;0831.07"),
            MonumentListView(1, "La mezquita de Córdoba", "6234,89;0831.07"),
            MonumentListView(2, "La giralda", "6234,89;0831.07"),
            MonumentListView(3, "La torre Eiffel", "6234,89;0831.07"),
            MonumentListView(4, "Empire State", "6234,89;0831.07"),
            MonumentListView(5, "Casa Batlló", "6234,89;0831.07"),
            MonumentListView(6, "Hospital de Sant Pau", "6234,89;0831.07")*/
    )

    fun onMonumentItemClicked(monumentListItemView: MonumentListItemView) {
        view.navigateToMonumentItem(monumentListItemView.id.toString())
    }

    private fun showMonumentList(monumentListDto: MonumentListDto) {
        val itemList = toListItem(monumentListDto)
        itemList.map {
            view.showMonumentList(it.toView())
        }
    }

    private fun toListItem(monumentListDto: MonumentListDto): List<MonumentListItemDto> {
        val list = monumentListDto.list.mapIndexed { _, monumentItemDto ->
            MonumentListItemDto(monumentItemDto.id,monumentItemDto.title,monumentItemDto.geocoordinates)
        }
        return list
    }

    interface View : Presenter.View {
        fun showMonumentItem(monumentListItemView: MonumentListItemView)
        fun navigateToMonumentItem(categoryId: String)
        fun showMonumentList(monumentListItemView: MonumentListItemView)
    }

}