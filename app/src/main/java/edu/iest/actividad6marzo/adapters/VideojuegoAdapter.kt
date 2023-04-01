package edu.iest.actividad6marzo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.iest.actividad6marzo.R
import edu.iest.actividad6marzo.models.Videojuego

class VideojuegoAdapter(videojuegos: ArrayList<Videojuego>, contexto : Context) :
 RecyclerView.Adapter<VideojuegoAdapter.ContenedorDeVista> (){
    var innerVideojuegos: ArrayList<Videojuego> = videojuegos
    var innerContext: Context = contexto

    inner class ContenedorDeVista(view: View):
            RecyclerView.ViewHolder(view){
             // aqui haremos el inflate del layout
                val tvNombre : TextView
                val tvPrecio : TextView
                val tvConsola : TextView
                val ivFoto : ImageView
                val bnComprar : Button

                init{
                     // Define click listener for the ViewHolder's View
                    tvNombre = view.findViewById(R.id.tvNombre)
                    tvPrecio = view.findViewById(R.id.tvPrecio)
                    tvConsola = view.findViewById(R.id.tvConsola)
                    ivFoto = view.findViewById(R.id.ivFoto)
                    bnComprar = view.findViewById(R.id.bnComprar)
                }
            }

    // lo que hace es mostrar el archivo que esta en inflate y lo muestra en algun lugar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContenedorDeVista {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_main2, parent, false)

        return ContenedorDeVista(view)
    }

    // cada vez que tenga que mostrar el elemento entra a esta funcion, aqui se puede poner la logica para cambiar informacion de dicho elemento
    // si no hacemos nada seria n veces el elemento con la informacion predeterminada
    override fun onBindViewHolder(holder: ContenedorDeVista, position: Int) {
        val videojuego: Videojuego = innerVideojuegos.get(position)

        // se puede cambiar todo lo que queramos
        holder.tvNombre.text = videojuego.nombre
        holder.tvConsola.text = videojuego.consola
        holder.tvPrecio.text = videojuego.precio.toString()
        holder.ivFoto.setImageResource(videojuego.imagen)

        // aqui no regresamos nada porque si no se detiene la funcion
    }

    override fun getItemCount(): Int {
        return innerVideojuegos.size
    }
}