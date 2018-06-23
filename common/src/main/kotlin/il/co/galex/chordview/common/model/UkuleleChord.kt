package il.co.galex.chordview.common.model

import il.co.galex.chordview.common.util.p

enum class UkuleleChord(vararg val positions: Position) {

    A(p(FretNumber.FIRST, StringNumber.THIRD, Finger.INDEX), p(FretNumber.SECOND, StringNumber.FOURTH, Finger.MIDDLE)),
    C(p(FretNumber.THIRD, StringNumber.FIRST, Finger.RING)),
    F(p(FretNumber.FIRST, StringNumber.SECOND, Finger.INDEX), p(FretNumber.SECOND, StringNumber.FOURTH, Finger.MIDDLE)),
    G(p(FretNumber.SECOND, StringNumber.FIRST, Finger.MIDDLE), p(FretNumber.SECOND, StringNumber.THIRD, Finger.INDEX), p(FretNumber.THIRD, StringNumber.SECOND, Finger.RING));

    /**
     * Returns the biggest number of fret in a Chord so we can draw that number as max
     */
    fun biggestFret(): Int {
        return positions.map { it.fret.ordinal }.max()!!
    }

    /**
     * Knows how many strings we'll need to draw
     */

    companion object {

        fun stringsNumber(): Int = StringNumber.values().size

    }
}