package il.co.galex.chordview.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import il.co.galex.chordview.common.model.UkuleleChord
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chordView.ukuleleChord = UkuleleChord.A
        chordView2.ukuleleChord = UkuleleChord.C
        chordView3.ukuleleChord = UkuleleChord.G
        chordView4.ukuleleChord = UkuleleChord.F
    }
}
