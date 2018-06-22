package il.co.galex.chordview.common.helper

import il.co.galex.chordview.common.model.UkuleleChord
import il.co.galex.chordview.common.util.MARGIN
import il.co.galex.chordview.common.util.MINIMUM_FRETS
import il.co.galex.chordview.common.util.RADIUS

/**
 * @author Alexander Gherschon
 */
object ChordViewHelper {

    fun drawGrid(viewWidth: Float, currentHeight: Float, renderLine: (x: Float, y: Float, endX: Float, endY: Float) -> Unit) {

        val x = 0F + MARGIN
        val y = 0F + MARGIN

        val width = viewWidth - MARGIN
        val height = currentHeight - MARGIN

        renderLine(x, y, width, y)
        renderLine(width, y, width, height)
        renderLine(width, height, x, height)
        renderLine(x, height, x, y)

        val fretWidth = (width - x) / (UkuleleChord.stringsNumber() -1)
        for (i in 1..2) renderLine(x + fretWidth * i, y, x + fretWidth * i, height)

        val fretHeight = (height - y) / MINIMUM_FRETS
        for (i in 1..4) renderLine(x, y + fretHeight * i, width, y + fretHeight * i)
    }

    fun drawPositions(viewWidth: Float, currentHeight: Float, ukuleleChord: UkuleleChord, renderCircle: (x: Float, y: Float, radius: Float) -> Unit) {

        val x = 0F + MARGIN
        val y = 0F + MARGIN

        val width = viewWidth - MARGIN
        val height = currentHeight - MARGIN

        val fretWidth = (width - x) / (UkuleleChord.stringsNumber() - 1)
        val fretHeight = (height - y) / MINIMUM_FRETS

        ukuleleChord.positions.forEach { position ->

            val stringPosition = position.string.gridPosition
            val posX = x + (fretWidth * stringPosition)

            val fretPosition = position.fret.ordinal + 1
            val posY = y + (fretHeight * fretPosition) - fretHeight / 2

            renderCircle(posX, posY, RADIUS)
        }
    }
}