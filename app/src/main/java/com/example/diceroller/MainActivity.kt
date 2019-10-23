package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage1 : ImageView
    private lateinit var diceImage2 : ImageView
    private lateinit var diceImage3 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUpButton: Button = findViewById(R.id.count_button)
        countUpButton.setOnClickListener { countUp() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }

        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
        diceImage3 = findViewById(R.id.dice_image3)
    }

    private fun rollDice() {

        val randomInt1 = (1..6).random()
        val randomInt2 = (1..6).random()
        val randomInt3 = (1..6).random()
        val total = randomInt1 + randomInt2 + randomInt3

        val resultText1: TextView = findViewById(R.id.first)
        val resultText: TextView = findViewById(R.id.result_text)

        resultText1.text = "$randomInt1 + $randomInt2 + $randomInt3"
        resultText.text = total.toString()

        diceImage1.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
        diceImage3.setImageResource(getRandomDiceImage())
    }

    private fun getRandomDiceImage() : Int {
        val randomDice = (1..6).random()

        val drawableResource = when  (randomDice) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        return drawableResource
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
        diceImage1.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
        diceImage3.setImageResource(R.drawable.empty_dice)
    }
}