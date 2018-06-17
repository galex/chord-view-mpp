package il.co.galex.chordview.common.model

enum class UkuleleChord(private vararg val positions: Position) {

    A(Position(FretNumber.FIRST, StringNumber.THIRD, Finger.INDEX), Position(FretNumber.SECOND, StringNumber.FOURTH, Finger.MIDDLE)),
    C(Position(FretNumber.THIRD, StringNumber.FIRST, Finger.RING));

    /**
     * Returns the biggest number of fret in a Chord so we can draw that number as max
     */
    fun biggestFret(): Int {
        return positions.map { it.fret.number }.max()!!
    }

    /**
     * Knows how many strings we'll need to draw
     */
    val stringsNumber: Int = StringNumber.values().size
}