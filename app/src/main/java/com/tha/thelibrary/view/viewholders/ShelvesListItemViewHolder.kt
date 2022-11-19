package com.tha.thelibrary.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tha.thelibrary.delegates.ShelvesListItemDelegate
import kotlinx.android.synthetic.main.view_holder_your_shelves_item.view.*

class ShelvesListItemViewHolder(itemView: View, private val mDelegate: ShelvesListItemDelegate) :
    RecyclerView.ViewHolder(itemView) {

        init {
            itemView.btnDetailShelves.setOnClickListener {
                mDelegate.onTapShelvesDetailList()
            }
        }
}