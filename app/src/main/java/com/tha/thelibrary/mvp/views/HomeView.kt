package com.tha.thelibrary.mvp.views

import com.tha.thelibrary.data.vos.BookVO
import com.tha.thelibrary.data.vos.ListBookCategoryVO

interface HomeView : BaseView {
    fun showCarouselOptionMenu()
    fun showEbooksCategory()
    fun showEbooksOptionMenu()
    fun showHomeEbooks(listBookCategory: List<ListBookCategoryVO>)
    fun showHomeCarousel(listReadBook: List<BookVO>)
}