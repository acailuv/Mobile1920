package com.github.acailuv.lab02_activityandlogging

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Main2Activity : AppCompatActivity() {

    val TAG: String = "Main2Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.d(TAG, "onCreate() // Creating...")

        //Button Listener (Go to activity one)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
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
