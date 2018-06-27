package il.co.galex.chordview.common.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import il.co.galex.chordview.common.helper.ChordViewHelper
import il.co.galex.chordview.common.model.UkuleleChord
import il.co.galex.chordview.common.util.HEIGHT
import il.co.galex.chordview.common.util.RADIUS
import il.co.galex.chordview.common.util.WIDTH

@Suppress("CascadeIf")
class ChordView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0): View(context, attributeSet, defStyleAttr) {

    var ukuleleChord: UkuleleChord? = null

    private val blackPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, android.R.color.black)
        strokeWidth = 4F


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val desiredWidth = WIDTH
        val desiredHeight = HEIGHT

        val widthMode = View.MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = View.MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = View.MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = View.MeasureSpec.getSize(heightMeasureSpec)

        val width: Int
        val height: Int

        //Measure Width
        width = if (widthMode == View.MeasureSpec.EXACTLY) {
            widthSize
        } else if (widthMode == View.MeasureSpec.AT_MOST) {
            Math.min(desiredWidth, widthSize)
        } else {
            desiredWidth
        }

        //Measure Height
        height = if (heightMode == View.MeasureSpec.EXACTLY) {
            heightSize
        } else if (heightMode == View.MeasureSpec.AT_MOST) {
            Math.min(desiredHeight, heightSize)
        } else {
            desiredHeight
        }

        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas?) {

        canvas?.let {

            ChordViewHelper.drawGrid(measuredWidth.toFloat(), measuredHeight.toFloat()) { x, y, endX, endY ->
                canvas.drawLine(x, y, endX, endY, blackPaint)
            }

            ukuleleChord?.let {

                ChordViewHelper.drawPositions(measuredWidth.toFloat(), measuredHeight.toFloat(), it) { x, y ->
                    canvas.drawCircle(x, y, RADIUS, blackPaint)
                }

            }

        }
    }
}