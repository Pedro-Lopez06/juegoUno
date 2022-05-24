package ruiz.emmanuel.juego1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
   lateinit var btnJugar:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnJugar = findViewById(R.id.button_play)
        btnJugar.setOnClickListener {
        }

    }
}