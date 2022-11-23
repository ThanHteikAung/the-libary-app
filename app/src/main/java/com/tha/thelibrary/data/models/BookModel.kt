package com.tha.thelibrary.data.models

import androidx.lifecycle.LiveData
import com.tha.thelibrary.data.vos.BookVO
import com.tha.thelibrary.data.vos.ListBookCategoryVO

interface BookModel {
    fun getOverview(
        onFailure: (String) -> Unit
    ): LiveData<List<ListBookCategoryVO>>?

    fun insertReadBook(book: BookVO?)

    fun getSaveReadBook(
        onFailure: (String) -> Unit
    ): LiveData<List<BookVO>>?

}