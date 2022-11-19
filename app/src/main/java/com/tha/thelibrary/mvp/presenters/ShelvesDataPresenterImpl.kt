package com.tha.thelibrary.mvp.presenters

import androidx.lifecycle.ViewModel
import com.tha.thelibrary.mvp.views.ShelvesDataView

class ShelvesDataPresenterImpl : ViewModel(), ShelvesDataPresenter {
    private lateinit var mView: ShelvesDataView
    override fun initView(view: ShelvesDataView) {
        mView = view
    }

    override fun onTapShelvesList() {
        mView.showShelvesList()
    }

    override fun onTapShelvesDetailList() {
        mView.showShelvesDetailList()
    }
}