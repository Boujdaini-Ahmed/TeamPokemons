package be.brussel.boujdainiahmed.teampokemon.pokeList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.brussel.boujdainiahmed.teampokemon.database.PokemonDAO
import be.brussel.boujdainiahmed.teampokemon.pokeAPI.DexApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.*


class PokeViewModel( /*val dataBase : PokemonDAO, application: Application) : AndroidViewModel(application) */): ViewModel(
) {


    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _pokemons = MutableLiveData<List<Pokemon>>()

    val pokemons: LiveData<List<Pokemon>>
        get() = _pokemons

    private val _navigateToSelectedPokemon = MutableLiveData<Pokemon>()

    val navigateToSelectedPokemon: LiveData<Pokemon>
        get() = _navigateToSelectedPokemon


    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)



    init {
        getPokemons()
        //_status.value = "test"
    }


    private fun getPokemons() {
        coroutineScope.launch {

            var getPokemonDeferred = DexApi.retrofitService.getPokemon()
            try {
                var listResult = getPokemonDeferred.await()
                _status.value = "Succes: ${listResult.size} Pokemon catched"
                if (listResult.size > 0) {
                    _pokemons.value = listResult

                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }

        }
    }



    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun displayPokemonTeam(pokemon: Pokemon) {
        _navigateToSelectedPokemon.value = pokemon
    }

    fun displayPokemonTeamComplete() {
        _navigateToSelectedPokemon.value = null
    }
}





