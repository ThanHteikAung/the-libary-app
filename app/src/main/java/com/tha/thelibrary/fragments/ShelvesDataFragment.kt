package com.tha.thelibrary.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tha.thelibrary.R
import com.tha.thelibrary.adapters.ShelvesListItemAdapter
import kotlinx.android.synthetic.main.fragment_shelves_data.*

class ShelvesDataFragment : Fragment() {

    private lateinit var mShelvesListItemAdapter: ShelvesListItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shelves_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpShelvesRecycler()
    }

    private fun setUpShelvesRecycler(){
        mShelvesListItemAdapter = ShelvesListItemAdapter()
        rvYourShelves.adapter = mShelvesListItemAdapter
        rvYourShelves.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
    }

}