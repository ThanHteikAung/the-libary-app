package com.tha.thelibrary.delegates

import com.tha.thelibrary.data.vos.BookVO

interface ChildRecyclerDelegate {

    fun onTapOptionMenu(book: BookVO?)
    fun onTapImage(book: BookVO?)
}