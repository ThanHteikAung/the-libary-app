package com.tha.thelibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.tha.thelibrary.R
import com.tha.thelibrary.adapters.ChildRecyclerAdapter
import com.tha.thelibrary.adapters.ChipAdapter
import com.tha.thelibrary.adapters.ListAdapter
import com.tha.thelibrary.mvp.presenters.LibraryPresenter
import com.tha.thelibrary.mvp.presenters.LibraryPresenterImpl
import com.tha.thelibrary.mvp.views.LibraryView
import com.tha.thelibrary.view.viewpods.CustomLayoutViewPod
import kotlinx.android.synthetic.main.fragment_library.*

class LibraryFragment : BaseFragment(), LibraryView {

    private lateinit var mChipAdapter: ChipAdapter
    private lateinit var mLibraryYourBooksAdapter: ChildRecyclerAdapter
    private lateinit var mViewAsFragment: ViewAsFragment
    private lateinit var mListAdapter: ListAdapter

    private lateinit var mPresenter: LibraryPresenter
    private lateinit var mCustomLayoutViewPod: CustomLayoutViewPod

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpLibraryTabLayout()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[LibraryPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    //setup Library TabLayout
    private fun setUpLibraryTabLayout() {
        val tabDataList = listOf("Your books", "Your shelves")
        tabDataList.forEach {
            tbLibraryGeneric.newTab().apply {
                text = it
                tbLibraryGeneric.addTab(this)
            }
        }
    }

    override fun showCarouselOptionMenu() {
        context?.let { showBottomSheet(it, R.layout.carousel_menu_book_sheet) }
    }

    /*override fun showViewByList() {
        rvLibraryList.visibility = View.VISIBLE
        rvLibrary2Grid.visibility = View.GONE
        rvLibrary3Grid.visibility = View.GONE
    }

    override fun showViewBySmallGrid() {
        rvLibraryList.visibility = View.GONE
        rvLibrary2Grid.visibility = View.GONE
        rvLibrary3Grid.visibility = View.VISIBLE
    }

    override fun showViewByLargeGrid() {
        rvLibraryList.visibility = View.GONE
        rvLibrary3Grid.visibility = View.GONE
        rvLibrary2Grid.visibility = View.VISIBLE
    }*/

    override fun showCustomLayoutGroup() {
        mCustomLayoutViewPod.setUpDelegate(mPresenter)
    }

}