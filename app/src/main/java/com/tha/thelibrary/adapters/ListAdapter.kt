package com.tha.thelibrary.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tha.thelibrary.R
import com.tha.thelibrary.data.vos.BookVO
import com.tha.thelibrary.delegates.ListDelegate
import com.tha.thelibrary.view.viewholders.ListViewHolder

class ListAdapter(private val mDelegate: ListDelegate) : RecyclerView.Adapter<ListViewHolder>() {

    private var mBookList: List<BookVO>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_list, parent, false)
        return ListViewHolder(view, mDelegate)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindData(mBookList?.get(position))
    }

    override fun getItemCount(): Int {
        return mBookList?.count() ?: 0
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(bookList: List<BookVO>?) {
        mBookList = bookList
        notifyDataSetChanged()
    }
}