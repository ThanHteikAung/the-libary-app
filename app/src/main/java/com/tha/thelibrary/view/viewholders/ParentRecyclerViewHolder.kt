package com.tha.thelibrary.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_holder_parent_item.view.*

class ParentRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val mChileRecyclerView: RecyclerView = itemView.rvChildRecycler

    init {
        itemView.btnOuterHeader.setOnClickListener {

        }
    }

}