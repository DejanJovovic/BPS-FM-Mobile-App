package com.deksi.bpsfmmobileapp.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deksi.bpsfmmobileapp.login.LoginActivity
import com.deksi.bpsfmmobileapp.R
import com.deksi.bpsfmmobileapp.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)


        setUpListeners()
        setUpButton()
    }
    private fun setUpListeners() {
        binding.cardViewBusinessAccount.setOnClickListener {
            val intentBusiness = Intent(this, BusinessSignUpActivity::class.java)
            startActivity(intentBusiness)
            finish()
        }

        binding.cardViewVendorAccount.setOnClickListener {
            val intentVendor = Intent(this, VendorSignUpActivity::class.java)
            startActivity(intentVendor)
            finish()
        }

        binding.textViewLogIn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setUpButton() {
        //treba menjati
        val actionCompleted = false
        binding.buttonContinueSignup.isEnabled = false

        binding.buttonContinueSignup.setOnClickListener{
            //treba dodati da klikom na dugme predje na odredjeni layout
        }
    }

}