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

class AjustesFragmentV6: Fragment() {

    private var _binding: FragmentoAjustesV6Binding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentoAjustesV6Binding.inflate(inflater, container, false)

        val config = requireActivity().getSharedPreferences("configuracoes", 0)
        
        binding.radioGroupOrdenacao.setOnCheckedChangeListener { _, checkedId ->
            val editor = config.edit()
            editor.putInt("ordenacaoContatos", checkedId)
            editor.apply()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val config = requireActivity().getSharedPreferences("configuracoes", 0)

        val radioGroupOrdenacaoSelecionada_id = config.getInt("ordenacaoContatos", R.id.radioOrdenacaoInsercao)
        val radioGroupOrdenacaoSelecionada_view = requireView().findViewById<RadioButton>(radioGroupOrdenacaoSelecionada_id)

        radioGroupOrdenacaoSelecionada_view.isChecked = true



    }
}