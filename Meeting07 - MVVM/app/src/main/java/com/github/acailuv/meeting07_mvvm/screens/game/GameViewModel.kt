package com.github.acailuv.meeting07_mvvm.screens.game

import android.content.Intent
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.ScrollView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.acailuv.meeting07_mvvm.MyApplication
import com.github.acailuv.meeting07_mvvm.Scene

class GameViewModel: ViewModel() {

    private var _scene = MutableLiveData<Scene>()
    val scene: LiveData<Scene>
        get() = _scene

    private var _goToMainMenu = MutableLiveData<Boolean>()
    val goToMainMenu: LiveData<Boolean>
        get() = _goToMainMenu

    val scenes = MyApplication.scenes
    var leonRelationship = 0
    var kayaRelationship = 0
    var selectedActionId = -1

    init {
        _scene.value = scenes[0]
        _goToMainMenu.value = false
    }


    fun onAction(actions: RadioGroup, opt1: RadioButton, opt2: RadioButton, opt3: RadioButton, opt4: RadioButton, scrollView: ScrollView) {
        val checkedRadioButtonId = actions.checkedRadioButtonId

        when(checkedRadioButtonId) {
            opt1.id -> selectedActionId = 0
            opt2.id -> selectedActionId = 1
            opt3.id -> selectedActionId = 2
            opt4.id -> selectedActionId = 3
        }

        if(checkedRadioButtonId != -1) {

            when(checkedRadioButtonId) {
                opt1.id -> selectedActionId = 0
                opt2.id -> selectedActionId = 1
                opt3.id -> selectedActionId = 2
                opt4.id -> selectedActionId = 3
            }

            when (_scene.value) {
                scenes[0] -> _scene.value = scenes[1] // Intro
                scenes[1] -> { // Fateful Encounter
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[2]
                        1 -> _scene.value = scenes[3]
                        2 -> _scene.value = scenes[4]
                        3 -> _scene.value = scenes[5]
                    }
                }
                scenes[2] -> { // F.E. Honesty
                    leonRelationship++
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[6]
                        1 -> _scene.value = scenes[7]
                    }
                }
                scenes[3] -> { // F.E. Intimidation
                    leonRelationship--
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[6]
                        1 -> _scene.value = scenes[7]
                    }
                }
                scenes[4] -> { // F.E. Cold
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[6]
                        1 -> _scene.value = scenes[7]
                    }
                }
                scenes[5] -> { // F.E. Generosity
                    leonRelationship++
                    kayaRelationship++
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[6]
                        1 -> _scene.value = scenes[7]
                    }
                }
                scenes[6] -> { // Strong Enough On My Own
                    kayaRelationship++
                    leonRelationship--
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[8]
                        1 -> _scene.value = scenes[7]
                    }
                }
                scenes[7] -> { // You Left Them
                    MyApplication.badEnding1 = true
                    ending()
                }
                scenes[8] -> {
                    when(selectedActionId) { // Minotaur Fight
                        0 -> _scene.value = scenes[9]
                        1 -> _scene.value = scenes[10]
                        2 -> _scene.value = scenes[10]
                    }
                }
                scenes[9] -> {
                    when(selectedActionId) { // Heroic Comeuppance!
                        0 -> _scene.value = scenes[11]
                        1 -> _scene.value = scenes[12]
                        2 -> _scene.value = scenes[13]
                    }
                }
                scenes[10] -> { // You Ignored Them
                    MyApplication.badEnding2 = true
                    ending()
                }
                scenes[11] -> {
                    when(selectedActionId) { // Challenge thieves
                        0 -> _scene.value = scenes[14]
                        1 -> _scene.value = scenes[15]
                    }
                }
                scenes[12] -> { // guild's cubes
                    leonRelationship--
                    _scene.value = scenes[16]
                }
                scenes[13] -> { // your cube
                    leonRelationship--
                    kayaRelationship++
                    _scene.value = scenes[16]
                }
                scenes[14] -> {
                    leonRelationship++
                    kayaRelationship -= 2
                    _scene.value = scenes[16]
                }
                scenes[15] -> {
                    leonRelationship++
                    kayaRelationship++
                    _scene.value = scenes[16]
                }
                scenes[16] -> {
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[18]
                        1 -> {
                            _scene.value = scenes[17]
                            leonRelationship++
                            kayaRelationship++

                        }
                    }
                }
                scenes[17] -> _scene.value = scenes[19]
                scenes[18] -> {
                    _scene.value = scenes[19]
                    leonRelationship++
                    kayaRelationship++
                }
                scenes[19] -> _scene.value = scenes[20]
                scenes[20] -> {
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[21]
                        1 -> {
                            _scene.value = scenes[22]
                            leonRelationship--

                        }
                    }
                }
                scenes[21] -> _scene.value = scenes[23]
                scenes[22] -> {
                    _scene.value = scenes[23]
                    leonRelationship--
                }
                scenes[23] -> _scene.value = scenes[24]
                scenes[24] -> {
                    if (leonRelationship < 1) {
                        _scene.value = scenes[25]
                    } else {
                        _scene.value = scenes[26]
                    }
                }
                scenes[25] -> _scene.value = scenes[28]
                scenes[26] -> _scene.value = scenes[27]
                scenes[27] -> _scene.value = scenes[31]
                scenes[28] -> {
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[30]
                        1 -> _scene.value = scenes[29]
                    }
                }
                scenes[29] -> {
                    MyApplication.badEnding3 = true
                    ending()
                }
                scenes[30] -> {
                    MyApplication.normalEnding1 = true
                    ending()
                }
                scenes[31] -> _scene.value = scenes[32]
                scenes[32] -> {
                    if (kayaRelationship >= 3) {
                        _scene.value = scenes[36]
                    } else {
                        _scene.value = scenes[33]
                    }
                }
                scenes[33] -> {
                    when(selectedActionId) {
                        0 -> _scene.value = scenes[34]
                        1 -> _scene.value = scenes[35]
                    }
                }
                scenes[34] -> {
                    MyApplication.badEnding4 = true
                    ending()
                }
                scenes[35] -> {
                    MyApplication.normalEnding2 = true
                    ending()
                }
                scenes[36] -> _scene.value = scenes[37]
                scenes[37] -> {
                    MyApplication.bestEnding = true
                    ending()
                }
            }

            // Disabling options if choice == "" and enabling them if not
            if (_scene.value!!.actions[0] == "") opt1.isEnabled = false else opt1.isEnabled = true
            if (_scene.value!!.actions[1] == "") opt2.isEnabled = false else opt2.isEnabled = true
            if (_scene.value!!.actions[2] == "") opt3.isEnabled = false else opt3.isEnabled = true
            if (_scene.value!!.actions[3] == "") opt4.isEnabled = false else opt4.isEnabled = true

            actions.clearCheck()
            scrollView.fullScroll(ScrollView.FOCUS_UP)
        }

    }

    private fun ending() {
        kayaRelationship = 0
        leonRelationship = 0
        when(selectedActionId) {
            0 -> _goToMainMenu.value = true
            1 -> _scene.value = scenes[0]
        }
    }
}