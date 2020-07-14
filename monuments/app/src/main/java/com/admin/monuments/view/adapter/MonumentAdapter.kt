package com.admin.monuments.view.adapter

import android.view.View
import com.admin.monuments.R
import com.admin.monuments.model.MonumentListItemView
import com.admin.monuments.model.MonumentListView
import kotlinx.android.synthetic.main.monument.view.*

class MonumentAdapter(onItemClick: (MonumentListItemView) -> Unit)
    : RootAdapter<MonumentListItemView>(onItemClickListener = onItemClick) {

    override val itemLayoutId: Int = R.layout.monument

    override fun getItemCount() = items.size

    override fun viewHolder(view: View): RootViewHolder<MonumentListItemView> = HistoryViewHolder(view)

    class HistoryViewHolder(itemView: View) : RootViewHolder<MonumentListItemView>(itemView) {
        override fun bind(model: MonumentListItemView) {
            itemView.tv_idMonument.text = model.id.toString()
            itemView.tv_titleMonument.text = model.title
            itemView.tv_coordinatesMonument.text = model.geocoordinates
        }
    }
}