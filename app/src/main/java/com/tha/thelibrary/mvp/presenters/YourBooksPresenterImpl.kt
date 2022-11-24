package com.tha.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.tha.thelibrary.data.models.BookModel
import com.tha.thelibrary.data.models.BookModelImpl
import com.tha.thelibrary.data.vos.BookVO
import com.tha.thelibrary.mvp.views.YourBooksView

class YourBooksPresenterImpl : ViewModel(), YourBooksPresenter {

    private lateinit var mView: YourBooksView
    private var mBookModel: BookModel = BookModelImpl

    override fun initView(view: YourBooksView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mBookModel.getSaveReadBook {
            mView?.showError(it)
        }?.observe(owner, Observer {
            mView?.showYourBooksOrYourShelves(it)
        })
    }

    override fun onTapOptionMenu(book: BookVO?) {
        mView.showListOptionMenu(book)
    }

    override fun onTapImage(book: BookVO?) {

    }

    override fun onTapListOptionMenu(book: BookVO?) {
        mView.showCarouselOptionMenu(book)
    }

    override fun onTapViewAs() {
        mView.showViewAsRadioOptionMenu()
    }

    override fun onTapSortBy() {
        mView.showSortByRadioOptionMenu()
    }

    override fun onTapList() {
        mView.showList()
    }

    override fun onTapSmallGrid() {
        mView.showSmallGrid()
    }

    override fun onTapLargeGrid() {
        mView.showLargeGrid()
    }
}