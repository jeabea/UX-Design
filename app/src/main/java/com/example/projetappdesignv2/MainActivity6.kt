package com.example.projetappdesignv2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.view.View
import android.widget.Button


class MainActivity6 : AppCompatActivity() {

    private var counterValue = 1 // Initialiser avec une valeur par défaut
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        // Vérifier si l'intent contient l'indicateur que le bouton a été cliqué
        val boutonClique = intent.getBooleanExtra("boutonClique", false)

        val elementAAfficher: RelativeLayout = findViewById(R.id.rectangle)

        if (boutonClique) {
            // Le bouton a été cliqué dans MainActivity3, afficher les éléments
            elementAAfficher.visibility = View.VISIBLE
        } else {
            // Le bouton n'a pas été cliqué, masquer ou ajuster les éléments comme nécessaire
            elementAAfficher.visibility = View.GONE
        }
        // Vérifier si l'intent contient l'indicateur que le bouton a été cliqué
        val boutonClique2 = intent.getBooleanExtra("boutonClique2", false)

        val elementAAfficher2: RelativeLayout = findViewById(R.id.rectangle2)

        if (boutonClique2) {
            // Le bouton a été cliqué dans MainActivity3, afficher les éléments
            elementAAfficher2.visibility = View.VISIBLE
        } else {
            // Le bouton n'a pas été cliqué, masquer ou ajuster les éléments comme nécessaire
            elementAAfficher2.visibility = View.GONE
        }



        counterValue = intent.getIntExtra("compteurValue", 1) // Récupérer la valeur du compteur

        val textViewCounter: TextView = findViewById(R.id.textViewCounter)
        textViewCounter.text = counterValue.toString()

        val buttonPlus: ImageButton = findViewById(R.id.my_round_button2)
        buttonPlus.setOnClickListener {
            counterValue++
            textViewCounter.text = counterValue.toString()
        }

        val buttonMinus: ImageButton = findViewById(R.id.my_round_button)
        buttonMinus.setOnClickListener {
            if (counterValue > 1) {
                counterValue--
                textViewCounter.text = counterValue.toString()
            }
        }
        val bouton_vers_page = findViewById<Button>(R.id.buttonGoToBeforePage3)
        bouton_vers_page.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}
