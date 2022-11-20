package com.tha.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.tha.thelibrary.data.models.BooksModel
import com.tha.thelibrary.data.models.BooksModelImpl
import com.tha.thelibrary.data.vos.BooksVO
import com.tha.thelibrary.mvp.views.YourBooksView

class YourBooksPresenterImpl : ViewModel(), YourBooksPresenter {

    private lateinit var mView: YourBooksView
    private val mBooksModel: BooksModel = BooksModelImpl

    override fun initView(view: YourBooksView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {

        mBooksModel.getSaveBook()?.observe(owner){
            println("HElllooooooooooooooooooooooooooooooo $it")
            if(it!= null){
                mView.bindData(it)
            }
        }
    }

    override fun onTapOptionMenu() {
        mView.showListOptionMenu()
    }

    override fun onTapItemFromEbooks(booksVO: BooksVO) {
        TODO("Not yet implemented")
    }

    override fun onTapListOptionMenu() {
        mView.showCarouselOptionMenu()
    }

    override fun onTapViewAs() {
        mView.showViewAsRadioOptionMenu()
    }

    override fun onTapSortBy() {
        mView.showSortByRadioOptionMenu()
    }

    override fun onTapList() {
        mView.showList()
    }

    override fun onTapSmallGrid() {
        mView.showSmallGrid()
    }

    override fun onTapLargeGrid() {
        mView.showLargeGrid()
    }
}