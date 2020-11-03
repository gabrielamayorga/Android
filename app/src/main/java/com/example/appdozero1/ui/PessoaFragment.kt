package com.example.appdozero1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.appdozero1.R
import com.example.appdozero1.R.id.frameLayout
import com.example.appdozero1.model.Pessoa
import kotlinx.android.synthetic.main.pessoa_fragment.*

class PessoaFragment : Fragment() {

    private lateinit var viewModel: PessoaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.pessoa_fragment, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(PessoaViewModel::class.java)

        viewModel.pessoa.observe(viewLifecycleOwner, { pessoa ->

            txtNome.setText(pessoa.nome)
            txtCpf.setText(pessoa.cpf)
            txtAltura.setText(pessoa.altura.toString())
            txtFoto.setText(pessoa.foto)

            view.findViewById<Button>(R.id.btnSalvar).setOnClickListener {
                var pessoa = Pessoa(
                    docId = pessoa.docId,
                    nome = txtNome.text.toString(),
                    cpf = txtCpf.text.toString(),
                    foto = txtFoto.text.toString(),
                    altura = txtAltura.text.toString().toInt()
                )
                viewModel.repository.salvarPessoa(pessoa)
                findNavController().navigateUp()
            }

        })
        return view
    }

    /*   private lateinit var viewModel: PessoaViewModel

       override fun onCreateView(
           inflater: LayoutInflater, container: ViewGroup?,
           savedInstanceState: Bundle?
       ): View? {
           var view = inflater.inflate(R.layout.pessoa_fragment, container, false)
          *//* viewModel = ViewModelProvider(this).get(PessoaViewModel::class.java)*//*
        viewModel = ViewModelProvider(requireActivity()).get(PessoaViewModel::class.java)

       *//* view.findViewById<Button>(R.id.btnSalvar).setOnClickListener{ findNavController().navigateUp()}*//*

        viewModel.pessoa.observe(viewLifecycleOwner, { pessoa ->
            txtNome.setText(pessoa.nome)
            txtCpf.setText(pessoa.cpf)
            txtAltura.setText(pessoa.altura.toString())
        })

            view.findViewById<Button>(R.id.btnSalvar).setOnClickListener{
                val nome = txtNome.text.toString()
                val cpf = txtCpf.text.toString()
                val altura = txtAltura.text.toString().toDouble()

                viewModel.salvarPessoa(Pessoa(id = pessoa.id, nome = nome, cpf = cpf, altura = altura))

                findNavController().navigateUp()
            }

        return view
    }*/

}