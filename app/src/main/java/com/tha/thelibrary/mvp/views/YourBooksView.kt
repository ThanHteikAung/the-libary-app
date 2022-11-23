package com.tha.thelibrary.mvp.views

import com.tha.thelibrary.data.vos.BookVO

interface YourBooksView : BaseView {

    fun showCarouselOptionMenu()
    fun showViewAsRadioOptionMenu()
    fun showList()
    fun showSmallGrid()
    fun showLargeGrid()
    fun showListOptionMenu()
    fun showSortByRadioOptionMenu()
    fun showYourBooksOrYourShelves(bookList: List<BookVO>)
}