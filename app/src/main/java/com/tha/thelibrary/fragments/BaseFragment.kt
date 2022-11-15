package com.tha.thelibrary.fragments

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

abstract class BaseFragment : Fragment() {

    //set up BottomSheet
    //context(current Fragment)
    //bottomSheetLayout(Bottom sheet layout name by integer)
    fun showBottomSheet(context: Context, bottomSheetLayout: Int) {
        val dialog = BottomSheetDialog(context)
        val view = layoutInflater.inflate(bottomSheetLayout, null)
        dialog.setOnShowListener {
            val bottomSheet =
                dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
        }
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(view)
        dialog.show()
    }
}