package com.example.recumultimedia


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.recumultimedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val lista = mutableListOf<String>("Verde", "Rojo", "Amarillo")
        binding.b5.visibility = View.GONE
        Toast.makeText(this, "Selecciona un orden", Toast.LENGTH_LONG).show()
        var i = 0

        binding.b1.setOnClickListener {
            i = 0
            ordenarListaAlfabeticamente(lista)
        }

        binding.b2.setOnClickListener {
            i = 0
            ordenarListaPorLongitud(lista)
        }

        binding.b3.setOnClickListener {
            i = 0
            ordenarListaAleatoriamente(lista)
        }

        binding.b4.setOnClickListener {
            binding.b5.visibility = View.VISIBLE
            binding.b1.visibility = View.INVISIBLE
            binding.b2.visibility = View.INVISIBLE
            binding.b3.visibility = View.INVISIBLE
            binding.b4.visibility = View.INVISIBLE
        }


        binding.b5.setOnClickListener {
            if (i < lista.size) {
                binding.tv1.visibility = View.VISIBLE
                binding.tv1.text = lista[i]
                i++
            } else {
                Toast.makeText(this, "Reiniciamos el juego", Toast.LENGTH_LONG).show()
                binding.b5.visibility = View.INVISIBLE
                binding.b1.visibility = View.VISIBLE
                binding.b2.visibility = View.VISIBLE
                binding.b3.visibility = View.VISIBLE
                binding.b4.visibility = View.VISIBLE
                binding.tv1.visibility = View.INVISIBLE
            }

        }
    }

    fun ordenarListaPorLongitud(listaOrdenada: MutableList<String>): MutableList<String> {
        listaOrdenada.sortBy { it.length }
        return listaOrdenada
    }

    fun ordenarListaAlfabeticamente(listaOrdenada: MutableList<String>): MutableList<String> {
        listaOrdenada.sortBy { it }
        return listaOrdenada
    }

    fun ordenarListaAleatoriamente(listaOrdenada: MutableList<String>): MutableList<String> {
        listaOrdenada.sortBy { it.random() }
        return listaOrdenada
    }
}