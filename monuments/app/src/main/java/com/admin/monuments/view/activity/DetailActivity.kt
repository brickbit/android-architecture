package com.admin.monuments.view.activity

import android.util.Log
import com.admin.monuments.R
import com.admin.monuments.model.MonumentView
import com.admin.monuments.presenter.DetailPresenter
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.view_progress.*

class DetailActivity :  RootActivity<DetailPresenter.View>(), DetailPresenter.View {
    override fun getId(): Long {
        return intent.getStringExtra(CATEGORY_ID_KEY).toLong()
    }

    companion object {
        const val CATEGORY_ID_KEY = "CATEGORY_ID_KEY"
    }

    override val presenter: DetailPresenter by instance()

    override val layoutResourceId: Int = R.layout.activity_detail

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<DetailPresenter>() with provider {
            DetailPresenter(
                    executor = instance(),
                    repository = instance(),
                    view = this@DetailActivity,
                    errorHandler = instance()
            )
        }
    }

    override fun initializeUI() {
        val id: String = intent.getStringExtra(CATEGORY_ID_KEY)
        Log.d("BRICKBIT3","Es la actividad "+ id)
    }

    override fun registerListeners() {
        //Nothing to do here yet
    }

    override fun showProgress() {
        progress.show()
    }

    override fun hideProgress() {
        progress.hide()
    }

    override fun showItem(monumentView: MonumentView) {
        tv_idItem.text=monumentView.id.toString()
        tv_titleItem.text = monumentView.title
        tv_geocoordinatesItem.text = monumentView.geocoordinates
        tv_descriptionItem.text = monumentView.description
        tv_addressItem.text = monumentView.address
        tv_email.text = monumentView.email
        tv_transport.text = monumentView.transport
        tv_phoneItem.text = monumentView.phone
    }
}
