package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    // UI elements
    private lateinit var displayTeamA:TextView
    private lateinit var displayTeamB:TextView
    private lateinit var addOneTeamA:Button
    private lateinit var addOneTeamB:Button
    private lateinit var getResults:Button

    // data element
    private var scoreTeamA = 0
    private var scoreTeamB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        displayTeamA.text = scoreTeamA.toString()
        displayTeamB.text = scoreTeamB.toString()
        addListener()
        getResults()
    }

    private fun bind() {
        displayTeamA = findViewById(R.id.display_score_team_a_text_view)
        displayTeamB = findViewById(R.id.display_score_team_b_text_view)
        addOneTeamA = findViewById(R.id.add_one_team_a_button)
        addOneTeamB = findViewById(R.id.add_one_team_b_button)
        getResults = findViewById(R.id.get_results)
    }


    private fun addListener() {
        addOneTeamA.setOnClickListener{
            scoreTeamA++
            displayTeamA.text = scoreTeamA.toString()
        }
        addOneTeamB.setOnClickListener{
            scoreTeamB++
            displayTeamB.text = scoreTeamB.toString()
        }
    }

    private fun getResults() {
        getResults.setOnClickListener {
//            val mBundle = Bundle()
//            mBundle.putString("team_a", scoreTeamA.toString())
//            mBundle.putString("team_b", scoreTeamA.toString())

            val fragmentManager = supportFragmentManager
            val fragment = CounterFragment.newInstance(scoreTeamA.toString(), scoreTeamB.toString())
            fragmentManager.beginTransaction()
                .replace(R.id.counter_fragment, fragment)
                .commit()

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.apply {
            putInt(TEAM_SCORE_A, scoreTeamA)
            putInt(TEAM_B_SCORE, scoreTeamB)
        }
    }

    companion object {
        const val TEAM_SCORE_A = "TEAM_A_SCORE"
        const val TEAM_B_SCORE = "TEAM_B_SCORE"
    }
}