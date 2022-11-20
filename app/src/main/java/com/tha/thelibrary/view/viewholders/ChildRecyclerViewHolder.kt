package com.tha.thelibrary.view.viewholders

import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.tha.thelibrary.data.vos.BooksVO
import com.tha.thelibrary.delegates.ChildRecyclerDelegate
import kotlinx.android.synthetic.main.view_holder_child_item.view.*

class ChildRecyclerViewHolder(itemView: View, private val mDelegate: ChildRecyclerDelegate?) :
    RecyclerView.ViewHolder(itemView) {
    val mImageView: ShapeableImageView = itemView.ivInnerGenreBooks
    val mChildLayout: RelativeLayout = itemView.rlChildItemLayout

    private var mBooks: BooksVO? = null
    /*var mSaveBooksList: MutableList<BooksVO>? = ArrayList()*/

    init {
        itemView.ivChildOptionMenu.setOnClickListener {
            mDelegate?.onTapOptionMenu()
        }
        itemView.ivInnerGenreBooks.setOnClickListener {
            mBooks?.let { it1 -> mDelegate?.onTapItemFromEbooks(it1) }
        }
    }

    fun bindData(books: BooksVO) {
        mBooks = books
        Glide.with(itemView.context)
            .load(books.bookImage)
            .into(itemView.ivInnerGenreBooks)

        itemView.tvBooksName.text = books.title
        itemView.tvAuthorName.text = books.author
    }


}