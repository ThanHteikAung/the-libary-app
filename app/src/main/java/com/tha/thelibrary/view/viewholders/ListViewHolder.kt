package com.tha.thelibrary.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tha.thelibrary.data.vos.BookVO
import com.tha.thelibrary.delegates.ListDelegate
import kotlinx.android.synthetic.main.view_holder_list.view.*

class ListViewHolder(itemView: View, private val mDelegate: ListDelegate) :
    RecyclerView.ViewHolder(itemView) {

    private var mBook: BookVO? = null

    init {
        itemView.ivListOptionMenu.setOnClickListener {
            mDelegate.onTapListOptionMenu(mBook)
        }
    }

    fun bindData(book: BookVO?) {
        mBook = book
        Glide.with(itemView.context)
            .load(book?.bookImage)
            .into(itemView.ivList)

        itemView.tvListTitle.text = book?.title
        itemView.tvListAuthor.text = book?.author
    }

}