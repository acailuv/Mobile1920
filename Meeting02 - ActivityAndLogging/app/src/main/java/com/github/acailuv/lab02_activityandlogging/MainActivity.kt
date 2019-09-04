package com.github.acailuv.lab02_activityandlogging

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate() // Creating...")

        //Button Listener (Go to activity two)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val i = Intent(this, Main2Activity::class.java)
            startActivity(i)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() // Starting...")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart() // Restarting...")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() // Resuming...")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() // Pausing...")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() // Stopping...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() // Destroying...")
    }
}
