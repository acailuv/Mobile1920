package com.github.acailuv.meeting07_mvvm.screens.howtoplay


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.acailuv.meeting07_mvvm.MyApplication
import com.github.acailuv.meeting07_mvvm.R
import com.github.acailuv.meeting07_mvvm.databinding.FragmentHowToPlayBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 * Logging DONE!
 */
class HowToPlay : Fragment() {

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
        val binding = DataBindingUtil.inflate<FragmentHowToPlayBinding>(inflater,
            R.layout.fragment_how_to_play, container, false)

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
