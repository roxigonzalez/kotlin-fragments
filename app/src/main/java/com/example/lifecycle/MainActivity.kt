package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var displayTeamA:TextView
    private lateinit var displayTeamB:TextView
    private lateinit var addOneTeamA:Button
    private lateinit var addOneTeamB:Button

    private var scoreTeamA
    private var scoreTeamB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        displayTeamA.text = scoreTeamA.toString()
        displayTeamB.text = scoreTeamB.toString()

        with(savedInstanceState) {
//            displayTeamA.text = (this?.getInt(TEAM_SCORE_A) ?: scoreTeamA)
        }

    }

    private fun bind() {
        displayTeamA = findViewById(R.id.display_score_team_a_text_view)
        displayTeamB = findViewById(R.id.display_score_team_b_text_view)
        addOneTeamA = findViewById(R.id.add_one_team_a_button)
        addOneTeamB = findViewById(R.id.add_one_team_b_button)

    }


    private fun addListener() {
// get data and add one
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.apply {
            putString()
        }
    }

    companion object {
        const val  TEAM_SCORE_A =
    }

//    example
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "OnStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "OnStart")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "OnStart")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "OnStart")

    }

    companion object {
        const val TAG = "com.example.MainActivity"
    }
}