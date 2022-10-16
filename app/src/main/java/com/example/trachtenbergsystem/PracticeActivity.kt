package com.example.trachtenbergsystem

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.trachtenbergsystem.examples.ExampleType
import com.example.trachtenbergsystem.examples.ExamplesGenerator

// Todo
// 1. Make cursor work
// 2. Left and right arrows
// 3. Make font smaller if it doesn't fit textview
// 4. Make numpad font bigger

class PracticeActivity : AppCompatActivity() {
    private lateinit var userInputTextView : TextView
    private lateinit var exampleNumberTextView : TextView
    private lateinit var exampleTextView : TextView

    private val examplesGenerator : ExamplesGenerator = ExamplesGenerator()
    private var examplesList : ArrayList<List<Any>> = ArrayList()
    private var examplesNum : Int = 3
    private var curExampleNumber : Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.practice_activity)

        userInputTextView = findViewById(R.id.practice_numpad_text)

        exampleNumberTextView = findViewById(R.id.practice_example_number)
        exampleNumberTextView.text = "1 / $examplesNum"

        examplesList = examplesGenerator.generate(ExampleType.ELEVEN, examplesNum, 0, 5)
        exampleTextView = findViewById(R.id.practice_example)
        if (examplesList.size > 0) exampleTextView.text = examplesList[curExampleNumber - 1][0].toString()

        setListeners()
    }

    fun setListeners() {
        findViewById<Button>(R.id.practice_numpad_0).setOnClickListener {
            numpadTextAppend("0")
            checkAnswer()
        }

        findViewById<Button>(R.id.practice_numpad_1).setOnClickListener {
            numpadTextAppend("1")
            checkAnswer()
        }

        findViewById<Button>(R.id.practice_numpad_2).setOnClickListener {
            numpadTextAppend("2")
            checkAnswer()
        }

        findViewById<Button>(R.id.practice_numpad_3).setOnClickListener {
            numpadTextAppend("3")
            checkAnswer()
        }

        findViewById<Button>(R.id.practice_numpad_4).setOnClickListener {
            numpadTextAppend("4")
            checkAnswer()
        }

        findViewById<Button>(R.id.practice_numpad_5).setOnClickListener {
            numpadTextAppend("5")
            checkAnswer()
        }

        findViewById<Button>(R.id.practice_numpad_6).setOnClickListener {
            numpadTextAppend("6")
            checkAnswer()
        }

        findViewById<Button>(R.id.practice_numpad_7).setOnClickListener {
            numpadTextAppend("7")
            checkAnswer()
        }

        findViewById<Button>(R.id.practice_numpad_8).setOnClickListener {
            numpadTextAppend("8")
            checkAnswer()
        }

        findViewById<Button>(R.id.practice_numpad_9).setOnClickListener {
            numpadTextAppend("9")
            checkAnswer()
        }

        findViewById<Button>(R.id.practice_numpad_point).setOnClickListener {
            numpadTextAppend(".")
        }

        findViewById<Button>(R.id.practice_numpad_minus).setOnClickListener {
            numpadTextAppend("-")
        }

        findViewById<Button>(R.id.practice_numpad_erase).setOnClickListener {
            numpadTextPopBack()
        }

        findViewById<Button>(R.id.practice_numpad_clear).setOnClickListener {
            numpadTextClear()
        }
    }

    fun numpadTextAppend(str: String) {
        userInputTextView.text = userInputTextView.text.toString() + str
    }

    fun numpadTextPopBack() {
        if (userInputTextView.length() > 0)
            userInputTextView.text = userInputTextView.text.subSequence(0, userInputTextView.length() - 1)
    }

    fun numpadTextClear() {
        userInputTextView.text = ""
    }

    fun checkAnswer() {
        // If user input equals to answer
        if (userInputTextView.text.equals(examplesList[curExampleNumber - 1][1])) {
            // Show new example
            if (curExampleNumber < examplesNum) {
                curExampleNumber++
                exampleNumberTextView.text = "${curExampleNumber} / $examplesNum"
                exampleTextView.text = examplesList[curExampleNumber - 1][0].toString()
            }

            // Show that all tasks done
            else {
                exampleTextView.text = "Great!!"
            }

            numpadTextClear()
        }
    }

}


