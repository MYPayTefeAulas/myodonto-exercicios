package com.example.agendageral.agenda_v4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agendageral.TelaDeInicioActivity
import com.example.agendageral.databinding.ActivityEditarContatov4Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class EditarContatoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarContatov4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditarContatov4Binding.inflate(layoutInflater)
        title = "Editar Contato"

        val indiceContatoAdapterV4 = intent.getIntExtra("indiceAtual",0)

        val nome: String = AgendaV4.listaCttV4[indiceContatoAdapterV4].nome
        val telefone : Int = AgendaV4.listaCttV4[indiceContatoAdapterV4].telefone

        binding.txtNomeEd.setText(nome)
        binding.txTelefoneEd.setText(telefone.toString())

        binding.btSalvarEd.setOnClickListener {
            AgendaV4.listaCttV4[indiceContatoAdapterV4].nome = binding.txtNomeEd.text.toString()
            AgendaV4.listaCttV4[indiceContatoAdapterV4].telefone = binding.txTelefoneEd.text.toString().toInt()

            Toast.makeText(this,"Contato Salvo!", Toast.LENGTH_SHORT).show()

            finish()
        }

        binding.btDeletar.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Deletar Contato")
                .setNegativeButton("Cancelar"){_,_ ->}
                .setMessage("Realmente deletar?")
                .setPositiveButton("Ok"){_,_ ->

                    AgendaV4.listaCttV4.removeAt(indiceContatoAdapterV4)
                    finish()
                }
                .show()


        }




        setContentView(binding.root)


    }
}