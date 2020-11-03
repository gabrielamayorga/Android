package com.example.appdozero1.repository

import androidx.lifecycle.MutableLiveData
import com.example.appdozero1.model.Pessoa
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.item_pessoa.view.*

class PessoaRepository {

    var listaDePessoas = MutableLiveData<MutableList<Pessoa>>()

    private val db = FirebaseFirestore.getInstance()

    init {
        db.collection("pessoas")
            .get()
            .addOnCompleteListener { docs ->
                if(docs.isSuccessful){
                    var pessoas = mutableListOf<Pessoa>()
                    docs.result?.forEach { doc ->
                     val pessoa = doc.toObject(Pessoa::class.java)
                        if (pessoa != null){
                            pessoa.docId = doc.id
                            pessoas.add(pessoa)
                        }
                    }
                    listaDePessoas.value = pessoas
                }else{
                    listaDePessoas.value = mutableListOf()
                }
            }
        db.collection("pessoas")
            .addSnapshotListener{ snapshot, _ ->
              if(snapshot != null){
                  var pessoas = mutableListOf<Pessoa>()
                  snapshot.documents.forEach { doc ->
                      val pessoa = doc.toObject(Pessoa::class.java)
                      if (pessoa != null){
                          pessoa.docId = doc.id
                          pessoas.add(pessoa)
                      }
                  }
                  listaDePessoas.value = pessoas
              }
            }
    }


    fun salvarPessoa(pessoa : Pessoa) {

        if(pessoa.docId.isBlank()){
            var doc = db.collection("pessoas").document()
            pessoa.docId = doc.id
            doc.set(pessoa)
        }else{
            db.collection("pessoas")
                .document(pessoa.docId)
                .set(pessoa)
        }
    }

    fun excluirPessoa(docId : String){
        db.collection("pessoas")
            .document(docId)
            .delete()
    }
}