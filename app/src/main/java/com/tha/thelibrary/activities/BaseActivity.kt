package com.tha.thelibrary.activities

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior

abstract class BaseActivity : AppCompatActivity() {

    //set up BottomSheet for Profile Detail Screen(ProfileDetailListActivity.kt)
    fun showBottomSheet(bottomSheet: View) {
        val sheet = BottomSheetBehavior.from(bottomSheet)
        when {
            sheet.state != BottomSheetBehavior.STATE_EXPANDED -> {
                sheet.state = BottomSheetBehavior.STATE_EXPANDED
            }
            else -> {
                sheet.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }
    }
}