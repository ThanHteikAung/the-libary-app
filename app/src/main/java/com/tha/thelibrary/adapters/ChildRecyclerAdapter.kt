package com.tha.thelibrary.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.recyclerview.widget.RecyclerView
import com.tha.thelibrary.R
import com.tha.thelibrary.delegates.ChildRecyclerDelegate
import com.tha.thelibrary.view.viewholders.ChildRecyclerViewHolder

class ChildRecyclerAdapter(private val mDelegate: ChildRecyclerDelegate) :
    RecyclerView.Adapter<ChildRecyclerViewHolder>() {
    companion object {
        const val ACTIVITY_NAME = "BOOKSTYPEACTIVITY"
    }

    private lateinit var mActivityName: String
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_child_item, parent, false)
        mActivityName = parent.context.toString()     //getActivityName
        return ChildRecyclerViewHolder(view, mDelegate)
    }

    override fun onBindViewHolder(holder: ChildRecyclerViewHolder, position: Int) {

        //check Activity Name
        if (mActivityName.contains(ACTIVITY_NAME, ignoreCase = true)) {
            holder.mChildLayout.layoutParams.width = TableLayout.LayoutParams.MATCH_PARENT
            holder.mImageView.layoutParams.height = 800
            holder.mImageView.layoutParams.width = TableLayout.LayoutParams.MATCH_PARENT
        }

    }

    override fun getItemCount(): Int {
        return 7
    }
}