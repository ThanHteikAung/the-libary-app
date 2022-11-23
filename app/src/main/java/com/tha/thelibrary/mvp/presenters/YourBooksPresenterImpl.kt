package com.tha.thelibrary.mvp.presenters

import androidx.lifecycle.ViewModel
import com.tha.thelibrary.data.vos.BookVO
import com.tha.thelibrary.mvp.views.YourBooksView

class YourBooksPresenterImpl : ViewModel(), YourBooksPresenter {

    private lateinit var mView: YourBooksView

    override fun initView(view: YourBooksView) {
        mView = view
    }

    override fun onTapOptionMenu() {
        mView.showListOptionMenu()
    }

    override fun onTapImage(book: BookVO?) {

    }

    override fun onTapListOptionMenu() {
        mView.showCarouselOptionMenu()
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