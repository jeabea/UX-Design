package com.example.projetappdesignv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.content.Intent

class MainActivity11 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)

        val retourconnexion: ImageButton = findViewById(R.id.Retour_Connexion)
        retourconnexion.setOnClickListener {
            val intent = Intent(this, MainActivity10::class.java)
            startActivity(intent)
        }
        val buttonconnexion: Button = findViewById(R.id.button_connexion)
        buttonconnexion.setOnClickListener {
            val intent = Intent(this, MainActivity10::class.java)
            startActivity(intent)
        }

        val inscription: Button = findViewById(R.id.Bouton_Inscription)
        inscription.setOnClickListener {
            val intent = Intent(this, MainActivity10::class.java)
            startActivity(intent)
        }
    }
}