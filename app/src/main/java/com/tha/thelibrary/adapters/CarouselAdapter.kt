package com.tha.thelibrary.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tha.thelibrary.R
import com.tha.thelibrary.data.vos.BookVO
import com.tha.thelibrary.delegates.CarouselDelegate
import com.tha.thelibrary.view.viewholders.CarouselViewHolder

class CarouselAdapter(private val mDelegate: CarouselDelegate) :
    RecyclerView.Adapter<CarouselViewHolder>() {

    private var mBookList: List<BookVO>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_carousel, parent, false)
        return CarouselViewHolder(view, mDelegate)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        /*if (mBookList?.isNotEmpty() == true) {
            holder.onBindData(mBookList!![position])
        }*/
        //testing
        /*if (position % 2 == 0) {
            holder.carouselLayout.setPadding(100, 0, 100, 0)
            *//*holder.carouselImage.setPadding(100,0,100,0)
            holder.carouselOptionMenu.setPadding(0,0,100,0)
            holder.carouselHeadphone.setPadding(200,0,0,0)
            holder.carouselDownload.setPadding(0,0,200,0)*//*
        }*/
    }

    override fun getItemCount(): Int {
        return 5
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(bookList: List<BookVO>?) {
        mBookList = bookList
        notifyDataSetChanged()
    }
}