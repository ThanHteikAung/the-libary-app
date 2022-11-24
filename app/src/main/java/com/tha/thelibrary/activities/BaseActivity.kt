package com.tha.thelibrary.activities

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tha.thelibrary.data.vos.BookVO
import kotlinx.android.synthetic.main.option_menu_book_sheet.view.*

abstract class BaseActivity : AppCompatActivity() {

    //set up BottomSheet
    //context(current activity)
    //bottomSheetLayout(Bottom sheet layout name by integer)
    @SuppressLint("SetTextI18n")
    fun showBottomSheet(context: Context, bottomSheetLayout: Int, book: BookVO) {
        val dialog = BottomSheetDialog(context)
        val view = layoutInflater.inflate(bottomSheetLayout, null)
        Glide.with(context)
            .load(book.bookImage)
            .into(view.optionMenuImage)
        view.tvOptionMenuTitle.text = book.title
        view.tvAuthorName.text = "${book.author} . Ebook"
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