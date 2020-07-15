package com.admin.monuments.view.activity

import android.util.Log
import android.view.View
import com.admin.monuments.R
import com.admin.monuments.model.MonumentView
import com.admin.monuments.presenter.MonumentDetailPresenter
import kotlinx.android.synthetic.main.activity_detail.*
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

class MonumentDetailActivity :  RootActivity<MonumentDetailPresenter.View>(), MonumentDetailPresenter.View {

    override fun getId(): Long {
        return intent.getStringExtra(CATEGORY_ID_KEY).toLong()
    }

    companion object {
        const val CATEGORY_ID_KEY = "CATEGORY_ID_KEY"
    }

    override val progress: View by lazy { progressViewDetail }

    override val presenter: MonumentDetailPresenter by instance<MonumentDetailPresenter>()

    override val layoutResourceId: Int = R.layout.activity_detail

    override val activityModule: Kodein.Module = Kodein.Module("MonumentDetailActivity") {
        bind<MonumentDetailPresenter>() with provider {
            MonumentDetailPresenter(
                    executor = instance(),
                    repository = instance(),
                    view = this@MonumentDetailActivity,
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
