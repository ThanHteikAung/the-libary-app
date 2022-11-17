package com.tha.thelibrary.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.tha.thelibrary.R
import com.tha.thelibrary.adapters.ChildRecyclerAdapter
import com.tha.thelibrary.mvp.presenters.BooksTypePresenter
import com.tha.thelibrary.mvp.presenters.BooksTypePresenterImpl
import com.tha.thelibrary.mvp.views.BooksTypeView
import kotlinx.android.synthetic.main.activity_books_type.*

class BooksTypeActivity : BaseActivity(),BooksTypeView {

    private lateinit var mChildRecyclerAdapter: ChildRecyclerAdapter
    private lateinit var mPresenter: BooksTypePresenter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, BooksTypeActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_type)
        setUpPresenter()
        setUpBooksTypeRecycler()
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProvider(this)[BooksTypePresenterImpl::class.java]
        mPresenter.initView(this)
    }

    //setup BooksType Recycler View
    private fun setUpBooksTypeRecycler() {
        mChildRecyclerAdapter = ChildRecyclerAdapter(mPresenter)
        rvBooksType.adapter = mChildRecyclerAdapter
        rvBooksType.layoutManager = GridLayoutManager(parent, 2, GridLayoutManager.VERTICAL, false)
    }

    override fun showOptionMenu() {
        showBottomSheet(this, R.layout.option_menu_book_sheet)
    }

}