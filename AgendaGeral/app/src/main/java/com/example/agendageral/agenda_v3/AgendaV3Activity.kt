package com.example.agendageral.agenda_v3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendageral.databinding.ActivityAgendaV3Binding

class AgendaV3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityAgendaV3Binding

    private lateinit var adapter: ContatoAdapter_v3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendaV3Binding.inflate(layoutInflater)
        adapter = ContatoAdapter_v3(mutableListOf(), ::onBtItemClick)

        Agenda_v3.listaContato_v3.add(Contato_v3("Luiz Soares", 65656))
        Agenda_v3.listaContato_v3.add(Contato_v3("Luiz Soares", 65656))
        Agenda_v3.listaContato_v3.add(Contato_v3("Luiz Soares", 65656))
        Agenda_v3.listaContato_v3.add(Contato_v3("Luiz Soares", 65656))
        Agenda_v3.listaContato_v3.add(Contato_v3("Luiz Soares", 65656))





        binding.rvTelaInicialV3.layoutManager = LinearLayoutManager(this)
        binding.rvTelaInicialV3.adapter = adapter
        binding.rvTelaInicialV3.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        title = "Agenda V3"

        adapter.swapData(Agenda_v3.listaContato_v3)


        setContentView(binding.root)
    }
    fun onBtItemClick(indiceLista: Int){
        val intent = Intent(this, EditarContato3Activity ::class.java)
        intent.putExtra("indiceAtual", indiceLista)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        adapter.swapData(Agenda_v3.listaContato_v3)
    }
}