package com.tha.thelibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.tha.thelibrary.R
import com.tha.thelibrary.data.vos.BookVO
import com.tha.thelibrary.mvp.presenters.YourBooksPresenter
import com.tha.thelibrary.mvp.presenters.YourBooksPresenterImpl
import com.tha.thelibrary.mvp.views.YourBooksView
import com.tha.thelibrary.view.viewpods.CustomLayoutViewPod
import kotlinx.android.synthetic.main.fragment_your_books.*

class YourBooksFragment : BaseFragment(), YourBooksView {

    private lateinit var mPresenter: YourBooksPresenter
    private lateinit var mCustomLayoutViewPod: CustomLayoutViewPod
    private lateinit var mViewAsFragment: ViewAsFragment
    private lateinit var mSortByFragment: SortByFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_your_books, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpCustomViewPod()

        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[YourBooksPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    //setup CustomViewPod Gp
    private fun setUpCustomViewPod() {
        mCustomLayoutViewPod = includeCustomYourBooks as CustomLayoutViewPod
        mCustomLayoutViewPod.setUpDelegate(mPresenter)
    }


    override fun showCarouselOptionMenu(book: BookVO?) {
        context?.let {
            if (book != null) {
                showBottomSheet(it, R.layout.carousel_menu_book_sheet, book)
            }
        }
    }

    override fun showViewAsRadioOptionMenu() {
        mViewAsFragment = ViewAsFragment()
        mViewAsFragment.show(childFragmentManager, null)
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

    override fun showListOptionMenu(book: BookVO?) {
        context?.let {
            if (book != null) {
                showBottomSheet(it, R.layout.carousel_menu_book_sheet, book)
            }
        }
    }

    override fun showSortByRadioOptionMenu() {
        mSortByFragment = SortByFragment()
        mSortByFragment.show(childFragmentManager, null)
    }

    override fun showYourBooksOrYourShelves(bookList: List<BookVO>) {
        mCustomLayoutViewPod.setUpNewData(bookList)
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
    }

}