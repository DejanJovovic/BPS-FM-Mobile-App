package com.deksi.bpsfmmobileapp.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deksi.bpsfmmobileapp.login.LoginActivity
import com.deksi.bpsfmmobileapp.databinding.ActivityBusinessSignUpBinding

class BusinessSignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBusinessSignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBusinessSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        setUpListeners()

    }

    private fun setUpListeners() {
        binding.buttonBusinessGetStarted.setOnClickListener {
            //treba izmeniti
            val intentBusinessGetStarted = Intent(this, LoginActivity::class.java)
            startActivity(intentBusinessGetStarted)
        }
        binding.textViewBusinessLogIn.setOnClickListener {
            val intentBusinessLogIn = Intent(this, LoginActivity::class.java)
            startActivity(intentBusinessLogIn)
        }
    }
}