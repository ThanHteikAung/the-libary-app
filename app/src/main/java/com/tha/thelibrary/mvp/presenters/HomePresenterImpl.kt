package com.tha.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.tha.thelibrary.data.models.BooksModel
import com.tha.thelibrary.data.models.BooksModelImpl
import com.tha.thelibrary.data.vos.BooksVO
import com.tha.thelibrary.mvp.views.HomeView

class HomePresenterImpl : ViewModel(), HomePresenter {

    private lateinit var mView: HomeView
    private val mBooksModel : BooksModel = BooksModelImpl

    override fun initView(view: HomeView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {
        //Overview
        mBooksModel.getOverview ({
            if (it != null) {
                mView. bindData(it)
            }
        },{
            //Fail error message
        })

        mBooksModel.getSaveBook()?.observe(owner){
            println("HElllooooooooooooooooooooooooooooooo $it")
            if(it!= null){
                mView.showSaveBooksList(it)
            }
        }

    }

    override fun onTapParentRecyclerHeader() {
        mView.showEbooksCategory()
    }

    override fun onTapOptionMenu() {
        mView.showEbooksOptionMenu()
    }

    override fun onTapItemFromEbooks(booksVO: BooksVO) {
        mBooksModel.insertSingleBook(booksVO)
        mBooksModel.getSaveBook()
    }

    override fun onTapCarouselOptionMenu() {
        mView.showCarouselOptionMenu()
    }
}