package com.example.agendageral.agenda_v3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.agendageral.databinding.ActivityEditarContato3Binding

class EditarContato3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEditarContato3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditarContato3Binding.inflate(layoutInflater)
        title = "Editar Contato"

        val indiceContatoAdapter = intent.getIntExtra("indiceAtual",-1)


        val nome : String = Agenda_v3.listaContato_v3[indiceContatoAdapter].nome
        val telefone: Int = Agenda_v3.listaContato_v3[indiceContatoAdapter].telefone

        binding.txtnomeContt.setText(nome)
        binding.txttelefoneContt.setText(telefone.toString())

        binding.btSalvarCtt.setOnClickListener {
            Agenda_v3.listaContato_v3[indiceContatoAdapter].nome = binding.txtnomeContt.text.toString()
            Agenda_v3.listaContato_v3[indiceContatoAdapter].telefone = binding.txttelefoneContt.text.toString().toInt()

            Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show()

            finish()
        }


        setContentView(binding.root)
    }
}