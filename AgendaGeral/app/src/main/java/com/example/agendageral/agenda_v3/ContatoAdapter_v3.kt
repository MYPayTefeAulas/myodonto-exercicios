package com.example.agendageral.agenda_v3

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.agendageral.databinding.ItemListaCttsV3Binding

class ContatoAdapter_v3(
    val listaDeContato_v3: MutableList<Contato_v3>,
    val onBtItemClick: (Int) -> Unit):
    RecyclerView.Adapter<ContatoAdapter_v3.ViewHolder>() {

    inner class ViewHolder(val binding: ItemListaCttsV3Binding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListaCttsV3Binding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun getItemCount(): Int {
        return listaDeContato_v3.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtNomeListaCtts.text = listaDeContato_v3[position].nome
        holder.binding.txtTelefoneListaCtts.text = listaDeContato_v3[position].telefone.toString()

        holder.binding.btEditCott.setOnClickListener {
            onBtItemClick(position)
         }

        }


    fun swapData(novaListaContatos: List<Contato_v3>){
        listaDeContato_v3.clear()
        listaDeContato_v3.addAll(novaListaContatos)
        notifyDataSetChanged()
    }

}