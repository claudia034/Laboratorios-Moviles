package com.example.laboratorio_06.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio_06.MovieReviewerApplication
import com.example.laboratorio_06.data.model.MovieModel
import com.example.laboratorio_06.repositories.MovieRepository

class MovieViewModel (private val repository: MovieRepository): ViewModel() {
    val name = MutableLiveData("")
    val category = MutableLiveData("")
    val description = MutableLiveData("")
    val qualification = MutableLiveData("")
    val status = MutableLiveData("")

    fun getMovies () = repository.getMovies()

    private fun addMovies(movie: MovieModel) = repository.setMovies(movie)

    fun createMovie(){
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        val movie = MovieModel(
            name.value!!,
            category.value!!,
            description.value!!,
            qualification.value!!,
        )

        addMovies(movie)
        clearData()

        status.value = MOVIE_CREATED
    }

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }
        return true
    }

    private fun clearData(){
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }
    fun clearStatus(){
        status.value = INACTIVE
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val movieRepositoryApp = (this[APPLICATION_KEY] as MovieReviewerApplication).movieRepository
                MovieViewModel(movieRepositoryApp)
            }
        }

        const val MOVIE_CREATED = "Movie created"
        const val  WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}