package com.tha.thelibrary.mvp.presenters

import com.tha.thelibrary.delegates.ChildRecyclerDelegate
import com.tha.thelibrary.delegates.ViewAsDelegate
import com.tha.thelibrary.mvp.views.LibraryView
import com.tha.thelibrary.view.viewpods.CustomLayoutViewPod

interface LibraryPresenter : ChildRecyclerDelegate,CustomLayoutViewPod.Delegate,ViewAsDelegate{
    fun initView(view: LibraryView)
}