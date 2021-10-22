package com.example.agendageral

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.agendageral.databinding.ActivityMainBinding

class TelaInicialActivity : AppCompatActivity() {
lateinit var adapter: ArrayAdapter<Contato>
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        Agenda.listaContatos.add(Contato("Varlei",11111))
        Agenda.listaContatos.add(Contato("Milena",22222))
        Agenda.listaContatos.add(Contato("Narlah",33333))
        Agenda.listaContatos.add(Contato("Ivan",444444))
        Agenda.listaContatos.add(Contato("Ronei",55555))
        Agenda.listaContatos.add(Contato("Maria",6666666))
        Agenda.listaContatos.add(Contato("Priscila",77777))
        Agenda.listaContatos.add(Contato("Carlos",888888))
        Agenda.listaContatos.add(Contato("Jaqueline",99999))
        Agenda.listaContatos.add(Contato("Luís",12121))
        Agenda.listaContatos.add(Contato("Luiz",13131))
        Agenda.listaContatos.add(Contato("Raiane",232323))
        Agenda.listaContatos.add(Contato("Sabrina",78787))
        Agenda.listaContatos.add(Contato("Gabriel",64646))
        Agenda.listaContatos.add(Contato("Israel",252525))

         adapter = ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,Agenda.listaContatos)
        binding.txtListView.adapter = adapter
adapter.notifyDataSetChanged()
       binding.txtListView.setOnItemClickListener { adapterView, view, posicao, l ->
           var intent = Intent(this, EditarContatoActivity::class.java)
           intent.putExtra("indice", posicao)
           startActivity(intent)
       }

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}