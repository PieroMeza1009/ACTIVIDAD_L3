package com.PieroMeza.seguimiento_piero

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "CicloVida"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate()")

        val btn = findViewById<Button>(R.id.btnMostrar)

        btn.setOnClickListener {
            val intent = Intent(this, SegundaActividad::class.java)
            startActivity(intent)
        }
    }

    override fun onStart()   { super.onStart(); Log.d(TAG, "onStart()") }
    override fun onRestart(){ super.onRestart(); Log.d(TAG, "onRestart()") }
    override fun onResume() { super.onResume(); Log.d(TAG, "onResume()") }
    override fun onPause()  { super.onPause(); Log.d(TAG, "onPause()") }
    override fun onStop()   { super.onStop(); Log.d(TAG, "onStop()") }
    override fun onDestroy(){ super.onDestroy(); Log.d(TAG, "onDestroy()") }
}