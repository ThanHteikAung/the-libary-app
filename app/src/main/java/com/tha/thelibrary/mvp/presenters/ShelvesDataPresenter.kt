package com.tha.thelibrary.mvp.presenters

import com.tha.thelibrary.delegates.ShelvesListItemDelegate
import com.tha.thelibrary.mvp.views.ShelvesDataView

interface ShelvesDataPresenter: ShelvesListItemDelegate {
    fun initView(view: ShelvesDataView)
    fun onTapShelvesList()
}