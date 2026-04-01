package com.PieroMeza.seguimiento_piero

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CargaActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var txtCargando: TextView
    private val TAG = "CargaActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carga)

        progressBar = findViewById(R.id.progressBarCarga)
        txtCargando = findViewById(R.id.txtCargando)

        val destino = intent.getStringExtra("destino")

        Thread {
            var progreso = 0

            while (progreso <= 100) {
                Thread.sleep(20)
                progreso++

                runOnUiThread {
                    progressBar.progress = progreso
                    txtCargando.text = "Cargando... $progreso%"
                }
            }

            runOnUiThread {
                txtCargando.text = "Carga completa"
                Toast.makeText(this, "Carga completa", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Carga completa")

                val intentDestino = when (destino) {
                    "segunda" -> Intent(this, SegundaActividad::class.java)
                    "monedas" -> Intent(this, MonedasActivity::class.java)
                    "drawer" -> Intent(this, DrawerActivity::class.java)
                    else -> Intent(this, MainActivity::class.java)
                }

                startActivity(intentDestino)
                finish()
            }
        }.start()
    }
}