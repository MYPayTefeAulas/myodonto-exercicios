package com.example.agendageral.agenda_v2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agendageral.databinding.ActivityTelaInicialV2Binding
import com.example.agendageral.databinding.ItemListaCttsBinding

class ContatoAdapterRecycleView(val listaContato_v2: MutableList<Contato_v2>) :
    RecyclerView.Adapter<ContatoAdapterRecycleView.ViewHolder>() {

    inner class ViewHolder(val binding: ItemListaCttsBinding) :
        RecyclerView.ViewHolder(binding.root)

// primeiro método (

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListaCttsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

// segundo método ( Esta função retornará o tamanho da lista que aceitamos como um argumento na classe Adapter.)

    override fun getItemCount(): Int {
        return listaContato_v2.size
    }
//terceiro método (Neste método, usaremos a holdervariável que aceitamos como um argumento
// para acessar os componentes da GUI usando vinculação. positionargumento nos ajudará a
// acessar o elemento na posição específica na lista).

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtNomeCtt.text = listaContato_v2[position].nome
        holder.binding.txtTelefoneCtt.text = listaContato_v2[position].telefone.toString()
    }
}