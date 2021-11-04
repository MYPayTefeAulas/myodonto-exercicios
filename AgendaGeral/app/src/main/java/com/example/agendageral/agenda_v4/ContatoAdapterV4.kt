package com.example.agendageral.agenda_v4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agendageral.databinding.ItemListaCttsv4Binding

class ContatoAdapterV4(
    val listaContatoAdapterV4: MutableList<ContatoV4>,
    val onBtItemClick: (Int) -> Unit):
    RecyclerView.Adapter<ContatoAdapterV4.ViewHolder>() {

    inner class ViewHolder(val binding: ItemListaCttsv4Binding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListaCttsv4Binding.inflate(LayoutInflater.from(parent.context), parent,false))

    }

    override fun getItemCount(): Int {
        return listaContatoAdapterV4.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtNomeCttv4.text = listaContatoAdapterV4[position].nome
        holder.binding.txtTelefoneCttv4.text = listaContatoAdapterV4[position].telefone.toString()

        holder.binding.btEditarCtt.setOnClickListener {
            onBtItemClick(position)
        }

    }
    fun swapData(novaLIstaDeContato: List<ContatoV4>){
        listaContatoAdapterV4.clear()
        listaContatoAdapterV4.addAll(novaLIstaDeContato)
        notifyDataSetChanged()

    }
}