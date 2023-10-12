package com.deksi.bpsfmmobileapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.deksi.bpsfmmobileapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setUpListeners()


    }

    private fun setUpListeners() {
        binding.buttonLoginToAccount.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


        binding.textViewMainSignUp.setOnClickListener{
            val intentSignup = Intent(this, SignupActivity::class.java)
            startActivity(intentSignup)
        }

    }
}