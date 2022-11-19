package com.tha.thelibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tha.thelibrary.R
import com.tha.thelibrary.activities.CreateShelvesActivity
import com.tha.thelibrary.mvp.presenters.ShelvesPresenter
import com.tha.thelibrary.mvp.presenters.ShelvesPresenterImpl
import com.tha.thelibrary.mvp.views.ShelvesView
import kotlinx.android.synthetic.main.fragment_your_shelves.*


class YourShelvesFragment : Fragment(), ShelvesView {

    private lateinit var mPresenter: ShelvesPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_your_shelves, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpListener()
        swiftFragment(NoDataShelvesFragment())
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[ShelvesPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpListener() {
        btnCreateShelves.setOnClickListener {
            mPresenter.onTapCreateShelves()
        }
    }

    override fun onShowCreateShelves() {
        startActivity(context?.let { CreateShelvesActivity.newIntent(it) })
    }

    private fun swiftFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.yourShelvesFrame,fragment)
            .commit()
    }


}