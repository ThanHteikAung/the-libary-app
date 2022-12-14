package com.tha.thelibrary.view.viewholders

import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.tha.thelibrary.delegates.ChildRecyclerDelegate
import kotlinx.android.synthetic.main.view_holder_child_item.view.*

class ChildRecyclerViewHolder(itemView: View,private val mDelegate:ChildRecyclerDelegate) : RecyclerView.ViewHolder(itemView) {
    val mImageView : ShapeableImageView = itemView.ivInnerGenreBooks
    val mChildLayout : RelativeLayout = itemView.rlChildItemLayout

    init {
        itemView.ivChildOptionMenu.setOnClickListener {
            mDelegate.onTapOptionMenu()
        }
    }

}