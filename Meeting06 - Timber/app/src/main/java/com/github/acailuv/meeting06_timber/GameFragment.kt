package com.github.acailuv.meeting06_timber


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.acailuv.meeting06_timber.databinding.FragmentGameBinding
import com.github.acailuv.meeting06_timber.MyApplication.Scene
import timber.log.Timber

/** Logging DONE! **/

class GameFragment : Fragment() {

    // Variables
    private val scenes = MyApplication.scenes
    lateinit var currentScene: Scene
    private var selectedActionId: Int = 0
    private var kayaRelationship = 0
    private var leonRelationship = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Timber.d(MyApplication.ON_ATTACH_CALLED)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.d(MyApplication.ON_CREATE_CALLED)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater,
            R.layout.fragment_game, container, false)

        // This is IMPORTANT! without this, "@{}" things in [fragment_game.sml] won't work.
        currentScene = scenes[0]

        // Bind this fragment class to the layout
        binding.scene = this

        // Listener for action button
        binding.actionButton.setOnClickListener {

            if(binding.actions.checkedRadioButtonId != -1) {

                when (binding.actions.checkedRadioButtonId) {
                    binding.actionOne.id -> selectedActionId = 0
                    binding.actionTwo.id -> selectedActionId = 1
                    binding.actionThree.id -> selectedActionId = 2
                    binding.actionFour.id -> selectedActionId = 3
                }

                when (currentScene) {
                    scenes[0] -> currentScene = scenes[1] // Intro
                    scenes[1] -> { // Fateful Encounter
                        when(selectedActionId) {
                            0 -> currentScene = scenes[2]
                            1 -> currentScene = scenes[3]
                            2 -> currentScene = scenes[4]
                            3 -> currentScene = scenes[5]
                        }
                    }
                    scenes[2] -> { // F.E. Honesty
                        leonRelationship++
                        when(selectedActionId) {
                            0 -> currentScene = scenes[6]
                            1 -> currentScene = scenes[7]
                        }
                    }
                    scenes[3] -> { // F.E. Intimidation
                        leonRelationship--
                        when(selectedActionId) {
                            0 -> currentScene = scenes[6]
                            1 -> currentScene = scenes[7]
                        }
                    }
                    scenes[4] -> { // F.E. Cold
                        when(selectedActionId) {
                            0 -> currentScene = scenes[6]
                            1 -> currentScene = scenes[7]
                        }
                    }
                    scenes[5] -> { // F.E. Generosity
                        leonRelationship++
                        kayaRelationship++
                        when(selectedActionId) {
                            0 -> currentScene = scenes[6]
                            1 -> currentScene = scenes[7]
                        }
                    }
                    scenes[6] -> { // Strong Enough On My Own
                        kayaRelationship++
                        leonRelationship--
                        when(selectedActionId) {
                            0 -> currentScene = scenes[8]
                            1 -> currentScene = scenes[7]
                        }
                    }
                    scenes[7] -> { // You Left Them
                        MyApplication.badEnding1 = true
                        ending()
                    }
                    scenes[8] -> {
                        when(selectedActionId) { // Minotaur Fight
                            0 -> currentScene = scenes[9]
                            1 -> currentScene = scenes[10]
                            2 -> currentScene = scenes[10]
                        }
                    }
                    scenes[9] -> {
                        when(selectedActionId) { // Heroic Comeuppance!
                            0 -> currentScene = scenes[11]
                            1 -> currentScene = scenes[12]
                            2 -> currentScene = scenes[13]
                        }
                    }
                    scenes[10] -> { // You Ignored Them
                        MyApplication.badEnding2 = true
                        ending()
                    }
                    scenes[11] -> {
                        when(selectedActionId) { // Challenge thieves
                            0 -> currentScene = scenes[14]
                            1 -> currentScene = scenes[15]
                        }
                    }
                    scenes[12] -> { // guild's cubes
                        leonRelationship--
                        currentScene = scenes[16]
                    }
                    scenes[13] -> { // your cube
                        leonRelationship--
                        kayaRelationship++
                        currentScene = scenes[16]
                    }
                    scenes[14] -> {
                        leonRelationship++
                        kayaRelationship -= 2
                        currentScene = scenes[16]
                    }
                    scenes[15] -> {
                        leonRelationship++
                        kayaRelationship++
                        currentScene = scenes[16]
                    }
                    scenes[16] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[18]
                            1 -> {
                                currentScene = scenes[17]
                                leonRelationship++
                                kayaRelationship++

                            }
                        }
                    }
                    scenes[17] -> currentScene = scenes[19]
                    scenes[18] -> {
                        currentScene = scenes[19]
                        leonRelationship++
                        kayaRelationship++
                    }
                    scenes[19] -> currentScene = scenes[20]
                    scenes[20] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[21]
                            1 -> {
                                currentScene = scenes[22]
                                leonRelationship--

                            }
                        }
                    }
                    scenes[21] -> currentScene = scenes[23]
                    scenes[22] -> {
                        currentScene = scenes[23]
                        leonRelationship--
                    }
                    scenes[23] -> currentScene = scenes[24]
                    scenes[24] -> {
                        if (leonRelationship < 1) {
                            currentScene = scenes[25]
                        } else {
                            currentScene = scenes[26]
                        }
                    }
                    scenes[25] -> currentScene = scenes[28]
                    scenes[26] -> currentScene = scenes[27]
                    scenes[27] -> currentScene = scenes[31]
                    scenes[28] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[30]
                            1 -> currentScene = scenes[29]
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
                    scenes[31] -> currentScene = scenes[32]
                    scenes[32] -> {
                        if (kayaRelationship >= 3) {
                            currentScene = scenes[36]
                        } else {
                            currentScene = scenes[33]
                        }
                    }
                    scenes[33] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[34]
                            1 -> currentScene = scenes[35]
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
                    scenes[36] -> currentScene = scenes[37]
                    scenes[37] -> {
                        MyApplication.bestEnding = true
                        ending()
                    }
                }

                // Disabling options if choice == "" and enabling them if not
                if (currentScene.actions[0] == "") binding.actionOne.isEnabled = false else binding.actionOne.isEnabled = true
                if (currentScene.actions[1] == "") binding.actionTwo.isEnabled = false else binding.actionTwo.isEnabled = true
                if (currentScene.actions[2] == "") binding.actionThree.isEnabled = false else binding.actionThree.isEnabled = true
                if (currentScene.actions[3] == "") binding.actionFour.isEnabled = false else binding.actionFour.isEnabled = true

                binding.actions.clearCheck()
                binding.scrollView.fullScroll(ScrollView.FOCUS_UP)
                binding.invalidateAll()
            } else {
                Toast.makeText(this.activity, "Select one of the actions to continue!", Toast.LENGTH_SHORT).show()
            }
        }

        Timber.d(MyApplication.ON_CREATE_VIEW_CALLED)

        return binding.root
    }

    private fun ending() {
        kayaRelationship = 0
        leonRelationship = 0
        when(selectedActionId) {
            0 -> this.activity!!.onBackPressed()
            1 -> currentScene = scenes[0]
        }
    }

    override fun onStart() {
        super.onStart()

        Timber.d(MyApplication.ON_START_CALLED)
    }

    override fun onResume() {
        super.onResume()

        Timber.d(MyApplication.ON_RESUME_CALLED)
    }

    override fun onPause() {
        super.onPause()

        Timber.d(MyApplication.ON_PAUSE_CALLED)
    }

    override fun onStop() {
        super.onStop()

        Timber.d(MyApplication.ON_STOP_CALLED)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Timber.d(MyApplication.ON_DESTROY_VIEW_CALLED)
    }


    override fun onDestroy() {
        super.onDestroy()

        Timber.d(MyApplication.ON_DESTROY_CALLED)
    }

    override fun onDetach() {
        super.onDetach()

        Timber.d(MyApplication.ON_DETACH_CALLED)
    }

}
