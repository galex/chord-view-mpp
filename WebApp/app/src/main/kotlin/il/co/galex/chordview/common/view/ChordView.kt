package il.co.galex.chordview.common.view

import il.co.galex.chordview.common.helper.ChordViewHelper
import il.co.galex.chordview.common.model.UkuleleChord
import il.co.galex.chordview.common.util.HEIGHT
import il.co.galex.chordview.common.util.RADIUS
import il.co.galex.chordview.common.util.WIDTH
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import kotlin.math.PI

actual class ChordView {

    actual var ukuleleChord: UkuleleChord? = null

    lateinit var canvas: HTMLCanvasElement

    fun render() {

        val sizeRatio = 0.5

        canvas.apply {

            width = (WIDTH * sizeRatio).toInt()
            height = (HEIGHT * sizeRatio).toInt()
        }

        ukuleleChord?.let {

            console.log("rendering inside our canvas = $canvas")
            console.log("rendering inside our canvas context = ${canvas.getContext("2d")}")

            ChordViewHelper.drawGrid(canvas.width.toFloat(), canvas.height.toFloat()) { x, y, endX, endY ->

                val context2D = canvas.getContext("2d") as CanvasRenderingContext2D

                context2D.beginPath()
                context2D.moveTo(x.toDouble(), y.toDouble())
                context2D.lineTo(endX.toDouble(), endY.toDouble())
                context2D.stroke()
            }

            ChordViewHelper.drawPositions(canvas.width.toFloat(), canvas.height.toFloat(), it) { x, y  ->

                val context2D = canvas.getContext("2d") as CanvasRenderingContext2D

                context2D.beginPath()
                context2D.arc(x.toDouble(), y.toDouble(), RADIUS.toDouble() * sizeRatio, 0.0, 2 * PI, false)
                context2D.fillStyle = "black"
                context2D.fill()
                context2D.stroke()
            }
        }
    }
}