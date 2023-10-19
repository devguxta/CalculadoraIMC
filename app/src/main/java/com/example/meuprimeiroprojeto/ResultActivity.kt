package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textView_Result)
        val tvClassification = findViewById<TextView>(R.id.textview_Classification)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /* TABELA IMC
        Menor que 18,5          Abaixo do peso
        Entre 18,5 e 24,9       Normal
        Entre 25,0 e 29,9       Sobrepeso
        Entre 30,0 e 39,9       Obesidade
        Maior que 40,0          Obesidade Grave
         */

        val classificacao =if (result < 18.5f) {
            "Abaixo do peso "
        } else if (result in 18.5..24.9) {
            "Normal "
        } else if (result in 25f..29.9f) {
            "Sobrepeso "
        } else if (result in 30f..39.9f) {
            "Obesidade "
        } else {
            "Obesidade Grave "
        }
        tvClassification.text = getString(R.string.message_classification,classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}

