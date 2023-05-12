package com.example.laboratorio_08.data

import com.example.laboratorio_08.data.model.MovieModel

//model 01
val name = "Hilda and the Mountain King"
val category = "Animacion"
val description = "Luego de que Hilda se despierta en el cuerpo de un trol, debe usar su ingenio y coraje para volver a casa, converirse en humana y salvar la ciudad de Trolberg"
val qualification = "7.1"

//model 02
val name1 = "Spirited Away"
val category1 = "Animación"
val description1 = "Gracias a un descubrimiento, un grupo de científicos y exploradores, encabezados por Cooper, se embarcan en un viaje espacial para encontrar un lugar con las condiciones necesarias para reemplazar a la Tierra y comenzar una nueva vida allí."
val qualification1 = "7.8"

//model 03
val name2 = "Interstellar"
val category2 = "Sci Fi"
val description2 = "Gracias a un descubrimiento, un grupo de científicos y exploradores, encabezados por Cooper, se embarcan en un viaje espacial para encontrar un lugar con las condiciones necesarias para reemplazar a la Tierra y comenzar una nueva vida allí."
val qualification2 = "8.6"

var movies = mutableListOf<MovieModel>(
    MovieModel(name, category, description, qualification),
    MovieModel(name1, category1, description1, qualification1),
    MovieModel(name2, category2, description2, qualification2)

)