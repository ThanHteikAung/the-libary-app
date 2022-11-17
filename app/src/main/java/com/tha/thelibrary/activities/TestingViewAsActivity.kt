package com.tha.thelibrary.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.tha.thelibrary.R
import com.tha.thelibrary.adapters.ChildRecyclerAdapter
import com.tha.thelibrary.delegates.ViewAsDelegate

class TestingViewAsActivity : BaseActivity() {

    private lateinit var mChildRecyclerAdapter: ChildRecyclerAdapter
    private lateinit var mDelegate: ViewAsDelegate

    companion object {
        private lateinit var mContext: Context
        fun newIntent(context: Context): Intent {
            mContext = context
            return Intent(context, TestingViewAsActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showBottomSheet(mContext, R.layout.activity_testing_view_as)
        finish()
    }

    private fun setUpDelegate(delegate: ViewAsDelegate) {
        mDelegate = delegate
    }

    // Get the selected radio button text using radio button on click listener
    fun onRadioBtnList(view: View) {
        mDelegate.onTapList()
    }

    fun onRadioBtnSmallGrid(view: View) {
        mDelegate.onTapSmallGrid()
    }

    fun onRadioBtnLargeGrid(view: View) {
        mDelegate.onTapLargeGrid()
    }
}