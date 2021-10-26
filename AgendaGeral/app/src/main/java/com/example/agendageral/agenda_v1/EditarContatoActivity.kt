package com.example.agendageral.agenda_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agendageral.databinding.ActivityEditarContatoBinding

class EditarContatoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditarContatoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditarContatoBinding.inflate(layoutInflater)

        var indice = intent.getIntExtra("indice", 0)

        binding.txtNomeCont.setText(Agenda.listaContatos[indice].nome)
        binding.txtTelefoneCont.setText(Agenda.listaContatos[indice].telefone.toString())
        binding.btSalvarCont.setOnClickListener {
            Agenda.listaContatos[indice].nome = binding.txtNomeCont.text.toString()
            Agenda.listaContatos[indice].telefone = binding.txtTelefoneCont.text.toString().toInt()

            //  A função: Toast.makeText(this, "Contato Salvo!!", Toast.LENGTH_SHORT).show() irá fazer com que apareça uma
            // mensagem após o contato ser salvo.

            Toast.makeText(this, "Contato Salvo!!", Toast.LENGTH_SHORT).show()

            finish()
        }

        super.onCreate(savedInstanceState)

        setContentView(binding.root)
    }
}