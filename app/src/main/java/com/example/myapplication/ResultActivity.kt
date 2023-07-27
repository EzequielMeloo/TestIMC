package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.view.SupportActionModeWrapper

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textView_result)
        val tvClassificacao = findViewById<TextView>(R.id.textView_Classificação)


        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        var classificação = ""

        if (result < 18.5f){
            classificação = "Abaixo do peso"
        }else if ( result >= 18.5f && result <= 24.9f ){
            classificação = "Normal"
        }else if (result >=25f && result <=29.9f){
            classificação ="Sobrepeso"
        }else if (result >=30f && result <=39.9f){
            classificação ="Obesidade"
        }else{
            classificação ="Obesidade Grave"
        }

        tvClassificacao.text =getString(R.string.mensagem_classificação,classificação)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}