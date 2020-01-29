package be.brussel.boujdainiahmed.teampokemon.team

import android.app.Application
import android.view.Menu
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import be.brussel.boujdainiahmed.teampokemon.pokeAPI.DexApi
import be.brussel.boujdainiahmed.teampokemon.pokeList.Pokemon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.*


class TeamViewModel (pokemon : Pokemon, app: Application): AndroidViewModel(app) {


    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
    get() = _status


    private val _selectedPokemon = MutableLiveData<Pokemon>()
    val selectedPokemon : LiveData<Pokemon>
        get() = _selectedPokemon



    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    init {
        _selectedPokemon.value = pokemon
    }




}