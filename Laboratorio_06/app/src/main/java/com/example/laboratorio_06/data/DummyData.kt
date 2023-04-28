package com.example.laboratorio_06.data.model

//model 01
val name = "Super Mario"
val category = "Animacion"
val description = "Un fontanero llamado Mario viaja por un laberinto subterráneo con su hermano, Luigi, intentando salvar a una princesa capturada."
val qualification = "7.5"

//model 02
val name1 = "Llegaron de noche"
val category1 = "Historia"
val description1 = "La historia de Lucía, la única testigo en la matanza de los jesuitas en El Salvador el 16 de noviembre de 1989. El Gobierno culpabilizó a la guerrilla del FMLN, pero Lucía negó todo lo que declararon las autoridades."
val qualification1 = "7.8"

//model 03
val name2 = "John Wick"
val category2 = "Accion"
val description2 = "El marqués Vincent de Gramont pretende matar a John Wick para afianzar su poder en la Orden Suprema. Sin embargo, John tratará de adelantarse a cada uno de sus movimientos hasta lograr enfrentarse cara a cara con su peor enemigo."
val qualification2 = "9.5"

var movies = mutableListOf<MovieModel>(
    MovieModel(name, category, description, qualification),
    MovieModel(name1, category1, description1, qualification1),
    MovieModel(name2, category2, description2, qualification2)

)