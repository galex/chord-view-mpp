package il.co.galex.chordview.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import il.co.galex.chordview.common.model.UkuleleChord

actual class ChordView(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int): View(context, attributeSet, defStyleAttr) {

    actual var ukuleleChord: UkuleleChord? = null
}