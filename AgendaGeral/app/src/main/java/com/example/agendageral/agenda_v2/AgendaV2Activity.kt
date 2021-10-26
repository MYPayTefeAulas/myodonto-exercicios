package com.example.agendageral.agenda_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendageral.R
import com.example.agendageral.databinding.ActivityTelaInicialV1Binding
import com.example.agendageral.databinding.ActivityTelaInicialV2Binding

class AgendaV2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaInicialV2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaInicialV2Binding.inflate(layoutInflater)
        title = "Agenda V2"

        Agenda_V2.lintaDeContatos.add(Contato_v2("Luiz Felipe",1111))
        Agenda_V2.lintaDeContatos.add(Contato_v2("Gabriela lima",100000))
        Agenda_V2.lintaDeContatos.add(Contato_v2("Genival rocha",200000))
        Agenda_V2.lintaDeContatos.add(Contato_v2("Kassia rocha",300000))
        Agenda_V2.lintaDeContatos.add(Contato_v2("Maria caroline",400000))
        Agenda_V2.lintaDeContatos.add(Contato_v2("Luiz Inácio",5000000))
        Agenda_V2.lintaDeContatos.add(Contato_v2("Elisson pereira",600000))
        Agenda_V2.lintaDeContatos.add(Contato_v2("Paula Fernanda",700000))
        Agenda_V2.lintaDeContatos.add(Contato_v2("Ana Paula",820000))
        Agenda_V2.lintaDeContatos.add(Contato_v2("Alex",900000))
        Agenda_V2.lintaDeContatos.add(Contato_v2("Jaquelino",1112000))
        Agenda_V2.lintaDeContatos.add(Contato_v2("Bruno",25000000))
        Agenda_V2.lintaDeContatos.add(Contato_v2("Amora",52564))
        Agenda_V2.lintaDeContatos.add(Contato_v2("Emersson",521321))
        Agenda_V2.lintaDeContatos.add(Contato_v2("Maick",5654121))

        binding.rvTelaInicial.layoutManager = LinearLayoutManager(this)
        binding.rvTelaInicial.adapter = ContatoAdapterRecycleView(Agenda_V2.lintaDeContatos)
        binding.rvTelaInicial.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        setContentView(binding.root)
    }
}