package com.example.agendageral.agenda_v6
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.agendageral.R
import com.example.agendageral.databinding.ActivityEditarContatoV6Binding

class EditarContatoV6Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarContatoV6Binding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityEditarContatoV6Binding.inflate(layoutInflater)
        title = getString(R.string.editar_contato)

        val indiceContatoAdapterV6 = intent.getIntExtra("indiceAtual",0)
        val nome: String = Agenda_V6.listaContatos_V6[indiceContatoAdapterV6].nome
        val telefone : Int = Agenda_V6.listaContatos_V6[indiceContatoAdapterV6].telefone.toInt()

        binding.txtNomeSV6.setText(nome)
        binding.txtTelefoneSV6.setText(telefone.toString())

        binding.switchContatosFavaritosV6.isChecked = Agenda_V6.listaContatos_V6[indiceContatoAdapterV6].favorito
//        if(Agenda_V6.listaContatos_V6[indiceContatoAdapterV6].favorito) {
//            binding.switchContatosFavaritosV6.isChecked = true
//        }




        binding.btSalvarcontatoV6.setOnClickListener {
            Agenda_V6.listaContatos_V6[indiceContatoAdapterV6].nome = binding.txtNomeSV6.text.toString()
            Agenda_V6.listaContatos_V6[indiceContatoAdapterV6].telefone = binding.txtTelefoneSV6.text.toString()
            Toast.makeText(this, getString(R.string.contato_salvo), Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btDeletarV6.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle(getString(R.string.deletar_contato))
                .setMessage(getString(R.string.deseja_deletar_contato))
                .setNegativeButton(getString(R.string.cancelar), null)
                .setPositiveButton(R.string.deletar){ _, _ ->
                    Agenda_V6.listaContatos_V6.removeAt(indiceContatoAdapterV6)
                    Toast.makeText(this, getString(R.string.contato_removido), Toast.LENGTH_SHORT).show()
                    finish()
                }.show()

        }
        binding.switchContatosFavaritosV6.setOnCheckedChangeListener { _, isChecked ->
            Agenda_V6.listaContatos_V6[indiceContatoAdapterV6].favorito = isChecked
        }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}