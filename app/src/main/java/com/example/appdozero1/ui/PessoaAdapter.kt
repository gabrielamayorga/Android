package com.example.appdozero1.ui

import android.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.example.appdozero1.R
import com.example.appdozero1.model.Pessoa

class PessoaAdapter(
    private val actrivity: FragmentActivity,
    private val viewModel: PessoaViewModel,
    private val pessoas: List<Pessoa>
) : RecyclerView.Adapter<PessoaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pessoa, parent, false)
        return PessoaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        val pessoa = pessoas[position]
        holder.idPessoa.text = pessoa.id.toString()
        holder.nomePessoa.text = pessoa.nome

        holder.itemView.setOnClickListener { view ->
            viewModel.pessoa.value = pessoa
            view.findNavController().navigate(R.id.action_lista_para_detalhes_pessoa)
        }

        holder.itemView.setOnLongClickListener{view ->
            view?.let{
                AlertDialog.Builder(actrivity)
                    .setTitle("Atenção")
                    .setMessage("Deseja excluir a pessoa?")
                    .setPositiveButton("Sim") {
                        dialog, which ->
                        viewModel.excluirPessoa(pessoa.id)
                    }
                    .setNegativeButton("Não", null)
                    .show()
            }
            true
        }
    }

    override fun getItemCount(): Int = pessoas.size

  /*  inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.item_number)
        val contentView: TextView = view.findViewById(R.id.content)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }*/
}