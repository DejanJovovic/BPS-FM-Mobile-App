package com.deksi.bpsfmmobileapp.home.quickActions.newGuest

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import com.deksi.bpsfmmobileapp.R
import com.deksi.bpsfmmobileapp.databinding.ActivityNewGuestBinding
import com.deksi.bpsfmmobileapp.home.quickActions.QuickActionActivity
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class NewGuestActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityNewGuestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewGuestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpListeners()
    }

    private fun setUpListeners() {
        val imageViewDatePicker = binding.imageViewDatePicker
        val editTextDate = binding.editTextExpectedDate
        val buttonCancel = binding.buttonCancel
        val buttonSave = binding.buttonSave
        val imageViewX = binding.imageViewX

        imageViewDatePicker.setOnClickListener {
            showDatePickerDialog(editTextDate)
        }

        imageViewX.setOnClickListener {
            val intent = Intent(this, QuickActionActivity::class.java)
            startActivity(intent)
        }

        buttonCancel.setOnClickListener {
            val intent = Intent(this, QuickActionActivity::class.java)
            startActivity(intent)
            finish()
        }

        buttonSave.setOnClickListener {
            Snackbar.make(buttonSave, "Successfully saved!", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun showDatePickerDialog(editText: EditText) {

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->
                // Handle the date selection and update the EditText
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                editText.setText(selectedDate)
            },
            year, month, day
        )

        datePickerDialog.show()


    }
}