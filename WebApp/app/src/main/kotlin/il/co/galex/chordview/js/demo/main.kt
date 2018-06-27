package il.co.galex.chordview.js.demo

import il.co.galex.chordview.common.model.UkuleleChord
import il.co.galex.chordview.common.view.ChordView
import org.w3c.dom.HTMLCanvasElement
import kotlin.browser.document
import kotlin.browser.window

@Suppress("unused")
fun main(args: Array<String>) {

    (document.getElementById("canvas1") as? HTMLCanvasElement)?.createChord(UkuleleChord.A)
    (document.getElementById("canvas2") as? HTMLCanvasElement)?.createChord(UkuleleChord.C)
    (document.getElementById("canvas3") as? HTMLCanvasElement)?.createChord(UkuleleChord.G)
    (document.getElementById("canvas4") as? HTMLCanvasElement)?.createChord(UkuleleChord.F)

    console.log("End!")
}

fun HTMLCanvasElement?.createChord(ukuleleChord: UkuleleChord) {

    this?.let {

        val chordView = ChordView()
        chordView.canvas = it
        chordView.ukuleleChord = ukuleleChord
        chordView.render()
    }
}