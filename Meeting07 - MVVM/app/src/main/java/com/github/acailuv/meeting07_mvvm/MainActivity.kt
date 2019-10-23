package com.github.acailuv.meeting07_mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.github.acailuv.meeting07_mvvm.databinding.ActivityMainBinding
import timber.log.Timber

/** Logging DONE! **/

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
        drawerLayout = binding.drawerLayout
        val navController = this.findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
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

    override fun onRestart() {
        super.onRestart()

        Timber.d(MyApplication.ON_RESTART_CALLED)
    }

    override fun onDestroy() {
        super.onDestroy()

        Timber.d(MyApplication.ON_DESTROY_CALLED)
    }

}
