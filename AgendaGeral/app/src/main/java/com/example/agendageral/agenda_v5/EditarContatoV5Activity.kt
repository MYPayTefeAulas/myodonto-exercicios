package com.example.agendageral.agenda_v5

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.agendageral.databinding.ActivityEditarContatoV5Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class EditarContatoV5Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarContatoV5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditarContatoV5Binding.inflate(layoutInflater)
        title = "Editar Contato"


        val indiceContatoAdapterV5 = intent.getIntExtra("indiceAtual", -1)


        val nome: String = AgendaV5.listaContatoV5[indiceContatoAdapterV5].nome
        val telefone: String = AgendaV5.listaContatoV5[indiceContatoAdapterV5].telefone

        binding.txtEdittarNomeV5.setText(nome)
        binding.txtEditarTelefoneV5.setText(telefone.toString())

        binding.btSalvarCttV5.setOnClickListener {
            AgendaV5.listaContatoV5[indiceContatoAdapterV5].nome =
                binding.txtEdittarNomeV5.text.toString()
            AgendaV5.listaContatoV5[indiceContatoAdapterV5].telefone =
                binding.txtEditarTelefoneV5.text.toString()

            Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show()

            finish()
        }

        binding.btDeletarV5.setOnClickListener {
            val dialog = MaterialAlertDialogBuilder(this)

            dialog.setTitle("Deletar Contato")
            dialog.setMessage("Deseja deletar esse contato?")
            dialog.setNegativeButton("Cancelar!", null)
            dialog.setPositiveButton("Deletar!") { _, _ ->
                AgendaV5.listaContatoV5.removeAt(indiceContatoAdapterV5)
                Toast.makeText(this, "Contato deletado!", Toast.LENGTH_SHORT).show()
                finish()
            }
            dialog.show()
        }

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}