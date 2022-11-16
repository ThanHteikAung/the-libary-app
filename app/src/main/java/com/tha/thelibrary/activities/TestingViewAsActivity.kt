package com.tha.thelibrary.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.tha.thelibrary.R

class TestingViewAsActivity : BaseActivity() {

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

    // Get the selected radio button text using radio button on click listener
    fun radio_button_click() {
        // Get the clicked radio button instance
        println("Radio Button Testing")
    }
}
