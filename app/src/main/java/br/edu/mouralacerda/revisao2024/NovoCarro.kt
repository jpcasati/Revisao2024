package br.edu.mouralacerda.revisao2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NovoCarro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_carro)

        val botaoSalvar = findViewById<Button>(R.id.btnSalvarCarro)

        botaoSalvar.setOnClickListener {

            val marca = findViewById<EditText>(R.id.edtMarca).text.toString()
            val modelo = findViewById<EditText>(R.id.edtModelo).text.toString()
            val placa = findViewById<EditText>(R.id.edtPlaca).text.toString()
            val ano = findViewById<EditText>(R.id.edtAno).text.toString().toInt()

            val c = Carro(marca, modelo, placa, ano, null)

            Database.getInstance(this)!!.carroDAO().salvar(c)

            finish()

        }


    }
}