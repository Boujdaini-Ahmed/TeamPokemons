package be.brussel.boujdainiahmed.teampokemon.team


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import be.brussel.boujdainiahmed.teampokemon.R
import be.brussel.boujdainiahmed.teampokemon.databinding.FragmentTeamBinding


class TeamFragment : Fragment() {

    private lateinit var teamViewModel: TeamViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding: FragmentTeamBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_team, container, false
        )

        return binding.root
    }
}


        /*OM MEER DETAILS TE KRIJGEN OVER MIJN POKEMON

        viewModel = ViewModelProviders.of(this).get(TeamViewModel::class.java)

        binding.setLifecycleOwner(this)

        binding.teamViewModel = viewModel


        //val pokemon = TeamFragmentArgs.fromBundle(arguments!!).selectedPokemon


        //val viewModelFactory = TeamViewModelFactory(pokemon, application)

        binding.teamViewModel = ViewModelProviders.of(
            this, viewModelFactory).get(TeamViewModel::class.java)


        return binding.root

    }


}
         */


