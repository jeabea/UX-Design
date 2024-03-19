package com.example.projetappdesignv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val bouton_vers_pizza = findViewById<Button>(R.id.button_transparent_pizza)
        bouton_vers_pizza.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }

        val bouton_vers_sandwich = findViewById<Button>(R.id.button_transparent_sandwich)
        bouton_vers_sandwich.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }
        val bouton_vers_chickenburger = findViewById<Button>(R.id.button_transparent_chickenburger)
        bouton_vers_chickenburger.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
        val bouton_vers_cheseburger = findViewById<Button>(R.id.button_transparent_cheseburger)
        bouton_vers_cheseburger.setOnClickListener {
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }
        val buttonprofile = findViewById<Button>(R.id.button_profile )
        buttonprofile.setOnClickListener {
            val intent = Intent(this, MainActivity12::class.java)
            startActivity(intent)
        }
    }
}



