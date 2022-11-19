package com.tha.thelibrary.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tha.thelibrary.R
import com.tha.thelibrary.view.viewholders.ShelvesListItemViewHolder

class ShelvesListItemAdapter : RecyclerView.Adapter<ShelvesListItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShelvesListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_your_shelves_item, parent, false)
        return ShelvesListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShelvesListItemViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 7
    }
}