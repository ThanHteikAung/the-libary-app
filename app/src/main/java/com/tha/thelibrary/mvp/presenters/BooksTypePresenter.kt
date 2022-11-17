package com.tha.thelibrary.mvp.presenters

import com.tha.thelibrary.delegates.ChildRecyclerDelegate
import com.tha.thelibrary.mvp.views.BooksTypeView

interface BooksTypePresenter : ChildRecyclerDelegate {
    fun initView(view: BooksTypeView)
}