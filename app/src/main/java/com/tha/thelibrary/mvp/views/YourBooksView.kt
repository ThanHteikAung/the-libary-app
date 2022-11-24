package com.tha.thelibrary.mvp.views

import com.tha.thelibrary.data.vos.BookVO

interface YourBooksView : BaseView {

    fun showCarouselOptionMenu(book: BookVO?)
    fun showViewAsRadioOptionMenu()
    fun showList()
    fun showSmallGrid()
    fun showLargeGrid()
    fun showListOptionMenu(book: BookVO?)
    fun showSortByRadioOptionMenu()
    fun showYourBooksOrYourShelves(bookList: List<BookVO>)
}