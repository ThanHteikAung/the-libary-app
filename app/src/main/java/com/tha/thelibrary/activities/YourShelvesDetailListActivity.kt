package com.tha.thelibrary.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.tha.thelibrary.R
import com.tha.thelibrary.fragments.SortByFragment
import com.tha.thelibrary.fragments.ViewAsFragment
import com.tha.thelibrary.mvp.presenters.YourBooksPresenter
import com.tha.thelibrary.mvp.presenters.YourBooksPresenterImpl
import com.tha.thelibrary.mvp.views.YourBooksView
import com.tha.thelibrary.view.viewpods.CustomLayoutViewPod
import kotlinx.android.synthetic.main.activity_your_shelves_detail_list.*

class YourShelvesDetailListActivity : BaseActivity(), YourBooksView {

    private lateinit var mCustomLayoutViewPod: CustomLayoutViewPod
    private lateinit var mViewAsFragment: ViewAsFragment
    private lateinit var mPresenter: YourBooksPresenter
    private lateinit var mSortByFragment: SortByFragment

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, YourShelvesDetailListActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_shelves_detail_list)
        setUpPresenter()
        setUpCustomViewPod()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[YourBooksPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpCustomViewPod() {
        mCustomLayoutViewPod = includeCustomYourShelves as CustomLayoutViewPod
        mCustomLayoutViewPod.setUpDelegate(mPresenter)
    }

    override fun showCarouselOptionMenu() {
        showBottomSheet(this, R.layout.carousel_menu_book_sheet)
    }

    override fun showViewAsRadioOptionMenu() {
        mViewAsFragment = ViewAsFragment()
        mViewAsFragment.show(supportFragmentManager, null)
        mViewAsFragment.setUpDelegate(mPresenter)
    }

    override fun showList() {
        mCustomLayoutViewPod.onTapList()
    }

    override fun showSmallGrid() {
        mCustomLayoutViewPod.onTapSmallGrid()
    }

    override fun showLargeGrid() {
        mCustomLayoutViewPod.onTapLargeGrid()
    }

    override fun showListOptionMenu() {
        showBottomSheet(this, R.layout.carousel_menu_book_sheet)
    }

    override fun showSortByRadioOptionMenu() {
        mSortByFragment = SortByFragment()
        mSortByFragment.show(supportFragmentManager, null)
    }

}