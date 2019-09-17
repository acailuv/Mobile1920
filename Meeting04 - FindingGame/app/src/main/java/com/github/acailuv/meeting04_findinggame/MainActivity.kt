package com.github.acailuv.meeting04_findinggame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.acailuv.meeting04_findinggame.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var selectedView: View
    private var selectedId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val boxesId: List<Int> = listOf(
            binding.boxOneText.id,
            binding.boxTwoText.id,
            binding.boxThreeText.id,
            binding.boxFourText.id,
            binding.boxFiveText.id
        )
        selectedId = boxesId[Random.nextInt(0, 5)]
        Log.d("ActivityMain :: ", "SelectedID: ${selectedId}; From: ${boxesId}")
        setListeners()
    }

    private fun setBehavior(view: View) {
        if(view.id == selectedId) {
            setButtonBackground(view, android.R.drawable.btn_star_big_on)
            selectedView = view
            winHandler()
        } else setButtonBackground(view, android.R.drawable.btn_star_big_off)
    }

    private fun setButtonBackground(view: View, buttonIcon: Int) {
        view.setBackgroundResource(buttonIcon)
    }

    private fun winHandler() {
        Toast.makeText(this, "YOU WIN! Tap the shining star to play again.", Toast.LENGTH_LONG).show()
        selectedView.setOnClickListener {
            resetAll()
        }
    }

    private fun resetAll() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val boxesId: List<Int> = listOf(
            binding.boxOneText.id,
            binding.boxTwoText.id,
            binding.boxThreeText.id,
            binding.boxFourText.id,
            binding.boxFiveText.id
        )
        selectedId = boxesId[Random.nextInt(0, 5)]
        Log.d("ActivityMain :: ", "SelectedID: ${selectedId}; From: ${boxesId}")

        binding.apply {
            val boxOneText = boxOneText
            val boxTwoText = boxTwoText
            val boxThreeText = boxThreeText
            val boxFourText = boxFourText
            val boxFiveText = boxFiveText

            val clickableViews: List<View> =
                listOf(boxOneText, boxTwoText, boxThreeText,
                    boxFourText, boxFiveText)

            for (item in clickableViews) {
                item.setOnClickListener {
                    setBehavior(it)
                }
                item.setBackgroundColor(Color.WHITE)
            }
        }
    }

    private fun setListeners() {
        binding.apply {
            val boxOneText = boxOneText
            val boxTwoText = boxTwoText
            val boxThreeText = boxThreeText
            val boxFourText = boxFourText
            val boxFiveText = boxFiveText

            val clickableViews: List<View> =
                listOf(boxOneText, boxTwoText, boxThreeText,
                    boxFourText, boxFiveText)

            for (item in clickableViews) {
                item.setOnClickListener {
                    setBehavior(it)
                }
            }
        }
    }
}
