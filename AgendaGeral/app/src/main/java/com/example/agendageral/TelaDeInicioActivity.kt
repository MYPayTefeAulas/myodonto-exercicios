package com.example.agendageral

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.agendageral.agenda_v1.TelaInicialActivity
import com.example.agendageral.agenda_v3.AgendaV3Activity
import com.example.agendageral.agenda_v4.TelaInicialAgendaV4Activity
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

        setContentView(binding.root)
    }
}