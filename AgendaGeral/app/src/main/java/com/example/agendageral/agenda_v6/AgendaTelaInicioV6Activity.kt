package com.example.agendageral.agenda_v6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.agendageral.R
import com.example.agendageral.agenda_v5.AgendaV5
import com.example.agendageral.agenda_v5.ContatoV5
import com.example.agendageral.databinding.ActivityAgendaTelaInicioV6Binding

class AgendaTelaInicioV6Activity : AppCompatActivity() {

    private lateinit var binding: ActivityAgendaTelaInicioV6Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendaTelaInicioV6Binding.inflate(layoutInflater)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerV6, ListaConatoFragmentV6())
            .commit()

        binding.bottomNavigationView3.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ic_home -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainerV6, ListaConatoFragmentV6())
                        .commit()
                    true
                }
                R.id.ic_ajustes -> {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerV6, AjustesFragmentV6())
                .commit()
            true
        }
                else ->

                    false
            }
        }
        Agenda_V6.listaContatos_V6.add(Contato_V6("Meliodads", "01"))
        Agenda_V6.listaContatos_V6.add(Contato_V6("Scanor", "02"))
        Agenda_V6.listaContatos_V6.add(Contato_V6("Ban", "03"))
        Agenda_V6.listaContatos_V6.add(Contato_V6("Monckei D. Luffy", "76"))
        Agenda_V6.listaContatos_V6.add(Contato_V6("Roronoa Zoro", "76"))
        Agenda_V6.listaContatos_V6.add(Contato_V6("Ussopp", "76"))
        Agenda_V6.listaContatos_V6.add(Contato_V6("Nami", "76"))
        Agenda_V6.listaContatos_V6.add(Contato_V6("Sanji", "76"))
        Agenda_V6.listaContatos_V6.add(Contato_V6("Robin", "76"))
        Agenda_V6.listaContatos_V6.add(Contato_V6("Chopper", "76"))
        Agenda_V6.listaContatos_V6.add(Contato_V6("Franklin", "76"))
        Agenda_V6.listaContatos_V6.add(Contato_V6("Shanks", "76"))
        Agenda_V6.listaContatos_V6.add(Contato_V6("Olhos de Falcão", "76"))
        Agenda_V6.listaContatos_V6.add(Contato_V6("Grap", "76"))
        Agenda_V6.listaContatos_V6.add(Contato_V6("Ace", "76"))
        Agenda_V6.listaContatos_V6.add(Contato_V6("Sabo", "76"))


        setContentView(binding.root)
    }

}
