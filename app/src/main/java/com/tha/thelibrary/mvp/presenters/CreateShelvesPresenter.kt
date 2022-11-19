package com.tha.thelibrary.mvp.presenters

import com.tha.thelibrary.mvp.views.CreateShelvesView

interface CreateShelvesPresenter {
    fun initView(view: CreateShelvesView)
    fun onTapBack()
}