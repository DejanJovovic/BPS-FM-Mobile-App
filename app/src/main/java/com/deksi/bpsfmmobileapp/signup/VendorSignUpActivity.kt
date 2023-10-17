package com.deksi.bpsfmmobileapp.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deksi.bpsfmmobileapp.login.LoginActivity
import com.deksi.bpsfmmobileapp.databinding.ActivityVendorSignUpBinding

class VendorSignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVendorSignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVendorSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        setUpListeners()
    }

    private fun setUpListeners() {
        binding.buttonVendorGetStarted.setOnClickListener {
            // treba izmeniti
            val intentGetStarted = Intent(this, LoginActivity::class.java)
            startActivity(intentGetStarted)
        }

        binding.textViewVendorLogIn.setOnClickListener {
            val intentVendorLogin = Intent(this, LoginActivity::class.java)
            startActivity(intentVendorLogin)
        }
    }
}