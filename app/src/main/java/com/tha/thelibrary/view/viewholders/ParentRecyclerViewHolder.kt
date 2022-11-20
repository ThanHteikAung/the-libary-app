package com.tha.thelibrary.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tha.thelibrary.data.vos.ListVO
import com.tha.thelibrary.delegates.ParentRecyclerDelegate
import kotlinx.android.synthetic.main.view_holder_parent_item.view.*

class ParentRecyclerViewHolder(itemView: View,private val mDelegate: ParentRecyclerDelegate) : RecyclerView.ViewHolder(itemView) {
    val mChileRecyclerView: RecyclerView = itemView.rvChildRecycler

    init {
        itemView.btnOuterHeader.setOnClickListener {
            mDelegate.onTapParentRecyclerHeader()
        }
    }

    fun bindData(list : ListVO){
       itemView.btnOuterHeader.text = list.listName
    }

}