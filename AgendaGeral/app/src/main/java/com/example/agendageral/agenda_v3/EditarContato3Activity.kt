package com.example.agendageral.agenda_v3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import com.example.agendageral.databinding.ActivityEditarContato3Binding
import com.example.agendageral.databinding.ActivityEditarContatoBinding

class EditarContato3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEditarContato3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditarContato3Binding.inflate(layoutInflater)

        val indiceContatoAdapter = intent.getIntExtra("indiceAtual",-1)


        val nome : String = Agenda_v3.listaContato_v3[indiceContatoAdapter].nome
        val telefone: Int = Agenda_v3.listaContato_v3[indiceContatoAdapter].telefone

        binding.txtnomeContt.setText(nome)
        binding.txttelefoneContt.setText(telefone.toString())

        binding.btSalvarCtt.setOnClickListener {
            Agenda_v3.listaContato_v3[indiceContatoAdapter].nome = binding.txtnomeContt.text.toString()
            Agenda_v3.listaContato_v3[indiceContatoAdapter].telefone = binding.txttelefoneContt.text.toString().toInt()

            finish()
        }


        setContentView(binding.root)
    }
}