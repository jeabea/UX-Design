package com.example.projetappdesignv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}
