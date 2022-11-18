package com.tha.thelibrary.mvp.presenters

import com.tha.thelibrary.delegates.ChildRecyclerDelegate
import com.tha.thelibrary.delegates.CustomLayoutDelegate
import com.tha.thelibrary.mvp.views.LibraryView

interface LibraryPresenter : ChildRecyclerDelegate, CustomLayoutDelegate {
    fun initView(view: LibraryView)
}