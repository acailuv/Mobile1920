package com.github.acailuv.randomgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var returnText: TextView
    lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        returnText = findViewById(R.id.return_text)
        rollButton = findViewById(R.id.roll_button)

        rollButton.setOnClickListener {
            Toast.makeText(this, "Flipped Coin", Toast.LENGTH_SHORT).show()

            /*
              NOTE:
               Somehow, I can't seem to random a number between 1 to 2 if I use .nextInt(1, 2)
               I have to use range 1 to 3 and it seems to work properly.
               Feel free to try, though.
            */
            val roll: Int = Random.nextInt(1, 3) //see note above to know why i use .nextInt(1, 3)

            when(roll) {
                1 -> returnText.text = "HEADS"
                2 -> returnText.text = "TAILS"
            }
        }
    }

}
