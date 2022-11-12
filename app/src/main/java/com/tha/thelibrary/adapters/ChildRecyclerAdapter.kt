package com.tha.thelibrary.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tha.thelibrary.view.viewholders.ChildRecyclerViewHolder
import com.tha.thelibrary.R

class ChildRecyclerAdapter : RecyclerView.Adapter<ChildRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_child_item,parent,false)
        return ChildRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChildRecyclerViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 7
    }
}