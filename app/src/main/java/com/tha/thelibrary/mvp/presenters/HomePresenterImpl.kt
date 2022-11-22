package com.tha.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.tha.thelibrary.data.vos.BooksVO
import com.tha.thelibrary.mvp.views.HomeView

class HomePresenterImpl : ViewModel(), HomePresenter {

    private lateinit var mView: HomeView

    override fun initView(view: HomeView) {
        mView = view
    }

    override fun onTapParentRecyclerHeader() {
        mView.showEbooksCategory()
    }

    override fun onTapOptionMenu() {
        mView.showEbooksOptionMenu()
    }

    override fun onTapCarouselOptionMenu() {
        mView.showCarouselOptionMenu()
    }
}