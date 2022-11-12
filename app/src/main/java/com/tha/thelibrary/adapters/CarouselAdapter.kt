package com.tha.thelibrary.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tha.thelibrary.R
import com.tha.thelibrary.view.viewholders.CarouselViewHolder

class CarouselAdapter : RecyclerView.Adapter<CarouselViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_carousel,parent,false)
        return CarouselViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }
}