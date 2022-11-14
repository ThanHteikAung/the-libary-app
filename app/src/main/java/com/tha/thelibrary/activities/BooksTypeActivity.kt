package com.tha.thelibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.tha.thelibrary.R
import com.tha.thelibrary.adapters.ChildRecyclerAdapter
import kotlinx.android.synthetic.main.activity_books_type.*

class BooksTypeActivity : AppCompatActivity() {

    private lateinit var mChildRecyclerAdapter: ChildRecyclerAdapter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, BooksTypeActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_type)
        setUpBooksTypeRecycler()
    }

    //setup BooksType Recycler View
    private fun setUpBooksTypeRecycler() {
        mChildRecyclerAdapter = ChildRecyclerAdapter()
        rvBooksType.adapter = mChildRecyclerAdapter
        rvBooksType.layoutManager = GridLayoutManager(parent, 2, GridLayoutManager.VERTICAL, false)
    }
}