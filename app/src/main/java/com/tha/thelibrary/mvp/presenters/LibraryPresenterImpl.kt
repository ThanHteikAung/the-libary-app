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

    override fun onTapViewAs() {
        mView.showRadioOptionMenu()
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