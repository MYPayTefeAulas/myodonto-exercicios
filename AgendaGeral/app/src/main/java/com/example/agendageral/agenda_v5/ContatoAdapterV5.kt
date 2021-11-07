package com.example.agendageral.agenda_v5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agendageral.databinding.ItemListaCttsv5Binding

 class ContatoAdapterV5(
    val listaContatoV5: MutableList<ContatoV5>,
    val onBtItemClick: (Int) -> Unit
) :
    RecyclerView.Adapter<ContatoAdapterV5.ViewHolder>() {

    inner class ViewHolder(val binding: ItemListaCttsv5Binding) : RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                ItemListaCttsv5Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun getItemCount(): Int {
            return listaContatoV5.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.binding.txtNomeV5.text = listaContatoV5[position].nome
            holder.binding.txtTelefoneV5.text = listaContatoV5[position].telefone.toString()

            holder.binding.btEditarV5.setOnClickListener {
                onBtItemClick(position)
            }
        }

     fun swapData(novaistacontatoV5: List<ContatoV5>) {
         listaContatoV5.clear()
         listaContatoV5.addAll(novaistacontatoV5)
         notifyDataSetChanged()
     }

 }