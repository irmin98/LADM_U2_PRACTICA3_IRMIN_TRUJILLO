package mx.edu.ittepic.ladm_u2_practica3_irmin_trujillo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var dados = arrayOf(
        R.drawable.d1,
        R.drawable.d2,
        R.drawable.d3,
        R.drawable.d4,
        R.drawable.d5,
        R.drawable.d6
    )
    var sumaDados=0
    var lanzamiento=0
    var turno=1
    var tituloturno=1
    var ptsP1 = 0
    var ptsP2 = 0
    var ptsP3 = 0
    var ptsP4 = 0
    var ganador=ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        comenzar.setOnClickListener {

            while (turno<5){
                while (lanzamiento<5){
                    var hiloAsincrono = HiloAsincrono(this)
                    hiloAsincrono.execute(lanzamiento, lanzamiento, lanzamiento)
                    lanzamiento++
                }//whileLanzamiento
                turno++
                lanzamiento=1
            }//whileTurno


        }//seOnClickListener
    }//onCreate
    fun lanzarDados() {
        var dad1 = (0..5).random()
        var dad2 = (0..5).random()
        dado1.setImageResource(dados[dad1])
        dado2.setImageResource(dados[dad2])
        sumaDados = (dad1 + dad2) + 2

    }
    fun elegirGanador(){
        if(ganador[0]==ganador.max()){
            this.setTitle("JUEGO DE DADOS")
            AlertDialog.Builder(this).setTitle("GANADOR").setMessage("GANÓ JUGADOR 1 , FELICIDADES GANASTE ").show()
        }
        if(ganador[1]==ganador.max()){
            this.setTitle("JUEGO DE DADOS")
            AlertDialog.Builder(this).setTitle("GANADOR").setMessage("GANÓ JUGADOR 2 , FELICIDADES GANASTE ").show()
        }
        if(ganador[2]==ganador.max()){
            this.setTitle("JUEGO DE DADOS")
            AlertDialog.Builder(this).setTitle("GANADOR").setMessage("GANÓ JUGADOR 3 , FELICIDADES GANASTE ").show()
        }
        if(ganador[3]==ganador.max()){
            this.setTitle("JUEGO DE DADOS")
            AlertDialog.Builder(this).setTitle("GANADOR").setMessage("GANÓ JUGADOR 4 , FELICIDADES GANASTE ").show()
        }

    }


}