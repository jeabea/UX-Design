package com.example.projetappdesignv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.content.Intent
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

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

        val usernameEditText = findViewById<TextInputEditText>(R.id.usernameEditText)
        val emailEditText = findViewById<TextInputEditText>(R.id.emailEditText)
        val passwordEditText = findViewById<TextInputEditText>(R.id.passwordEditText)
        val submitButton = findViewById<Button>(R.id.Bouton_Inscription)

        submitButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Vérifiez que les champs ne sont pas vides
            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                insertUserInDatabase(username, email, password)
                // Après l'insertion, retournez à MainActivity10
                val intent = Intent(this, MainActivity10::class.java)
                startActivity(intent)
            } else {
                // Affichez un message d'erreur si l'un des champs est vide
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun insertUserInDatabase(username: String, email: String, password: String) {
        val dbHelper = UserDBHelper(this)
        dbHelper.addUser(username, email, password)
        // Afficher un message de succès
        Toast.makeText(this, "User added successfully", Toast.LENGTH_SHORT).show()
    }
}
