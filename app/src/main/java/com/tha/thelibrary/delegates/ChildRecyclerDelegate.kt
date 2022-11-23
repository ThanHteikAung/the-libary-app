package com.tha.thelibrary.delegates

import com.tha.thelibrary.data.vos.BookVO

interface ChildRecyclerDelegate {

    fun onTapOptionMenu()
    fun onTapImage(book: BookVO?)
}