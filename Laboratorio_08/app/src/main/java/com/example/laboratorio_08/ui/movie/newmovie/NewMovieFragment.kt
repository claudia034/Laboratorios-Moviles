package com.example.laboratorio_08.ui.movie.newmovie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio_08.databinding.FragmentNewMovieBinding
import com.example.laboratorio_08.ui.movie.viewmodel.MovieViewModel


class NewMovieFragment : Fragment() {

    private lateinit var binding : FragmentNewMovieBinding

    private val movieViewModel: MovieViewModel by activityViewModels<MovieViewModel> {
        MovieViewModel.Factory
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieViewModel.SetNewMovieFragment()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentNewMovieBinding.inflate(inflater, container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observerStatus()
    }


    private fun setViewModel(){
        binding.viewmodel = movieViewModel
    }

    private fun observerStatus(){
        movieViewModel.status.observe(viewLifecycleOwner){
            when{
                it.equals(MovieViewModel.WRONG_INFORMATION)->{
                    Log.d("APP_TAG", it)
                    movieViewModel.clearStatus()
                }
                it.equals(MovieViewModel.MOVIE_CREATED)->{
                    Log.d("APP_TAG", it)
                    Log.d("APP_TAG", movieViewModel.getMovies().toString())

                    movieViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

}