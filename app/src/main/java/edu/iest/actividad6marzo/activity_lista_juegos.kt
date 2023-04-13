package edu.iest.actividad6marzo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.iest.actividad6marzo.adapters.VideojuegoAdapter
import edu.iest.actividad6marzo.models.FakerVideojuego


class activity_lista_juegos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_juegos)

        val juegos = FakerVideojuego().getVideogames()
        val recycler = findViewById<RecyclerView>(R.id.recyclerJuegos)
        val fab = findViewById<FloatingActionButton>(R.id.fabJuegos)

        // este se usa si nuestro layout fuera de grid
        val CANTIDAD_COLUMNAS = 2
        val administradorDeLayouts = LinearLayoutManager(this,
        LinearLayoutManager.VERTICAL, false)
        // LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false)

        recycler.layoutManager = administradorDeLayouts
        recycler.adapter = VideojuegoAdapter(juegos, this)

        fab.setOnClickListener{
            val i = Intent(this, shared_preferences::class.java)
            startActivity(i)
        }



    }
}