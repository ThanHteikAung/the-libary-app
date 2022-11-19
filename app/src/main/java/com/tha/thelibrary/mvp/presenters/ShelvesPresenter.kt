package com.tha.thelibrary.mvp.presenters

import com.tha.thelibrary.mvp.views.ShelvesView

interface ShelvesPresenter {
    fun initView(view: ShelvesView)
    fun onTapCreateShelves()
}