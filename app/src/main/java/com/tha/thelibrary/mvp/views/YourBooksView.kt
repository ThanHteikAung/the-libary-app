package com.tha.thelibrary.mvp.views

import com.tha.thelibrary.data.vos.BooksVO
import com.tha.thelibrary.data.vos.ListVO

interface YourBooksView {

    fun showCarouselOptionMenu()
    fun showViewAsRadioOptionMenu()
    fun showList()
    fun showSmallGrid()
    fun showLargeGrid()
    fun showListOptionMenu()
    fun showSortByRadioOptionMenu()
}