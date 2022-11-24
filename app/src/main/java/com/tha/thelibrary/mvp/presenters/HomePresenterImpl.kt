package com.tha.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.tha.thelibrary.data.models.BookModel
import com.tha.thelibrary.data.models.BookModelImpl
import com.tha.thelibrary.data.vos.BookVO
import com.tha.thelibrary.mvp.views.HomeView

class HomePresenterImpl : ViewModel(), HomePresenter {

    private lateinit var mView: HomeView
    private val mBookModel : BookModel = BookModelImpl

    override fun initView(view: HomeView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {

        //get Ebooks data from persistence
        mBookModel.getOverview {
            mView?.showError(it)
        }?.observe(owner){
            mView?.showHomeEbooks(it)
        }

        //get Carousel already read data from persistence
        mBookModel.getSaveReadBook {
            mView?.showError(it)
        }?.observe(owner){
            mView?.showHomeCarousel(it)
        }

    }

    override fun onTapParentRecyclerHeader() {
        mView.showEbooksCategory()
    }

    override fun onTapOptionMenu(book: BookVO?) {
        mView.showEbooksOptionMenu(book)
    }

    override fun onTapImage(book: BookVO?) {
        mBookModel.insertReadBook(book)
    }

    override fun onTapCarouselOptionMenu(book: BookVO?) {
        mView.showCarouselOptionMenu(book)
    }
}