package com.tha.thelibrary.view.viewholders

import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.tha.thelibrary.delegates.CarouselDelegate
import kotlinx.android.synthetic.main.view_holder_carousel.view.*

class CarouselViewHolder(itemView: View,private val mDelegate: CarouselDelegate) : RecyclerView.ViewHolder(itemView ){
    val carouselLayout : RelativeLayout = itemView.rlCarouselLayout
    /*val carouselImage : ShapeableImageView = itemView.ivCarouselImage
    val carouselOptionMenu : AppCompatImageView = itemView.ivCarouselOptionMenu
    val carouselHeadphone : AppCompatImageView = itemView.ivCarouselHeadphone
    val carouselDownload : AppCompatImageView = itemView.ivCarouselDownLoad*/

    init {
        itemView.ivCarouselOptionMenu.setOnClickListener {
            mDelegate.onTapCarouselOptionMenu()
        }
    }
}