package com.example.agendageral

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.agendageral.agenda_v1.TelaInicialActivity
import com.example.agendageral.agenda_v3.AgendaV3Activity
import com.example.agendageral.agenda_v4.TelaInicialAgendaV4Activity
import com.example.agendageral.agenda_v5.TelaInicioV5Activity
import com.example.agendageral.agenda_v6.AgendaTelaInicioV6Activity
import com.example.agendageral.databinding.ActivityTelaDeInicioBinding

class TelaDeInicioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaDeInicioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaDeInicioBinding.inflate(layoutInflater)

        binding.btVersao1.setOnClickListener {
            val intent = Intent(this, TelaInicialActivity::class.java)
            startActivity(intent)
        }
        binding.btVersao2.setOnClickListener {
            val intent = Intent(this, AgendaV3Activity::class.java)
            startActivity(intent)
        }
        binding.btVersao3.setOnClickListener {
            val intent = Intent(this, AgendaV3Activity::class.java)
            startActivity(intent)
        }
        binding.btVersao4.setOnClickListener {
            val intent = Intent(this, TelaInicialAgendaV4Activity::class.java)
            startActivity(intent)
        }
        binding.btVersao5.setOnClickListener {
            val intent = Intent(this, TelaInicioV5Activity::class.java)
            startActivity(intent)
        }
        binding.btAgendaV6.setOnClickListener {
            val intent = Intent(this, AgendaTelaInicioV6Activity::class.java)
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}