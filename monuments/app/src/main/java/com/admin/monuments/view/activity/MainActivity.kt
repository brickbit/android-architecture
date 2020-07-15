package com.admin.monuments.view.activity
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.admin.monuments.R
import com.admin.monuments.model.MonumentListItemView
import com.admin.monuments.navigator.navigateToDetailActivity
import com.admin.monuments.presenter.MainPresenter
import com.admin.monuments.view.adapter.MonumentAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

class MainActivity : RootActivity<MainPresenter.View>(), MainPresenter.View {

    override val progress: View by lazy { progressView }

    override val presenter: MainPresenter by instance<MainPresenter>()

    override val layoutResourceId: Int= R.layout.activity_main

    override val activityModule: Kodein.Module= Kodein.Module("") {
        bind<MainPresenter>() with provider {
            MainPresenter(
                    executor = instance(),
                    repository = instance(),
                    view = this@MainActivity,
                    errorHandler = instance()
            )
        }
    }
    override fun initializeUI() {
        rv_monumentList.adapter = monumentAdapter
        rv_monumentList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

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

}
