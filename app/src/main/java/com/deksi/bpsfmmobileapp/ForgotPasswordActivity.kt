package com.deksi.bpsfmmobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deksi.bpsfmmobileapp.databinding.ActivityForgotPasswordBinding
import com.google.android.material.snackbar.Snackbar

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        setupListeners()
    }

    private fun setupListeners() {

        binding.buttonForgotPasswordSubmit.setOnClickListener {
            Snackbar.make(binding.buttonForgotPasswordSubmit, "Uspeh!", Snackbar.LENGTH_LONG).show()
        }

        binding.textViewBackToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}