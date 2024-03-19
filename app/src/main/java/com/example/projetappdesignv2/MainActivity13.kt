package com.example.projetappdesignv2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity13 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main13)

        val retourprofile: ImageButton = findViewById(R.id.Retour_Profile)
        retourprofile.setOnClickListener {
            val intent = Intent(this, MainActivity12::class.java)
            startActivity(intent)
        }

        val passwordLayout = findViewById<TextInputLayout>(R.id.passwordTextInputLayout)
        val confirmPasswordLayout = findViewById<TextInputLayout>(R.id.confirmPasswordTextInputLayout)
        val validateButton = findViewById<Button>(R.id.Bouton_Inscription)

        validateButton.setOnClickListener {
            val password = passwordLayout.editText?.text.toString()
            val confirmPassword = confirmPasswordLayout.editText?.text.toString()

            if (password == confirmPassword) {
                // Les mots de passe sont identiques
                val newPassword = password // Enregistrement du mot de passe
                val returnIntent = Intent()
                returnIntent.putExtra("newPassword", newPassword)
                setResult(RESULT_OK, returnIntent)
                finish()
            } else {
                // Les mots de passe ne sont pas identiques
                confirmPasswordLayout.error = "Passwords do not match" // Affichage du message d'erreur
                confirmPasswordLayout.editText?.setText("") // Efface le champ de confirmation du mot de passe
            }
        }
    }
}