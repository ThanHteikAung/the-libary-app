package com.tha.thelibrary.mvp.presenters

import androidx.lifecycle.ViewModel
import com.tha.thelibrary.mvp.views.CreateShelvesView

class CreateShelvesPresenterImpl : ViewModel(), CreateShelvesPresenter {
    private lateinit var mView: CreateShelvesView
    override fun initView(view: CreateShelvesView) {
        mView = view
    }

    override fun onTapBack() {
        mView.showShelvesDataList()
    }
}