package com.example.appdozero1.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.appdozero1.R
import com.example.appdozero1.model.Pessoa

class PessoaAdapter(
    private val values: List<Pessoa>
) : RecyclerView.Adapter<PessoaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pessoa, parent, false)
        return PessoaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        val pessoa = values[position]
        holder.idPessoa.text = pessoa.id.toString()
        holder.nomePessoa.text = pessoa.nome

        holder.itemView.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_lista_para_detalhes_pessoa)
        }
    }

    override fun getItemCount(): Int = values.size

  /*  inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.item_number)
        val contentView: TextView = view.findViewById(R.id.content)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }*/
}