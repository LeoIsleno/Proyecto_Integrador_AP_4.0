package com.example.proyectofinalap40.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.proyectofinal.databinding.ActivityMainBinding
import com.example.proyectofinal.view.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.world.observe(this) {
            Log.i("TEST_MVVM", "Empezamos a usar MVVM, parametro recibido: $it")
            if (it) {
                binding.textView.text = "Las palabras son iguales"
            } else {
                binding.textView.text = "Las NO palabras son iguales"
            }
            //Seteamos luego de comparar
            binding.et1.setText("")
            binding.et2.setText("")
        }

        binding.btnCompare.setOnClickListener {
            val word1 = binding.et1.text.toString()
            val word2 = binding.et2.text.toString()
            mainViewModel.updateWorld(word1, word2)
        }
    }
}




