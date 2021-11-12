package com.example.agendageral.agenda_v6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agendageral.databinding.ItemListaContatoV6Binding


class ContatoAdapterV6(
    val listaContatoV6: MutableList<Contato_V6>,
    val onBtItemClick: (Int) -> Unit
) :
    RecyclerView.Adapter<ContatoAdapterV6.ViewHolder>() {

    inner class ViewHolder(val binding: ItemListaContatoV6Binding) :

        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListaContatoV6Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return listaContatoV6.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtNomeContatoV6.text = listaContatoV6[position].nome
        holder.binding.txtTelefoneContatoV6.text = listaContatoV6[position].telefone

        holder.binding.btEditarContatoV6.setOnClickListener {
            onBtItemClick(position)
        }
    }

    fun swapData(novaListaContatoV6: List<Contato_V6>){
        listaContatoV6.clear()
        listaContatoV6.addAll(novaListaContatoV6)
        notifyDataSetChanged()
    }

}