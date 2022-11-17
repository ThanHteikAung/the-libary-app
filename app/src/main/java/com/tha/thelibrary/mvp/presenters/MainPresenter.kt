package com.tha.thelibrary.mvp.presenters

import androidx.fragment.app.Fragment
import com.tha.thelibrary.mvp.views.MainView

interface MainPresenter {
    fun initView(view : MainView)
    fun onTapBottomNavigation(fragment: Fragment)
}