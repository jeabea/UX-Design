package com.example.projetappdesignv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val bouton_vers_burger = findViewById<Button>(R.id.button_transparent_burger )
        bouton_vers_burger.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val bouton_vers_pizza = findViewById<Button>(R.id.button_transparent_pizza )
        bouton_vers_pizza.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }
    }
}