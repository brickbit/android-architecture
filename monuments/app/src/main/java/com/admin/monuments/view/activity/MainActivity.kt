package com.admin.monuments.view.activity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.admin.monuments.R
import com.admin.monuments.model.MonumentListItemView
import com.admin.monuments.model.MonumentListView
import com.admin.monuments.navigator.navigateToDetailActivity
import com.admin.monuments.presenter.MainPresenter
import com.admin.monuments.view.adapter.MonumentAdapter
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_progress.*

class MainActivity :  RootActivity<MainPresenter.View>(), MainPresenter.View {


    override val presenter: MainPresenter by instance()

    override val layoutResourceId: Int= R.layout.activity_main

    override val activityModule: Kodein.Module= Kodein.Module {
        bind<MainPresenter>() with provider {
            MainPresenter(
                    getMonumentListUseCase = instance(),
                    view = this@MainActivity,
                    errorHandler = instance()
            )
        }
    }
    override fun initializeUI() {
        rv_monumentList.adapter = monumentAdapter
        rv_monumentList.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

    }

    override fun showMonumentList(monumentListItemView: MonumentListItemView) {
        monumentAdapter.add(monumentListItemView)
    }


    override fun registerListeners() {
        //Nothing to do here yet
    }

    override fun showMonumentItem(monumentListItemView: MonumentListItemView) {
        monumentAdapter.add(monumentListItemView)
    }

    override fun navigateToMonumentItem(categoryId: String) {
        navigateToDetailActivity(this, categoryId)
    }

    private val monumentAdapter = MonumentAdapter {
        presenter.onMonumentItemClicked(it)
    }

    override fun showProgress() {
        progress.show()
    }

    override fun hideProgress() {
        progress.hide()
    }

}
