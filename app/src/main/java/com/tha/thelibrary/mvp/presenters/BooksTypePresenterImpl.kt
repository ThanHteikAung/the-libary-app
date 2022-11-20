package com.tha.thelibrary.mvp.presenters

import androidx.lifecycle.ViewModel
import com.tha.thelibrary.data.vos.BooksVO
import com.tha.thelibrary.mvp.views.BooksTypeView

class BooksTypePresenterImpl : ViewModel(), BooksTypePresenter {
    private lateinit var mView: BooksTypeView
    override fun initView(view: BooksTypeView) {
        mView = view
    }

    override fun onTapOptionMenu() {
        mView.showOptionMenu()
    }

    override fun onTapItemFromEbooks(booksVO: BooksVO) {

    }


}