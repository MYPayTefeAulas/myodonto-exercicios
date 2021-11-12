package com.example.agendageral.agenda_v6

import android.content.Intent
import androidx.appcompat.widget.SearchView
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendageral.R
import com.example.agendageral.databinding.FragmentListaContatosV6Binding

class ListaConatoFragmentV6: Fragment(), SearchView.OnQueryTextListener {
    private var _binding: FragmentListaContatosV6Binding? = null
    private val binding get() = _binding!!
    private lateinit var adapterV6: ContatoAdapterV6


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaContatosV6Binding.inflate(inflater, container, false)

        adapterV6 = ContatoAdapterV6(mutableListOf(), ::onBtItemClick)





        binding.rvListaContatoV6.layoutManager = LinearLayoutManager(context)
        binding.rvListaContatoV6.adapter = adapterV6
        binding.rvListaContatoV6.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        carregarLista()
        binding.toolbarListaContatoV6.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.toolbarContatosBusca-> {
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


    override fun onQueryTextSubmit(newText: String?): Boolean {
        return onQueryTextSubmit(newText)
    }

    override fun onQueryTextChange(query: String?): Boolean {
        val quaryLowerCase = query.toString().lowercase()
        val listaFiltradaV6 = Agenda_V6.listaContatos_V6.filter { contatoAtual ->
            contatoAtual.nome.lowercase().contains(quaryLowerCase) ||
                    contatoAtual.telefone.lowercase().contains(quaryLowerCase)
        }

        adapterV6.swapData(listaFiltradaV6)
        return true
    }

    fun onBtItemClick(indiceLista: Int){
        val intent = Intent(context, EditarContatoV6Activity::class.java)
        intent.putExtra("indiceAtual", indiceLista)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
    carregarLista()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun carregarLista() {
        val config = requireActivity().getSharedPreferences("configuracoes", 0)
        val radioGroupOrdenacaoSelecionada_id =
            config.getInt("ordenacaoContatos", R.id.radioOrdenacaoInsercao)

        when (radioGroupOrdenacaoSelecionada_id) {
            R.id.radioOrdenacaoAZ -> {
                val listaOrdenada = Agenda_V6.listaContatos_V6.sortedBy { it.nome }
                adapterV6.swapData(listaOrdenada)
            }
            R.id.radioOrdenacaoZA -> {
                val listaOrdenada = Agenda_V6.listaContatos_V6.sortedByDescending { it.nome }
                adapterV6.swapData(listaOrdenada)
            }
            else -> {
                adapterV6.swapData(Agenda_V6.listaContatos_V6)
            }
        }
    }
}