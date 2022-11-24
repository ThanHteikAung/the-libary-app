package com.tha.thelibrary.delegates

import com.tha.thelibrary.data.vos.BookVO

interface ListDelegate {
    fun onTapListOptionMenu(book: BookVO?)
}