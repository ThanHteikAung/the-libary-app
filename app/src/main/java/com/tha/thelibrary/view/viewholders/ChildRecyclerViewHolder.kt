package com.tha.thelibrary.view.viewholders

import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.tha.thelibrary.data.vos.BookVO
import com.tha.thelibrary.delegates.ChildRecyclerDelegate
import kotlinx.android.synthetic.main.view_holder_child_item.view.*

class ChildRecyclerViewHolder(itemView: View, private val mDelegate: ChildRecyclerDelegate?) :
    RecyclerView.ViewHolder(itemView) {
    val mImageView: ShapeableImageView = itemView.ivInnerGenreBooks
    val mChildLayout: RelativeLayout = itemView.rlChildItemLayout
    private var mBook: BookVO? = null

    init {
        itemView.ivChildOptionMenu.setOnClickListener {
            mDelegate?.onTapOptionMenu(mBook)
        }
        itemView.ivInnerGenreBooks.setOnClickListener {
            mDelegate?.onTapImage(mBook)
        }
    }

    fun bindData(book: BookVO?) {
        mBook = book
        Glide.with(itemView.context)
            .load(book?.bookImage)
            .into(itemView.ivInnerGenreBooks)

        itemView.tvBooksName.text = book?.title
        itemView.tvAuthorName.text = book?.author
    }

}