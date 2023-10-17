package com.deksi.bpsfmmobileapp.password

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deksi.bpsfmmobileapp.databinding.ActivityResetPasswordBinding
import com.deksi.bpsfmmobileapp.login.LoginActivity
import com.google.android.material.snackbar.Snackbar

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        setUpListeners()

    }

    private fun setUpListeners() {
        binding.buttonResetPasswordSubmit.setOnClickListener {
            // treba uraditi da izmeni password
            Snackbar.make(binding.buttonResetPasswordSubmit, "Radi!", Snackbar.LENGTH_LONG).show()
        }

        binding.textViewResetPasswordBackToLogin.setOnClickListener {
            val intentBackToLogin = Intent(this, LoginActivity::class.java)
            startActivity(intentBackToLogin)
        }
    }
}