package edu.iest.actividad6marzo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Video
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iest.actividad6marzo.adapters.VideojuegoAdapter
import edu.iest.actividad6marzo.models.FakerVideojuego

class activity_lista_juegos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_juegos)

        val juegos = FakerVideojuego().getVideogames()
        val recycler = findViewById<RecyclerView>(R.id.recyclerJuegos)

        // este se usa si nuestro layout fuera de grid
        val CANTIDAD_COLUMNAS = 2
        val administradorDeLayouts = LinearLayoutManager(this,
        LinearLayoutManager.VERTICAL, false)
        // LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false)

        recycler.layoutManager = administradorDeLayouts
        recycler.adapter = VideojuegoAdapter(juegos, this)



    }
}