package com.tha.thelibrary.mvp.presenters

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.tha.thelibrary.mvp.views.MainView

class MainPresenterImpl: ViewModel(), MainPresenter {

    private lateinit var mView : MainView

    override fun initView(view: MainView) {
        mView = view
    }

    override fun onTapBottomNavigation(fragment: Fragment) {
        mView.showFragment(fragment)
    }
}