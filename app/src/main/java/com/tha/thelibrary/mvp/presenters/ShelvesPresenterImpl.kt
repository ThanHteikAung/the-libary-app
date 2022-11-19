package com.tha.thelibrary.mvp.presenters

import androidx.lifecycle.ViewModel
import com.tha.thelibrary.mvp.views.ShelvesView

class ShelvesPresenterImpl :ViewModel(), ShelvesPresenter {
    private lateinit var mView: ShelvesView
    override fun initView(view: ShelvesView) {
        mView = view
    }

    override fun onTapCreateShelves() {
        mView.onShowCreateShelves()
    }

}