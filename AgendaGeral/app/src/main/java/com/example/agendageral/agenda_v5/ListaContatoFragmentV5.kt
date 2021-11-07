package com.example.agendageral.agenda_v5

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.CalendarContract.Attendees.query
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendageral.R
import com.example.agendageral.databinding.FragmentListaContatoV5Binding


class ListaContatoFragmentV5: Fragment(), SearchView.OnQueryTextListener {

    private var _binding: FragmentListaContatoV5Binding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ContatoAdapterV5


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaContatoV5Binding.inflate(inflater, container, false)

        adapter = ContatoAdapterV5(mutableListOf(), ::onBtItemClick)


        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("Luis", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("Maria Rossild", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))
        AgendaV5.listaContatoV5.add(ContatoV5("José Soares", "76"))


        binding.rvlistaContatosv5.layoutManager = LinearLayoutManager(context)
        binding.rvlistaContatosv5.adapter = adapter
        binding.rvlistaContatosv5.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )


        adapter.swapData(AgendaV5.listaContatoV5)

        binding.toolbarListaContato.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                 R.id.toolbarContatosBuscaV5-> {
                    val searchView = menuItem?.actionView as SearchView
                     searchView.queryHint = "Digite para pesquisar"
                     searchView.setOnQueryTextListener(this)
                    true
                }
                else -> false
            }
        }

        return binding.root
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Toast.makeText(context,"escrevi $newText", Toast.LENGTH_SHORT).show()
        return onQueryTextSubmit(newText)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {

        val quaryLowerCase = query.toString().lowercase()
        val listaFiltrada = AgendaV5.listaContatoV5.filter { contatoAtual ->

        contatoAtual.nome.lowercase().contains(quaryLowerCase) ||
            contatoAtual.telefone.lowercase().contains(quaryLowerCase)

        }
        adapter.swapData(listaFiltrada)
        return true
    }

    fun onBtItemClick(indiceListaV5: Int) {
        val intent = Intent(context, EditarContatoV5Activity::class.java)
        intent.putExtra("indiceAtual", indiceListaV5)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        adapter.swapData(AgendaV5.listaContatoV5)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




