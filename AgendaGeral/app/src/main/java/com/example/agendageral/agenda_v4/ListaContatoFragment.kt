package com.example.agendageral.agenda_v4

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendageral.databinding.FragmetListaCttsBinding

class ListaContatoFragment: Fragment() {

    private var _binding: FragmetListaCttsBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: ContatoAdapterV4


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmetListaCttsBinding.inflate(inflater, container, false)

        adapter = ContatoAdapterV4(mutableListOf(), ::onBtItemClick)

        AgendaV4.listaCttV4.add(ContatoV4("Felipe Soares",23))
        AgendaV4.listaCttV4.add(ContatoV4("Argel",23))
        AgendaV4.listaCttV4.add(ContatoV4("Gabriel",23))
        AgendaV4.listaCttV4.add(ContatoV4("Felipe Soares",23))
        AgendaV4.listaCttV4.add(ContatoV4("Felipe Soares",23))
        AgendaV4.listaCttV4.add(ContatoV4("Felipe Soares",23))
        AgendaV4.listaCttV4.add(ContatoV4("Felipe Soares",23))
        AgendaV4.listaCttV4.add(ContatoV4("Felipe Soares",23))
        AgendaV4.listaCttV4.add(ContatoV4("Felipe Soares",23))
        AgendaV4.listaCttV4.add(ContatoV4("Felipe Soares",23))
        AgendaV4.listaCttV4.add(ContatoV4("Felipe Soares",23))

        binding.rdTelainicialV4.layoutManager = LinearLayoutManager(context)
        binding.rdTelainicialV4.adapter = adapter

        binding.rdTelainicialV4.addItemDecoration(
            DividerItemDecoration(context,
                LinearLayoutManager.VERTICAL)
        )

        adapter.swapData(AgendaV4.listaCttV4)




        return binding.root
    }


    fun onBtItemClick(indiceListaV4: Int){
        val intent = Intent(context,EditarContatoActivity::class.java)
        intent.putExtra("indiceAtual", indiceListaV4)
        startActivity(intent)
        intent.putExtra("nome", AgendaV4.listaCttV4[indiceListaV4].nome )
        intent.putExtra("nome", AgendaV4.listaCttV4[indiceListaV4].telefone )

    }

    override fun onResume() {
        super.onResume()
        adapter.swapData(AgendaV4.listaCttV4)

    }

}