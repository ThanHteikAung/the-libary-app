package com.tha.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.tha.thelibrary.data.models.BookModel
import com.tha.thelibrary.data.models.BookModelImpl
import com.tha.thelibrary.mvp.views.HomeView

class HomePresenterImpl : ViewModel(), HomePresenter {

    private lateinit var mView: HomeView
    private val mBookModel : BookModel = BookModelImpl

    override fun initView(view: HomeView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mBookModel.getOverview {
            mView?.showError(it)
        }?.observe(owner){
            mView?.showHomeEbooks(it)
        }
    }

    override fun onTapParentRecyclerHeader() {
        mView.showEbooksCategory()
    }

    override fun onTapOptionMenu() {
        mView.showEbooksOptionMenu()
    }

    override fun onTapCarouselOptionMenu() {
        mView.showCarouselOptionMenu()
    }
}