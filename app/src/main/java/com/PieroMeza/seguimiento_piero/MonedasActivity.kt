package com.PieroMeza.seguimiento_piero

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MonedasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monedas)

        val etMonto = findViewById<EditText>(R.id.etMonto)
        val spinner = findViewById<Spinner>(R.id.spinnerMonedas)
        val btnConvertir = findViewById<Button>(R.id.btnConvertir)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        val monedas = arrayOf("Dólar", "Euro", "Yen", "Peso Mexicano")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, monedas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        btnConvertir.setOnClickListener {
            val montoTexto = etMonto.text.toString()

            if (montoTexto.isEmpty()) {
                Toast.makeText(this, "Ingrese un monto", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val monto = montoTexto.toDouble()
            val monedaSeleccionada = spinner.selectedItem.toString()

            val resultado = when (monedaSeleccionada) {
                "Dólar" -> monto * 0.27
                "Euro" -> monto * 0.25
                "Yen" -> monto * 40.50
                "Peso Mexicano" -> monto * 4.60
                else -> 0.0
            }

            txtResultado.text = "Resultado: %.2f %s".format(resultado, monedaSeleccionada)
        }
    }
}