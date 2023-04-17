package edu.iest.actividad6marzo.models

import edu.iest.actividad6marzo.R


class FakerVideojuego {

    fun getVideogames (): ArrayList<Videojuego> {
        var videogames : ArrayList<Videojuego>
        videogames = arrayListOf<Videojuego>()

        var videojuego = Videojuego(1,"Sackboy",700F,"PC", "E+", R.drawable.sackboy)
        /// N VECES

        videogames.add(videojuego)
        videogames.add(Videojuego(2, "Stray",700F,"PC", "T",R.drawable.stray))
        videogames.add(Videojuego(3, "Unpacking",700F,"Switch","E+", R.drawable.unpacking))
        videogames.add(Videojuego(4, "We Were Here",100F,"PC", "T", R.drawable.wewerehere))
        videogames.add(Videojuego(5, "Yoshi",1220F,"Switch", "E+", R.drawable.yoshi))
        videogames.add(Videojuego(6, "The Witcher",200F,"PC","R" , R.drawable.thewitcher))

        return videogames
    }

}