package com.tha.thelibrary.data.models

import androidx.lifecycle.LiveData
import com.tha.thelibrary.data.vos.BooksVO
import com.tha.thelibrary.data.vos.ListVO

interface BooksModel {
    fun getOverview(
        onSuccess: (List<ListVO>?) -> Unit,
        onFailure: (String) -> Unit
    )

    fun insertSingleBook(booksVO: BooksVO)
    fun getSaveBook(): LiveData<List<BooksVO>>?
}