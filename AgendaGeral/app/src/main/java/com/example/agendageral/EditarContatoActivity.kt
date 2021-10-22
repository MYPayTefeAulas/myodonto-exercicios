package com.example.agendageral

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agendageral.databinding.ActivityEditarContatoBinding

class EditarContatoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditarContatoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditarContatoBinding.inflate(layoutInflater)

    var indice = intent.getIntExtra("indice", -1)

        binding.txtNomeCont.setText(Agenda.listaContatos[indice].nome)
        binding.txtTelefoneCont.setText(Agenda.listaContatos[indice].telefone.toString())
        binding.btSalvarCont.setOnClickListener {
            Agenda.listaContatos[indice].nome = binding.txtNomeCont.text.toString()
            Agenda.listaContatos[indice].telefone = binding.txtTelefoneCont.text.toString().toInt()
            finish()
        }

        super.onCreate(savedInstanceState)

        setContentView(binding.root)
    }
}