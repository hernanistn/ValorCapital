package com.example.valorcapital

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var txtSeekBar : TextView
    private lateinit var seekbar : SeekBar
    private lateinit var edtCapitalInicial : EditText
    private lateinit var edtTaxaDeJurosMensal : EditText
    private lateinit var btnCalc : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtSeekBar = findViewById<TextView>(R.id.txtSeekBar)
        seekbar =findViewById<SeekBar>(R.id.seekBar)
        txtSeekBar.setText(seekbar.progress.toString())
        btnCalc = findViewById<Button>(R.id.btnCalc)
        btnCalc.setOnClickListener({
            Toast.makeText(applicationContext, "Calculo: ${calcularJuros()}", Toast.LENGTH_LONG)
        })
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        txtSeekBar = findViewById<TextView>(R.id.txtSeekBar)
        seekbar =findViewById<SeekBar>(R.id.seekBar)
        txtSeekBar.setText(seekbar.progress.toString())
    }
    fun calcularJuros() : Double {
        edtCapitalInicial = findViewById(R.id.edtCapitalAtual)
        edtTaxaDeJurosMensal = findViewById(R.id.edtTaxaDeJurosMensal)
        seekbar =findViewById<SeekBar>(R.id.seekBar)
        return edtCapitalInicial.text.toString().toDouble()*Math.pow(1+edtTaxaDeJurosMensal.text.toString().toDouble()/100, seekbar.progress.toDouble())
    }
}
