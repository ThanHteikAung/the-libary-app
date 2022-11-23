package com.tha.thelibrary.mvp.presenters

import com.tha.thelibrary.delegates.ChildRecyclerDelegate
import com.tha.thelibrary.delegates.ListDelegate
import com.tha.thelibrary.delegates.ViewAsDelegate
import com.tha.thelibrary.mvp.views.YourBooksView
import com.tha.thelibrary.view.viewpods.CustomLayoutViewPod

interface YourBooksPresenter :IBasePresenter, ChildRecyclerDelegate, CustomLayoutViewPod.Delegate, ViewAsDelegate,
    ListDelegate {
    fun initView(view: YourBooksView)
}