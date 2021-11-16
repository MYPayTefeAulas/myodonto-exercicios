package com.example.agendageral.agenda_v6

import android.os.Bundle
import android.telephony.RadioAccessSpecifier
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.agendageral.R
import com.example.agendageral.databinding.FragmentAjustesV5Binding
import com.example.agendageral.databinding.FragmentAjustesV6Binding
import com.example.agendageral.databinding.FragmentoAjustesV6Binding
import com.example.agendageral.databinding.FragmentsAjustesBinding
import com.example.agendageral.enums.TipoOrdenacao

class AjustesFragmentV6: Fragment() {

    private var _binding: FragmentoAjustesV6Binding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentoAjustesV6Binding.inflate(inflater, container, false)
        val view = binding.root
        val config = requireActivity().getSharedPreferences("configuracoes", 0)

        val tipoOrdenacaoSelecionada_str = config.getString(
            "TipoOrdenacaoContatos",
            TipoOrdenacao.ALFABETICA_AZ.toString()
        )
        val tipoOrdenacao: TipoOrdenacao = TipoOrdenacao.valueOf(tipoOrdenacaoSelecionada_str!!)

        when(tipoOrdenacao){
            TipoOrdenacao.ALFABETICA_AZ -> binding.radioOrdenacaoAZ.isChecked = true
            TipoOrdenacao.ALFABETICA_ZA -> binding.radioOrdenacaoZA.isChecked = true
            TipoOrdenacao.ORDEM_INSERCAO-> binding.radioOrdenacaoInsercao.isChecked = true
        }


        binding.radioGroupOrdenacao.setOnCheckedChangeListener { _, checkedId ->
            val novoTipoOrdenacao = when(checkedId){
                binding.radioOrdenacaoAZ.id ->  TipoOrdenacao.ALFABETICA_AZ.toString()
                binding.radioOrdenacaoZA.id ->  TipoOrdenacao.ALFABETICA_ZA.toString()
                binding.radioOrdenacaoInsercao.id -> TipoOrdenacao.ORDEM_INSERCAO.toString()
                else ->  TipoOrdenacao.ALFABETICA_AZ.toString()
            }
            val editor = config.edit()
            editor.putString("TipoOrdenacaoContatos", novoTipoOrdenacao)
            editor.apply()

        }

        return view
    }
}