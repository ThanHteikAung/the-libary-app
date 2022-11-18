package com.tha.thelibrary.view.viewpods

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tha.thelibrary.adapters.ChildRecyclerAdapter
import com.tha.thelibrary.adapters.ChipAdapter
import com.tha.thelibrary.adapters.ListAdapter
import com.tha.thelibrary.mvp.presenters.LibraryPresenter
import kotlinx.android.synthetic.main.view_pod_custom_layout.view.*

class CustomLayoutViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    private lateinit var mChipAdapter: ChipAdapter
    private lateinit var mLibraryYourBooksAdapter: ChildRecyclerAdapter
    private lateinit var mListAdapter: ListAdapter
    private lateinit var mLibraryPresenter: LibraryPresenter
    private var mDelegate: Delegate? = null


    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
        setUpChipRecyclerView()
    }

    fun setUpDelegate(delegate: LibraryPresenter) {
        mLibraryPresenter = delegate
        mDelegate = delegate
        setUpLibraryListGridRecycler()
        setUpLibrary2GridRecycler()
        setUpLibrary3GridRecycler()

    }

    //setup Chip Recycler View
    private fun setUpChipRecyclerView() {
        mChipAdapter = ChipAdapter()
        rvChip.adapter = mChipAdapter
        rvChip.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    //setup Library navigation's your books tab
    private fun setUpLibrary2GridRecycler() {
        mLibraryYourBooksAdapter = ChildRecyclerAdapter(mLibraryPresenter)
        rvLibrary2Grid.adapter = mLibraryYourBooksAdapter
        rvLibrary2Grid.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        rvLibrary2Grid.visibility = View.GONE
    }

    private fun setUpLibrary3GridRecycler() {
        mLibraryYourBooksAdapter = ChildRecyclerAdapter(mLibraryPresenter)
        rvLibrary3Grid.adapter = mLibraryYourBooksAdapter
        rvLibrary3Grid.layoutManager =
            GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        rvLibrary3Grid.visibility = View.GONE
    }

    private fun setUpLibraryListGridRecycler() {
        mListAdapter = ListAdapter(mLibraryPresenter)
        rvLibraryList.adapter = mListAdapter
        rvLibraryList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun setUpListener() {
        btnViewAs.setOnClickListener {
            mDelegate?.onTapViewAs()

        }
        btnSortBy.setOnClickListener {
            mDelegate?.onTapSortBy()
        }
    }

    interface Delegate {
        fun onTapViewAs()
        fun onTapSortBy()
    }

    fun onTapList() {
        rvLibraryList.visibility = View.VISIBLE
        rvLibrary2Grid.visibility = View.GONE
        rvLibrary3Grid.visibility = View.GONE
    }

    fun onTapSmallGrid() {
        rvLibraryList.visibility = View.GONE
        rvLibrary2Grid.visibility = View.GONE
        rvLibrary3Grid.visibility = View.VISIBLE
    }

    fun onTapLargeGrid() {
        rvLibraryList.visibility = View.GONE
        rvLibrary3Grid.visibility = View.GONE
        rvLibrary2Grid.visibility = View.VISIBLE
    }

}