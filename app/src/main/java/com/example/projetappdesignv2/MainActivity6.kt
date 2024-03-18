package com.example.projetappdesignv2

import android.annotation.SuppressLint
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

    private var counterValue = 1
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        // Récupérer la valeur des rectangles du panier
        val sharedPreferences = getSharedPreferences("Panier", MODE_PRIVATE)
        val rectanglesDansPanier = sharedPreferences.getInt("Rectangles", 0)


        // Logique pour afficher les rectangles en fonction du nombre enregistré
        val elementAAfficher: RelativeLayout = findViewById(R.id.rectangle)
        val elementAAfficher2: RelativeLayout = findViewById(R.id.rectangle2)



        elementAAfficher.visibility = if (rectanglesDansPanier > 0) View.VISIBLE else View.GONE




        // Vérifier si l'intent contient l'indicateur que le bouton a été cliqué
        val boutonClique = intent.getBooleanExtra("boutonClique", false)
        val boutonClique2 = intent.getBooleanExtra("boutonClique2", false)


        elementAAfficher2.visibility = if ( boutonClique2) View.VISIBLE else View.GONE






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
        val bouton_vers_page2 = findViewById<Button>(R.id.buttonGoToHome)
        bouton_vers_page2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}
