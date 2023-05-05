package com.example.laboratorio_06.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio_06.R
import com.example.laboratorio_06.data.adapter.MovieAdapter
import com.example.laboratorio_06.databinding.FragmentBillBoardBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class BillBoardFragment : Fragment() {


    private lateinit var buttonFragmentNewMovie: FloatingActionButton
    private lateinit var recyclerViewMovies: RecyclerView

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

     private lateinit var binding: FragmentBillBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding  = FragmentBillBoardBinding.inflate(inflater, container, false)
        return binding.root
    }





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        listeners()

        val adapter = MovieAdapter()
        adapter.setData(movieViewModel.getMovies())
        //adapter.setData(MovieRepository(movies).getMovies())

        recyclerViewMovies.adapter = adapter
        recyclerViewMovies.layoutManager = LinearLayoutManager(context)
    }

    private fun bind(){
        //cardViewFragmentStarWars = view?.findViewById(R.id.card_view_star_wars) as CardView
        buttonFragmentNewMovie = view?.findViewById(R.id.btn_link_new_movie) as FloatingActionButton
        recyclerViewMovies = view?.findViewById(R.id.movies_recycle_view) as RecyclerView
    }

    private fun listeners(){
        buttonFragmentNewMovie.setOnClickListener{
            it.findNavController().navigate(R.id.action_billBoardFragment_to_newMovieFragment)
        }
    }
}

