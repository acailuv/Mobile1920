package com.github.acailuv.meeting05_lightborne


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.acailuv.meeting05_lightborne.databinding.FragmentEndingDisplayBinding

/**
 * A simple [Fragment] subclass.
 */
class EndingDisplay : Fragment() {

    val currentEnding: MyApplication.Scene = MyApplication.currentDisplayedEnding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEndingDisplayBinding>(inflater,
            R.layout.fragment_ending_display, container, false)

        binding.endingDisplay = this

        return binding.root
    }


}
