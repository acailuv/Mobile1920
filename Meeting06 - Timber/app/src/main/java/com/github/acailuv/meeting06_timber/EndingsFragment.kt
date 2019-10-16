package com.github.acailuv.meeting06_timber

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.github.acailuv.meeting06_timber.databinding.FragmentEndingsBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 * Logging DONE!
 */
class EndingsFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Timber.d(MyApplication.ON_ATTACH_CALLED)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.d(MyApplication.ON_CREATE_CALLED)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEndingsBinding>(inflater,
            R.layout.fragment_endings, container, false)

        // Ending Buttons Listeners...
        binding.badEndingOneButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[7]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.badEndingTwoButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[10]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.badEndingThreeButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[29]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.badEndingThreeButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[34]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.normalEndingOneButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[30]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.normalEndingTwoButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[35]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.bestEndingButton.setOnClickListener {
            MyApplication.currentDisplayedEnding = MyApplication.scenes[37]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }

        // Enabling/disabling buttons
        if (MyApplication.badEnding1) binding.badEndingOneButton.isEnabled = true
        if (MyApplication.badEnding2) binding.badEndingTwoButton.isEnabled = true
        if (MyApplication.badEnding3) binding.badEndingThreeButton.isEnabled = true
        if (MyApplication.badEnding4) binding.badEndingFourButton.isEnabled = true
        if (MyApplication.normalEnding1) binding.normalEndingOneButton.isEnabled = true
        if (MyApplication.normalEnding2) binding.normalEndingTwoButton.isEnabled = true
        if (MyApplication.bestEnding) binding.bestEndingButton.isEnabled = true

        Timber.d(MyApplication.ON_CREATE_VIEW_CALLED)

        return binding.root
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
