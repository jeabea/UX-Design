package com.example.projetappdesignv2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import android.widget.DatePicker
import android.app.DatePickerDialog
import java.util.*

class MainActivity12 : AppCompatActivity() {
    private val REQUEST_CODE_MAIN_13 = 13
    private lateinit var passwordEditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)

        val birthdayEditText = findViewById<TextInputEditText>(R.id.birthdayEditText)
        val birthdayLayout = findViewById<TextInputLayout>(R.id.birthdayTextInputLayout)

        birthdayLayout.setEndIconOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePicker(this)
            datePicker.init(year, month, dayOfMonth, null)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(selectedYear, selectedMonth, selectedDay)
                    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    val formattedDate = dateFormat.format(selectedDate.time)
                    birthdayEditText.setText(formattedDate)
                },
                year,
                month,
                dayOfMonth
            )

            datePickerDialog.show()
        }

        val phoneNumberEditText = findViewById<TextInputEditText>(R.id.phoneNumberEditText)
        val phoneNumberLayout = findViewById<TextInputLayout>(R.id.phoneNumberTextInputLayout)

        phoneNumberLayout.setEndIconOnClickListener {
            phoneNumberEditText.isEnabled = true
            phoneNumberEditText.requestFocus()
        }

        val emailEditText = findViewById<TextInputEditText>(R.id.emailEditText)
        val emailLayout = findViewById<TextInputLayout>(R.id.emailTextInputLayout)

        emailLayout.setEndIconOnClickListener {
            emailEditText.isEnabled = true
            emailEditText.requestFocus()
        }

        val passwordLayout = findViewById<TextInputLayout>(R.id.passwordTextInputLayout)

        passwordLayout.setEndIconOnClickListener {
            val intent = Intent(this, MainActivity13::class.java)
            startActivityForResult(intent, REQUEST_CODE_MAIN_13)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_MAIN_13 && resultCode == Activity.RESULT_OK) {
            val newPassword = data?.getStringExtra("newPassword")
            newPassword?.let {
                val passwordEditText = findViewById<TextInputEditText>(R.id.passwordEditText)
                passwordEditText.setText(it)
            }
        }
    }
}
