package com.example.agendageral.agenda_v4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.agendageral.databinding.FragmentsAjustesBinding


class AjustesFragments: Fragment() {
    private var _binding: FragmentsAjustesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentsAjustesBinding.inflate(inflater, container,false)

        return binding.root
    }

}