package com.tha.thelibrary.view.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import com.tha.thelibrary.R

class CustomViewProfileCircle @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var size = 0
    private var radius = 0f
    private val path = Path()
    private var profileTopColor = Color.RED
    private var profileRightColor = Color.BLUE
    private var profileBottomColor = Color.GREEN
    private var profileLeftColor = Color.YELLOW

    //Paint object for coloring and styling
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.GREEN
        strokeWidth = 5f
        style = Paint.Style.STROKE
        isAntiAlias = true
    }

    init {
        //take color with customize from xml
        context.withStyledAttributes(attrs, R.styleable.CustomViewProfileCircle) {
            profileTopColor = getInt(R.styleable.CustomViewProfileCircle_profile_top_color, 0)
            profileRightColor = getInt(R.styleable.CustomViewProfileCircle_profile_right_color, 0)
            profileBottomColor = getInt(R.styleable.CustomViewProfileCircle_profile_bottom_color, 0)
            profileLeftColor = getInt(R.styleable.CustomViewProfileCircle_profile_left_color, 0)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        drawProfileViewCircle(canvas)
        super.onDraw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        size = measuredWidth.coerceAtMost(measuredHeight)
        radius = size * 0.40f
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    private fun drawProfileViewCircle(canvas: Canvas?) {

        //Draw Profile top color
        paint.color = profileTopColor
        canvas?.drawCircle(size / 2f, size / 2f, radius, paint)

        //take four point to drawArc
        val mRectF = RectF(
            size / 2f - radius,
            size / 2f - radius,
            size / 2f + radius,
            size / 2f + radius
        )

        //Draw Profile Right Color
        paint.color = profileRightColor
        canvas?.drawArc(mRectF, 310f, 90f, true, paint)

        //Draw Profile Bottom Color
        paint.color = profileBottomColor
        canvas?.drawArc(mRectF, 40f, 120f, true, paint)

        //Draw Profile Left Color
        paint.color = profileLeftColor
        canvas?.drawArc(mRectF, 160f, 50f, true, paint)

        //Draw Inner Circle
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        canvas?.drawCircle(size / 2f, size / 2f, radius - 5f, paint)

        //Change circle of profile image
        path.addCircle(size / 2f, size / 2f, radius - 10f, Path.Direction.CCW)
        canvas?.clipPath(path)
    }

}