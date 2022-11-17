package com.tha.thelibrary.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tha.thelibrary.R
import com.tha.thelibrary.delegates.ViewAsDelegate
import kotlinx.android.synthetic.main.fragment_view_as.*

class ViewAsFragment : BottomSheetDialogFragment() {

    private lateinit var mDelegate: ViewAsDelegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_as, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpRadioBtnListener()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            setOnShowListener {
                val bottomSheet =
                    (it as BottomSheetDialog).findViewById(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
                BottomSheetBehavior.from(bottomSheet!!).state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
    }

    fun setUpDelegate(delegate: ViewAsDelegate) {
        mDelegate = delegate
    }

    private fun setUpRadioBtnListener() {
        radioBtnList.setOnClickListener {
            radioBtnList.isChecked = true
            mDelegate.onTapList()
        }
        radioBtnSmallGrid.setOnClickListener {
            radioBtnSmallGrid.isChecked = true
            mDelegate.onTapSmallGrid()
        }
        radioBtnLargeGrid.setOnClickListener {
            radioBtnLargeGrid.isChecked = true
            mDelegate.onTapLargeGrid()
        }
    }


}