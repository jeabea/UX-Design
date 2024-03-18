package com.example.projetappdesignv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView




class MainActivity3 : AppCompatActivity() {

    private var counterValue = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val textViewCounter: TextView = findViewById(R.id.textViewCounter)

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
        val buttonGoToNextPage: Button = findViewById(R.id.buttonGoToNextPage)
        buttonGoToNextPage.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java).apply {
                putExtra("compteurValue", counterValue)
                putExtra("boutonClique", true)
                putExtra("boutonClique2", false)
            val sharedPreferences = getSharedPreferences("Panier", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val rectanglesDansPanier = sharedPreferences.getInt("Rectangles", 0)
            editor.putInt("Rectangles", rectanglesDansPanier + 1)
            editor.apply()

            }
            startActivity(intent)
        }

        val bouton_vers_page = findViewById<Button>(R.id.buttonGoToBeforePage)
        bouton_vers_page.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}

