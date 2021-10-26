package com.example.agendageral.agenda_v2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agendageral.databinding.ActivityTelaInicialV2Binding
import com.example.agendageral.databinding.ItemListaCttsBinding

class ContatoAdapterRecycleView(val listaContato_v2: MutableList<Contato_v2>): RecyclerView.Adapter<ContatoAdapterRecycleView.ViewHolder>() {

    inner class ViewHolder(val binding: ItemListaCttsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListaCttsBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun getItemCount(): Int {
        return listaContato_v2.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtNomeCtt.text = listaContato_v2[position].nome
        holder.binding.txtTelefoneCtt.text = listaContato_v2[position].telefone.toString()
    }
}