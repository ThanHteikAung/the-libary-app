package com.tha.thelibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tha.thelibrary.R
import com.tha.thelibrary.activities.TestingViewAsActivity
import com.tha.thelibrary.adapters.ChildRecyclerAdapter
import com.tha.thelibrary.adapters.ChipAdapter
import com.tha.thelibrary.delegates.ChildRecyclerDelegate
import kotlinx.android.synthetic.main.fragment_library.*

class LibraryFragment : BaseFragment(), ChildRecyclerDelegate {

    private lateinit var mChipAdapter: ChipAdapter
    private lateinit var mLibraryYourBooksAdapter: ChildRecyclerAdapter

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
        setUpLibraryYourBooksRecycler()
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
    private fun setUpLibraryYourBooksRecycler() {
        mLibraryYourBooksAdapter = ChildRecyclerAdapter(this)
        rvLibraryYourBook.adapter = mLibraryYourBooksAdapter
        rvLibraryYourBook.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
    }

    override fun onTapOptionMenu() {
        context?.let { showBottomSheet(it, R.layout.carousel_menu_book_sheet) }
    }

    private fun setUpButtonViewAs() {
        btnViewAs.setOnClickListener {
            setUpViewAs()
        }
    }

    private fun setUpViewAs() {
        startActivity(context?.let { TestingViewAsActivity.newIntent(it) })
    }

}