package br.edu.mouralacerda.revisao2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoNovoCarro = findViewById<FloatingActionButton>(R.id.btnNovoCarro)

        botaoNovoCarro.setOnClickListener {
            val i = Intent(this, NovoCarro::class.java)
            startActivity(i)
        }

    }

    override fun onResume() {
        super.onResume()

        atualizarLista()

    }

    private fun atualizarLista() {

        val listaTela = findViewById<ListView>(R.id.lstCarro)

        val listaBD = Database.getInstance(this)!!.carroDAO().listar()

        val listaAdaptada = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaBD)

        listaTela.adapter = listaAdaptada

    }
}