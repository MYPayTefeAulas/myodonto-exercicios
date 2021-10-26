package com.example.agendageral.agenda_v1

data class Contato(var nome: String, var telefone: Int) {
    override fun toString(): String {
        return "$nome $telefone"
    }
}