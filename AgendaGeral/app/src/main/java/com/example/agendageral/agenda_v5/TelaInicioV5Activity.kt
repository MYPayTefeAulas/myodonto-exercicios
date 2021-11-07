package com.example.agendageral.agenda_v5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.agendageral.R
import com.example.agendageral.agenda_v4.AjustesFragments
import com.example.agendageral.databinding.ActivityTelaInicioV5Binding
import com.example.agendageral.databinding.ListaContatoV5Binding

class TelaInicioV5Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaInicioV5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaInicioV5Binding.inflate(layoutInflater)
        title = "Agenda V5"


 supportFragmentManager
     .beginTransaction()
     .replace(R.id.fragmentContainerV5, ListaContatoFragmentV5())
     .commit()
binding.bottomNavigationView2.setOnNavigationItemSelectedListener {

    when(it.itemId){
        R.id.ic_home -> {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerV5, ListaContatoFragmentV5())
                .commit()

            true
        }
        R.id.ic_ajustes ->{
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerV5, AjustesFragments())
                .commit()
            true

        }else ->{

            false
        }
    }
}
        setContentView(binding.root)
    }

}