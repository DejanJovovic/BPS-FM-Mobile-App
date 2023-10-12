package com.deksi.bpsfmmobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deksi.bpsfmmobileapp.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        setUpListeners()

    }

    private fun setUpListeners() {

        binding.buttonLogin.setOnClickListener{
            Snackbar.make(binding.buttonLogin, "Uspeh!", Snackbar.LENGTH_LONG).show()
        }

        binding.textViewSignUp.setOnClickListener {
//            Snackbar.make(binding.textViewSignUp, "Radi!", Snackbar.LENGTH_LONG).show()
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        binding.textViewForgotPassword.setOnClickListener{
            val intentForgotPassword = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intentForgotPassword)
        }

    }
}