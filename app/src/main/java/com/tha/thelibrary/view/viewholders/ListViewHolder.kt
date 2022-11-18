package com.tha.thelibrary.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tha.thelibrary.delegates.ListDelegate
import kotlinx.android.synthetic.main.view_holder_list.view.*

class ListViewHolder(itemView: View,private val mDelegate: ListDelegate) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.ivListOptionMenu.setOnClickListener {
            mDelegate.onTapListOptionMenu()
        }
    }

}