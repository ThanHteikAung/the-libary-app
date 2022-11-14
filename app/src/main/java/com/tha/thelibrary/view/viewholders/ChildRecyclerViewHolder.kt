package com.tha.thelibrary.view.viewholders

import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import kotlinx.android.synthetic.main.view_holder_child_item.view.*

class ChildRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val mImageView : ShapeableImageView = itemView.ivInnerGenreBooks
    val mChildLayout : RelativeLayout = itemView.rlChildItemLayout
}