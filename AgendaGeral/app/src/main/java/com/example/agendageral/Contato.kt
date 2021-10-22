package com.example.agendageral

class Contato(var nome: String, var telefone: Int) {
    override fun toString(): String {
        return "$nome $telefone"
    }
}