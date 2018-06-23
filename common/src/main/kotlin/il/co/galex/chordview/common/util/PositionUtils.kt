package il.co.galex.chordview.common.util

import il.co.galex.chordview.common.model.Finger
import il.co.galex.chordview.common.model.FretNumber
import il.co.galex.chordview.common.model.Position
import il.co.galex.chordview.common.model.StringNumber

/**
 * @author Alexander Gherschon
 */

fun p(fret: FretNumber, string: StringNumber, finger: Finger) = Position(fret, string, finger)