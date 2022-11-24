package com.tha.thelibrary.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tha.thelibrary.data.vos.BookVO
import com.tha.thelibrary.delegates.CarouselDelegate
import kotlinx.android.synthetic.main.view_holder_carousel.view.*

class CarouselViewHolder(itemView: View, private val mDelegate: CarouselDelegate) :
    RecyclerView.ViewHolder(itemView) {

    private var mBook: BookVO? = null

    /*val carouselLayout : RelativeLayout = itemView.rlCarouselLayout*/
    /*val carouselImage : ShapeableImageView = itemView.ivCarouselImage
    val carouselOptionMenu : AppCompatImageView = itemView.ivCarouselOptionMenu
    val carouselHeadphone : AppCompatImageView = itemView.ivCarouselHeadphone
    val carouselDownload : AppCompatImageView = itemView.ivCarouselDownLoad*/

    init {
        itemView.ivCarouselOptionMenu.setOnClickListener {
            mDelegate.onTapCarouselOptionMenu(mBook)
        }
    }

    fun onBindData(book: BookVO?) {
        mBook = book
        Glide.with(itemView.context)
            .load(book?.bookImage)
            .into(itemView.ivCarouselImage)
    }
}