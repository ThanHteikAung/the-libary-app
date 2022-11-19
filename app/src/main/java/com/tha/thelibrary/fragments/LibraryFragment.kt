package com.tha.thelibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.tha.thelibrary.R
import kotlinx.android.synthetic.main.fragment_library.*

class LibraryFragment : Fragment() {

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
        setUpListeners()
        swiftFragment(YourBooksFragment())
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

    private fun setUpListeners() {
        tbLibraryGeneric.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        swiftFragment(YourBooksFragment())
                    }
                    1 -> {
                        swiftFragment(YourShelvesFragment())
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

    private fun swiftFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.libraryFrameLayout,fragment)
            .commit()
    }

}