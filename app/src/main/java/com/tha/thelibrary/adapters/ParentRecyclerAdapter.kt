package com.tha.thelibrary.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tha.thelibrary.R
import com.tha.thelibrary.delegates.ChildRecyclerDelegate
import com.tha.thelibrary.delegates.ParentRecyclerDelegate
import com.tha.thelibrary.view.viewholders.ParentRecyclerViewHolder

class ParentRecyclerAdapter(
    private val mParentDelegate: ParentRecyclerDelegate,
    private val mChildDelegate: ChildRecyclerDelegate
) : RecyclerView.Adapter<ParentRecyclerViewHolder>() {
    private lateinit var mChildRecyclerAdapter: ChildRecyclerAdapter

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
    }

    override fun getItemCount(): Int {
        return 5
    }
}