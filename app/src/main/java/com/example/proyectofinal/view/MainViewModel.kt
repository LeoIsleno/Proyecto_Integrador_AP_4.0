package com.example.proyectofinal.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _world = MutableLiveData<Boolean>()
    val world: LiveData<Boolean> get() = _world

    //Inicializamos el valor en false
    init {
        _world.value = false
    }

    //Funciona para comparar las palabras
    fun compareWorlds(world1: String, world2: String): Boolean {
        return world1 == world2
    }

    //Funciona para llamar al viewModel y realizar la comparacion
    fun updateWorld(world1: String, world2: String) {
        viewModelScope.launch {
            val result = compareWorlds(world1, world2)
            _world.value = result
        }
    }
}
