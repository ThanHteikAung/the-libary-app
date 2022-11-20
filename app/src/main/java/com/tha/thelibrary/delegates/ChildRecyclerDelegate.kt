package com.tha.thelibrary.delegates

import com.tha.thelibrary.data.vos.BooksVO

interface ChildRecyclerDelegate {

    fun onTapOptionMenu()
    fun onTapItemFromEbooks(booksVO: BooksVO)
}