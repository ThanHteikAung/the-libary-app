package com.tha.thelibrary.mvp.presenters

import androidx.lifecycle.ViewModel
import com.tha.thelibrary.data.vos.BookVO
import com.tha.thelibrary.mvp.views.BooksTypeView

class BooksTypePresenterImpl : ViewModel(), BooksTypePresenter {
    private lateinit var mView: BooksTypeView
    override fun initView(view: BooksTypeView) {
        mView = view
    }

    override fun onTapOptionMenu(book: BookVO?) {
        mView.showOptionMenu()
    }

    override fun onTapImage(book: BookVO?) {

    }


}