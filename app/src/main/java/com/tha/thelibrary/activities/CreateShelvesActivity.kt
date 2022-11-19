package com.tha.thelibrary.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.tha.thelibrary.R
import com.tha.thelibrary.fragments.YourShelvesFragment
import com.tha.thelibrary.mvp.presenters.CreateShelvesPresenter
import com.tha.thelibrary.mvp.presenters.CreateShelvesPresenterImpl
import com.tha.thelibrary.mvp.views.CreateShelvesView
import kotlinx.android.synthetic.main.activity_create_shelves.*

class CreateShelvesActivity : AppCompatActivity(), CreateShelvesView {

    private lateinit var mPresenter: CreateShelvesPresenter
    private lateinit var mYourShelvesFragment: YourShelvesFragment

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CreateShelvesActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_shelves)
        val inputMethodManager =
            this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(edtCreateShelf, InputMethodManager.SHOW_IMPLICIT)
        setUpPresenter()
        setUpListener()

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[CreateShelvesPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpListener() {
        edtCreateShelf.setOnEditorActionListener { _, actionId, event ->
            if ((event != null && (event.keyCode == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                Log.i("Check Done", "Enter pressed")
            }
            false
        }

        btnBack.setOnClickListener {
            mPresenter.onTapBack()
        }

    }

    override fun showShelvesDataList() {
        finish()
    }


}