package edu.iest.actividad6marzo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import edu.iest.actividad6marzo.R
import edu.iest.actividad6marzo.models.Videojuego

class VideojuegoAdapter(videojuegos: ArrayList<Videojuego>, contexto : Context) :
 RecyclerView.Adapter<VideojuegoAdapter.ContenedorDeVista> (){
    var innerVideojuegos: ArrayList<Videojuego> = videojuegos
    var innerContext: Context = contexto

    inner class ContenedorDeVista(view: View):
            RecyclerView.ViewHolder(view), View.OnClickListener {
             // aqui haremos el inflate del layout
                val tvNombre : TextView
                val tvPrecio : TextView
                val tvConsola : TextView
                val tvClasificacion : TextView
                val ivFoto : ImageView
                val bnComprar : Button

                init{
                     // Define click listener for the ViewHolder's View
                    tvNombre = view.findViewById(R.id.tvNombre)
                    tvPrecio = view.findViewById(R.id.tvPrecio)
                    tvConsola = view.findViewById(R.id.tvConsola)
                    tvClasificacion = view.findViewById(R.id.tvClasificacion)
                    ivFoto = view.findViewById(R.id.ivFoto)
                    bnComprar = view.findViewById(R.id.bnComprar)

                    bnComprar.setOnClickListener(this)
                }

                // al agregar la linea de arriba (clicklistener) el this nos permite implementar nuestro propio onClick (alt + intro), segunda opcion
                override fun onClick(p0: View?) {
                    // aqui ocupamos pasar el contexto que definimos arriba
                    val miSharedPreferences = innerContext.getSharedPreferences("PERSISTENCIA", AppCompatActivity.MODE_PRIVATE)
                    val edad = miSharedPreferences.getInt("edad", 4)

                    // absoluteAdapterPosition es la nueva forma de AdapterPosition
                    if(absoluteAdapterPosition >= 0) {
                        val videojuego: Videojuego = innerVideojuegos.get(absoluteAdapterPosition)
                        // asi se llama en nuestros arrays (no es como esta en nuestro layout)
                        if (edad <= 5 && (videojuego.clasificacion=="R" || videojuego.clasificacion == "T")) {
                            val toast = Toast.makeText(innerContext, "No puedes comprar", Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            val toast = Toast.makeText(innerContext, "Comprado", Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }

    // lo que hace es mostrar el archivo que esta en inflate y lo muestra en algun lugar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContenedorDeVista {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_game, parent, false)

        return ContenedorDeVista(view)
    }

    // cada vez que tenga que mostrar el elemento entra a esta funcion, aqui se puede poner la logica para cambiar informacion de dicho elemento
    // si no hacemos nada seria n veces el elemento con la informacion predeterminada
    override fun onBindViewHolder(holder: ContenedorDeVista, position: Int) {
        val videojuego: Videojuego = innerVideojuegos.get(position)

        // se puede cambiar todo lo que queramos
        holder.tvNombre.text = videojuego.nombre
        holder.tvConsola.text = videojuego.consola
        holder.tvClasificacion.text = videojuego.clasificacion
        holder.tvPrecio.text = videojuego.precio.toString()
        holder.ivFoto.setImageResource(videojuego.imagen)

        // aqui no regresamos nada porque si no se detiene la funcion
    }

    override fun getItemCount(): Int {
        return innerVideojuegos.size
    }
}