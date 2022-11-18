package com.tha.thelibrary.mvp.presenters

import androidx.lifecycle.ViewModel
import com.tha.thelibrary.mvp.views.LibraryView

class LibraryPresenterImpl: ViewModel(), LibraryPresenter {

    private lateinit var mView: LibraryView

    override fun initView(view: LibraryView) {
        mView = view
    }

    override fun onTapOptionMenu() {
        mView.showCarouselOptionMenu()
    }

    /*override fun onTapList() {
        mView.showViewByList()
    }

    override fun onTapSmallGrid() {
        mView.showViewBySmallGrid()
    }

    override fun onTapLargeGrid() {
        mView.showViewByLargeGrid()
    }*/

    override fun onTapViewAs() {
        mView.showCustomLayoutGroup()
    }
}