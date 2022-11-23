package com.tha.thelibrary.mvp.presenters

import com.tha.thelibrary.delegates.CarouselDelegate
import com.tha.thelibrary.delegates.ChildRecyclerDelegate
import com.tha.thelibrary.delegates.ParentRecyclerDelegate
import com.tha.thelibrary.mvp.views.HomeView

interface HomePresenter :IBasePresenter, ParentRecyclerDelegate, ChildRecyclerDelegate,
    CarouselDelegate {
    fun initView(view: HomeView)
}