package com.curso.aulacalculadorimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {

    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textPeso = findViewById(R.id.text_peso)
        textAltura = findViewById(R.id.text_altura)
        textResultado = findViewById(R.id.text_resultado)

        val bundle = intent.extras
        if (bundle != null) {
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado $peso kg"
            textAltura.text = "Altura informada $altura m"

            val imc = peso / (altura * altura)

            val resultado = when {
                imc < 18.5 -> "Baixo"
                imc in 18.5..24.9 -> "Normal"
                imc in 25.0..29.9 -> "Sobrepeso"
                else -> "Obeso"
            }

            textResultado.text = resultado
        }
    }
}