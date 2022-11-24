package com.tha.thelibrary.delegates

import com.tha.thelibrary.data.vos.BookVO

interface CarouselDelegate {

    fun onTapCarouselOptionMenu(book: BookVO?)
}