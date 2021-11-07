package com.example.agendageral.agenda_v4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.agendageral.R
import com.example.agendageral.databinding.ActivityTelaInicialAgendaV4Binding

class TelaInicialAgendaV4Activity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaInicialAgendaV4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaInicialAgendaV4Binding.inflate(layoutInflater)
        title = "Agenda V4"

    supportFragmentManager
        .beginTransaction()
        .replace(R.id.fragmentContainerV5, ListaContatoFragment())
        .commit()


        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainerV5, ListaContatoFragment())
                        .commit()
                    true
                }
                R.id.ic_ajustes -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainerV5, AjustesFragments())
                        .commit()
                    true
                }
                else ->
                    false
            }
        }
        setContentView(binding.root)

    }



}