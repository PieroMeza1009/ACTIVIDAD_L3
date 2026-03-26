package com.PieroMeza.seguimiento_piero

import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SegundaActividad : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private val TAG = "SegundaActividad"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_actividad)

        progressBar = findViewById(R.id.progressBar)

        Thread {
            var progreso = 0

            while (progreso <= 100) {
                Thread.sleep(50)
                progreso++

                runOnUiThread {
                    progressBar.progress = progreso
                }
            }

            runOnUiThread {
                Toast.makeText(this, "Carga completa", Toast.LENGTH_SHORT).show()
            }

            Log.d(TAG, "Carga completa")
        }.start()
    }
}