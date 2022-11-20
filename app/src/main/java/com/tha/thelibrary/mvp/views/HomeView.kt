package com.tha.thelibrary.mvp.views

import com.tha.thelibrary.data.vos.BooksVO
import com.tha.thelibrary.data.vos.ListVO

interface HomeView {
    fun bindData(list: List<ListVO>)
    fun showCarouselOptionMenu()
    fun showEbooksCategory()
    fun showEbooksOptionMenu()
    fun showSaveBooksList(bookList: List<BooksVO>)
}