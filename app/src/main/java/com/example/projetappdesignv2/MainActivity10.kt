package com.example.projetappdesignv2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText


class MainActivity10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        val retouraccueil: ImageButton = findViewById(R.id.Retour_Accueil)
        retouraccueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val buttoninscription: Button = findViewById(R.id.button_inscription)
        buttoninscription.setOnClickListener {
            val intent = Intent(this, MainActivity11::class.java)
            startActivity(intent)
        }



        val usernameEditText = findViewById<TextInputEditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<TextInputEditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.Connexion)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Récupération du nom d'utilisateur depuis l'EditText et sauvegarde dans SharedPreferences
            val sharedPreferences = getSharedPreferences("MainActivity12", Context.MODE_PRIVATE)
            sharedPreferences.edit().putString("USERNAME", username).apply()

            //Récupérer le nom d'utilisateur depuis SharedPreferences
            val usernameFromPrefs = sharedPreferences.getString("USERNAME", "Utilisateur Inconnu")
            Log.d("MainActivity12", "Username: $usernameFromPrefs")

            if (validateUser(username, password)) {
                // Passer à la page suivante
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            } else {
                // Afficher un message d'erreur
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }


        }





    }

    private fun validateUser(username: String, password: String): Boolean {
        val dbHelper = UserDBHelper(this)
        return dbHelper.userExists(username, password)
    }


}



