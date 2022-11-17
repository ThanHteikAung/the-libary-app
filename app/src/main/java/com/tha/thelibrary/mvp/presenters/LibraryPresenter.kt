package com.tha.thelibrary.mvp.presenters

import com.tha.thelibrary.delegates.ChildRecyclerDelegate
import com.tha.thelibrary.delegates.ViewAsDelegate
import com.tha.thelibrary.mvp.views.LibraryView

interface LibraryPresenter : ChildRecyclerDelegate, ViewAsDelegate {
    fun initView(view: LibraryView)
}