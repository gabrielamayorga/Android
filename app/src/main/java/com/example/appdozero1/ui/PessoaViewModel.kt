package com.example.appdozero1.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.example.appdozero1.db.Banco
import com.example.appdozero1.model.Pessoa
import com.example.appdozero1.repository.PessoaRepository
import kotlinx.coroutines.launch

class PessoaViewModel(app : Application) : AndroidViewModel(app) {

    var pessoa = MutableLiveData<Pessoa>()
    var repository = PessoaRepository()
    var listaDePessoas = repository.listaDePessoas

 /*   fun salvarPessoa(pessoa : Pessoa) = viewModelScope.launch {

        if(pessoa.id == 0){
            pessoaDao.inserir(pessoa)
        }else{
            pessoaDao.atualizar(pessoa)
        }
    }

    fun excluirPessoa(id : Int) = viewModelScope.launch {
        pessoaDao.apagar(id)
    }*/
}