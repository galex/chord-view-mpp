package il.co.galex.chordview.js.demo

import il.co.galex.chordview.common.model.UkuleleChord
import il.co.galex.chordview.common.view.ChordView
import org.w3c.dom.HTMLCanvasElement
import kotlin.browser.document
import kotlin.browser.window

@Suppress("unused")
fun main(args: Array<String>) {


    window.alert("Alert! Alert!!!")

    val canvas = document.getElementById("canvas") as HTMLCanvasElement
    val chordView = ChordView()

    chordView.canvas = canvas
    chordView.ukuleleChord = UkuleleChord.A
    chordView.render()
}