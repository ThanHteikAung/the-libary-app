package com.tha.thelibrary.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tha.thelibrary.R
import com.tha.thelibrary.view.viewholders.ParentRecyclerViewHolder

class ParentRecyclerAdapter : RecyclerView.Adapter<ParentRecyclerViewHolder>() {
    private lateinit var mChildRecyclerAdapter: ChildRecyclerAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_parent_item, parent, false)
        return ParentRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParentRecyclerViewHolder, position: Int) {

        //Setup Child Recycler view
        mChildRecyclerAdapter = ChildRecyclerAdapter()
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