package il.co.galex.chordview.common.view

import il.co.galex.chordview.common.model.UkuleleChord
import il.co.galex.chordview.common.util.HEIGHT
import il.co.galex.chordview.common.util.WIDTH
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement

actual class ChordView {

    var canvas: HTMLCanvasElement? = null
    set(value) {
        canvas?.apply {
            this.width = WIDTH
            this.height = HEIGHT
        }
        field = value
    }

    actual var ukuleleChord: UkuleleChord? = null

    actual fun drawLines(ukuleleChord: UkuleleChord) {

        canvas?.let {

            val context: CanvasRenderingContext2D = it.getContext("2d") as CanvasRenderingContext2D
            context.moveTo(0.0, 0.0)
            context.lineTo(WIDTH.toDouble(), HEIGHT.toDouble())
            context.stroke()
        }
    }

    actual fun drawCircles(ukuleleChord: UkuleleChord) {


    }

    fun render() {
        ukuleleChord?.let {
            drawLines(it)
            drawCircles(it)
        }
    }
}