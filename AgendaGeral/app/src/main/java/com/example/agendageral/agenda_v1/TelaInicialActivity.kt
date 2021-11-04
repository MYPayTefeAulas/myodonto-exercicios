package com.example.agendageral.agenda_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.agendageral.databinding.ActivityTelaInicialV1Binding

class TelaInicialActivity : AppCompatActivity() {

    lateinit var adapter: ArrayAdapter<Contato>

    private lateinit var binding: ActivityTelaInicialV1Binding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityTelaInicialV1Binding.inflate(layoutInflater)

        Agenda.listaContatos.add(Contato("Varlei", 11111))
        Agenda.listaContatos.add(Contato("Milena", 22222))
        Agenda.listaContatos.add(Contato("Narlah", 33333))
        Agenda.listaContatos.add(Contato("Ivan", 444444))
        Agenda.listaContatos.add(Contato("Ronei", 55555))
        Agenda.listaContatos.add(Contato("Maria", 6666666))
        Agenda.listaContatos.add(Contato("Priscila", 77777))
        Agenda.listaContatos.add(Contato("Carlos", 888888))
        Agenda.listaContatos.add(Contato("Jaqueline", 99999))
        Agenda.listaContatos.add(Contato("Luís", 12121))
        Agenda.listaContatos.add(Contato("Luiz", 13131))
        Agenda.listaContatos.add(Contato("Raiane", 232323))
        Agenda.listaContatos.add(Contato("Sabrina", 78787))
        Agenda.listaContatos.add(Contato("Gabriel", 64646))
        Agenda.listaContatos.add(Contato("Israel", 252525))


    adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, Agenda.listaContatos)

        binding.txtListView.adapter = adapter


        super.onCreate(savedInstanceState)
        setContentView(binding.root)
      Toast.makeText(this, "Bem vindo a sua Agenda!", Toast.LENGTH_LONG).show()
    }


}