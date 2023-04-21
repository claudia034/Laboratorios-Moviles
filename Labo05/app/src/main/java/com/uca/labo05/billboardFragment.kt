package com.uca.labo05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton


class billboardFragment : Fragment() {

    private lateinit var buttonNewMovieFragment: FloatingActionButton
    private lateinit var cardViewFragmentMovie: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        buttonNewMovieFragment.setOnClickListener{
            it.findNavController().navigate((R.id.action_billboardFragment6_to_newMovieFragment2))
        }
        listeners()
    }


    private fun bind(){
        cardViewFragmentMovie = view?.findViewById(R.id.card_view_movie1_sw) as CardView
        buttonNewMovieFragment = view?.findViewById(R.id.button_add_new_movie) as FloatingActionButton
    }

    private fun listeners(){
        cardViewFragmentMovie.setOnClickListener{
            it.findNavController().navigate((R.id.action_billboardFragment6_to_movieFragment))
        }
        buttonNewMovieFragment.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment6_to_newMovieFragment2)
        }

    }


}