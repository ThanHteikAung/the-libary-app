package com.tha.thelibrary.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tha.thelibrary.R
import com.tha.thelibrary.data.vos.ListBookCategoryVO
import com.tha.thelibrary.delegates.ChildRecyclerDelegate
import com.tha.thelibrary.delegates.ParentRecyclerDelegate
import com.tha.thelibrary.view.viewholders.ParentRecyclerViewHolder

class ParentRecyclerAdapter(
    private val mParentDelegate: ParentRecyclerDelegate,
    private val mChildDelegate: ChildRecyclerDelegate
) : RecyclerView.Adapter<ParentRecyclerViewHolder>() {

    private lateinit var mChildRecyclerAdapter: ChildRecyclerAdapter
    private var mListBookCategory: List<ListBookCategoryVO>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_parent_item, parent, false)
        return ParentRecyclerViewHolder(view, mParentDelegate)
    }

    override fun onBindViewHolder(holder: ParentRecyclerViewHolder, position: Int) {

        //Setup Child Recycler view
        mChildRecyclerAdapter = ChildRecyclerAdapter(mChildDelegate)
        val childLayoutManager = LinearLayoutManager(
            holder.mChileRecyclerView.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        holder.mChileRecyclerView.apply {
            layoutManager = childLayoutManager
            adapter = mChildRecyclerAdapter
        }

        mListBookCategory?.let { listBookCategory ->
            holder.bindData(listBookCategory[position])
        }
        mChildRecyclerAdapter.setNewData(mListBookCategory?.get(position)?.books)
    }

    override fun getItemCount(): Int {
        return mListBookCategory?.size ?: 0
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(listBookCategory: List<ListBookCategoryVO>?) {
        mListBookCategory = listBookCategory
        notifyDataSetChanged()
    }
}