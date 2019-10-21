package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUpButton: Button = findViewById(R.id.count_button)
        countUpButton.setOnClickListener { countUp() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
    }

    private fun rollDice() {
        val randomInt1 = (1..6).random()
        val randomInt2 = (1..6).random()
        val randomInt3 = (1..6).random()
        val plus = " + "
        val total = randomInt1 + randomInt2 + randomInt3
        val text = randomInt1.toString() + plus + randomInt2.toString() + plus + randomInt3.toString()

        val resultText1: TextView = findViewById(R.id.first)
        val resultText: TextView = findViewById(R.id.result_text)

        resultText1.text = text
        resultText.text = total.toString()
    }

    private fun countUp() {

        val resultText: TextView = findViewById(R.id.result_text)
        val num = Integer.parseInt(resultText.text.toString()) + 1

        if(num<19)
            resultText.text = num.toString()
    }

    private fun reset() {

        val resultText1: TextView = findViewById(R.id.first)
        val resultText: TextView = findViewById(R.id.result_text)
        val reset = "DiceRoller"
        resultText1.text = ""
        resultText.text = reset
    }
}