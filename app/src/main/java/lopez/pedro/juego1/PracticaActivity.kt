package lopez.pedro.juego1

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.random.Random

class PracticaActivity : AppCompatActivity() {
    lateinit var musicaFondo:MediaPlayer
    lateinit var respuestaUsuario:EditText
    lateinit var btnRespuesta:Button
    lateinit var musicaRespuestaCorrecta:MediaPlayer
    lateinit var musicaRespuestaIncorrecta:MediaPlayer

    var numeroGenerado = 0
    var numeroUsuario = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practica)

        initiUI()
        musicaFondo = MediaPlayer.create(this, R.raw.bob)
        musicaRespuestaCorrecta = MediaPlayer.create(this, R.raw.correcto)
        musicaRespuestaIncorrecta = MediaPlayer.create(this, R.raw.incorrecto)
        reproduceMusica()
        generaNumero()

        btnRespuesta.setOnClickListener{
            val respuesta = respuestaUsuario.text.toString()
            if(respuesta.equals("")) {
                Toast.makeText(this, "Ingresa un valor", Toast.LENGTH_LONG).show()
                sonidoIncorrecto()
            }else{
                numeroUsuario = respuesta.toInt()
                if(numeroGenerado == numeroUsuario){
                    sonidoCorrecto()
                }else{
                    sonidoIncorrecto()
                    Toast.makeText(this,"El valor era $numeroGenerado",Toast.LENGTH_SHORT).show()
                }
                generaNumero()
            }

        }


    }

    override fun onStop() {
        super.onStop()
        musicaFondo.release()
        musicaRespuestaCorrecta.release()
        musicaRespuestaIncorrecta.release()
    }
    fun  reproduceMusica(){
        musicaFondo.isLooping = true
        musicaFondo.setVolume(50.0f,50.0f)
        musicaFondo.start() // no need to call prepare(); create() does that for yo
    }

    fun sonidoCorrecto(){
        musicaRespuestaCorrecta.start()
    }
    fun sonidoIncorrecto() {
        musicaRespuestaIncorrecta.start()
    }
    fun initiUI(){
        btnRespuesta = findViewById(R.id.btnVerificar)
        respuestaUsuario = findViewById(R.id.etNumero)
    }
    fun generaNumero(){
        numeroGenerado = Random.nextInt(1,10)
    }
}