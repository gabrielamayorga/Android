package com.example.appdozero1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.appdozero1.R
import com.example.appdozero1.model.Pessoa
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListaDePessoaFragment : Fragment() {

   /* private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.lista_de_pessoas, container, false)
        var  recycler = view.findViewById<RecyclerView>(R.id.list)
        var viewModel = ViewModelProvider(requireActivity()).get(PessoaViewModel::class.java)

        viewModel.listaDePessoas.observe(requireActivity(), { pessoas ->
            with(recycler){
                adapter = PessoaAdapter(pessoas)
            }
        })


        // Set the adapter
      /*  if (view is RecyclerView) {
            with(view) {
             *//*   layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }*//*
                *//*adapter = PessoaAdapter(DummyContent.ITEMS)*//*
            }
        }*/

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener{
            viewModel.pessoa.value = Pessoa()
            findNavController().navigate(R.id.action_lista_para_detalhes_pessoa)
        }
        return view
    }

  /*  companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ListaDePessoaFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }*/
}