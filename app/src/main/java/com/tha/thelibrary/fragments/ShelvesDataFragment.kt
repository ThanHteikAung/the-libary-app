package com.tha.thelibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tha.thelibrary.R
import com.tha.thelibrary.activities.YourShelvesDetailListActivity
import com.tha.thelibrary.adapters.ShelvesListItemAdapter
import com.tha.thelibrary.mvp.presenters.ShelvesDataPresenter
import com.tha.thelibrary.mvp.presenters.ShelvesDataPresenterImpl
import com.tha.thelibrary.mvp.views.ShelvesDataView
import kotlinx.android.synthetic.main.fragment_shelves_data.*

class ShelvesDataFragment : Fragment(), ShelvesDataView {

    private lateinit var mShelvesListItemAdapter: ShelvesListItemAdapter
    private lateinit var mPresenter: ShelvesDataPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shelves_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpShelvesRecycler()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[ShelvesDataPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpShelvesRecycler() {
        mShelvesListItemAdapter = ShelvesListItemAdapter(mPresenter)
        rvYourShelves.adapter = mShelvesListItemAdapter
        rvYourShelves.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun showShelvesList() {
        mPresenter.onTapShelvesList()
    }

    override fun showShelvesDetailList() {
        startActivity(context?.let { YourShelvesDetailListActivity.newIntent(it) })
    }

}