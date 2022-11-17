package com.tha.thelibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tha.thelibrary.R
import com.tha.thelibrary.adapters.ChildRecyclerAdapter
import com.tha.thelibrary.adapters.ChipAdapter
import com.tha.thelibrary.adapters.ListAdapter
import com.tha.thelibrary.delegates.ChildRecyclerDelegate
import com.tha.thelibrary.delegates.ViewAsDelegate
import kotlinx.android.synthetic.main.fragment_library.*

class LibraryFragment : BaseFragment(), ChildRecyclerDelegate, ViewAsDelegate {

    private lateinit var mChipAdapter: ChipAdapter
    private lateinit var mLibraryYourBooksAdapter: ChildRecyclerAdapter
    private lateinit var mViewAsFragment: ViewAsFragment
    private lateinit var mListAdapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpLibraryTabLayout()
        setUpChipRecyclerView()
        setUpLibraryListGridRecycler()
        setUpLibrary2GridRecycler()
        setUpLibrary3GridRecycler()
        setUpButtonViewAs()
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

    //setup Chip Recycler View
    private fun setUpChipRecyclerView() {
        mChipAdapter = ChipAdapter()
        rvChip.adapter = mChipAdapter
        rvChip.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    //setup Library navigation's your books tab
    private fun setUpLibrary2GridRecycler() {
        mLibraryYourBooksAdapter = ChildRecyclerAdapter(this)
        rvLibrary2Grid.adapter = mLibraryYourBooksAdapter
        rvLibrary2Grid.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        rvLibrary2Grid.visibility = View.GONE
    }

    private fun setUpLibrary3GridRecycler() {
        mLibraryYourBooksAdapter = ChildRecyclerAdapter(this)
        rvLibrary3Grid.adapter = mLibraryYourBooksAdapter
        rvLibrary3Grid.layoutManager =
            GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        rvLibrary3Grid.visibility = View.GONE
    }

    private fun setUpLibraryListGridRecycler() {
        mListAdapter = ListAdapter()
        rvLibraryList.adapter = mListAdapter
        rvLibraryList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }


    override fun onTapOptionMenu() {
        context?.let { showBottomSheet(it, R.layout.carousel_menu_book_sheet) }
    }

    private fun setUpButtonViewAs() {
        btnViewAs.setOnClickListener {
            mViewAsFragment = ViewAsFragment()
            mViewAsFragment.show(childFragmentManager, null)
            mViewAsFragment.setUpDelegate(this)
        }
    }

    override fun onTapList() {
        rvLibraryList.visibility = View.VISIBLE
        rvLibrary2Grid.visibility = View.GONE
        rvLibrary3Grid.visibility = View.GONE
    }

    override fun onTapSmallGrid() {
        rvLibraryList.visibility = View.GONE
        rvLibrary2Grid.visibility = View.GONE
        rvLibrary3Grid.visibility = View.VISIBLE
    }

    override fun onTapLargeGrid() {
        rvLibraryList.visibility = View.GONE
        rvLibrary3Grid.visibility = View.GONE
        rvLibrary2Grid.visibility = View.VISIBLE
    }

}