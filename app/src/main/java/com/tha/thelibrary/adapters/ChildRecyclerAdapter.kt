package com.tha.thelibrary.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.recyclerview.widget.RecyclerView
import com.tha.thelibrary.R
import com.tha.thelibrary.data.vos.BookVO
import com.tha.thelibrary.delegates.ChildRecyclerDelegate
import com.tha.thelibrary.view.viewholders.ChildRecyclerViewHolder
import kotlinx.android.synthetic.main.fragment_library.view.*

class ChildRecyclerAdapter(private val mDelegate: ChildRecyclerDelegate?) :
    RecyclerView.Adapter<ChildRecyclerViewHolder>() {

    private var mBookList: List<BookVO>? = null

    companion object {
        const val BOOK_TYPE_ACTIVITY_NAME = "BOOKSTYPEPRESENTERIMPL"
        const val LIBRARY_FRAGMENT_NAME = "LIBRARYPRESENTERIMPL"
        const val YOUR_BOOKS_FRAGMENT_NAME = "YOURBOOKSPRESENTERIMPL"

    }

    private lateinit var mActivityName: String
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_child_item, parent, false)
        mActivityName = mDelegate.toString()     //getActivityName or fragmentName
        return ChildRecyclerViewHolder(view, mDelegate)
    }

    override fun onBindViewHolder(holder: ChildRecyclerViewHolder, position: Int) {

        //check Activity Name
        //height value by pixel(not dp)
        if (mActivityName.contains(BOOK_TYPE_ACTIVITY_NAME, ignoreCase = true)) {
            setUpResizeViewHolder(holder)
        } else if (mActivityName.contains(LIBRARY_FRAGMENT_NAME, ignoreCase = true)) {
            setUpResizeViewHolder(holder)
        } else if (mActivityName.contains(YOUR_BOOKS_FRAGMENT_NAME, ignoreCase = true)) {
            setUpResizeViewHolder(holder)
        }

        holder.bindData(mBookList?.get(position))
    }

    //Resize width/height of ViewHolder
    private fun setUpResizeViewHolder(holder: ChildRecyclerViewHolder) {
        holder.mChildLayout.layoutParams.width = TableLayout.LayoutParams.MATCH_PARENT
        holder.mImageView.layoutParams.height = 800
        holder.mImageView.layoutParams.width = TableLayout.LayoutParams.MATCH_PARENT
    }

    override fun getItemCount(): Int {
        return mBookList?.size ?: 0
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(bookList: List<BookVO>?) {
        mBookList = bookList
        notifyDataSetChanged()
    }
}