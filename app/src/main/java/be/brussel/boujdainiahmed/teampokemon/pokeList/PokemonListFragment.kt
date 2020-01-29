package be.brussel.boujdainiahmed.teampokemon.pokeList


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import be.brussel.boujdainiahmed.teampokemon.R
import be.brussel.boujdainiahmed.teampokemon.database.DatabaseFragment
import be.brussel.boujdainiahmed.teampokemon.databinding.FragmentPokemonListBinding
import be.brussel.boujdainiahmed.teampokemon.databinding.GridViewItemBinding


class PokemonListFragment : Fragment() {

    private lateinit var viewModel: PokeViewModel
    private lateinit var binding: FragmentPokemonListBinding

    /*private val viewModel: PokeViewModel by lazy {
        ViewModelProviders.of(this).get(PokeViewModel::class.java)
    }*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_pokemon_list,
            container,
            false
        )

        val binding = FragmentPokemonListBinding.inflate(
            inflater
        )

       viewModel = ViewModelProviders.of(this).get(PokeViewModel::class.java)

        binding.lifecycleOwner = this

        binding.pokeviewModel = viewModel


        binding.photosGrid.adapter = PhotoPokemonAdapter(PhotoPokemonAdapter.OnClickListener {
            viewModel.displayPokemonTeam(it)
        })

/* WANNEER IK MIJN APP RUN KRIJG IK EEN WARNING MELDING DAT IK MIJN POKEVIEWMODEL NIET GEBRUIKT


       val application = requireNotNull(this.activity).application
        val dataSource = DatabaseFragment.getInstance(application).pokemonDAO
        val pokeViewModelFactory = PokeViewModelFactory(application,dataSource)
        val pokeViewModel =
            ViewModelProviders.of(this, pokeViewModelFactory).get(PokeViewModel::class.java)


        DETAILS TE KRIJGEN OVER MIJN POKEMON

        viewModel.navigateToSelectedPokemon.observe(this, Observer {
            if ( null != it) {
                this.findNavController().navigate(PokemonListFragmentDirections.actionPokemonListFragmentToTeamFragment(it))
                viewModel.displayPokemonTeamComplete()
            }
        })*/

        setHasOptionsMenu(true)
        return binding.root
    }

    }







