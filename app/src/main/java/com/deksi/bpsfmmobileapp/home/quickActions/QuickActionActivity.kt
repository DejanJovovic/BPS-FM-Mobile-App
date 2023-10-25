package com.deksi.bpsfmmobileapp.home.quickActions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deksi.bpsfmmobileapp.R
import com.deksi.bpsfmmobileapp.databinding.ActivityQuickActionBinding
import com.deksi.bpsfmmobileapp.home.quickActions.addRequest.AddRequestActivity
import com.deksi.bpsfmmobileapp.home.quickActions.newGuest.NewGuestActivity

class QuickActionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuickActionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuickActionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        setClickListeners()

    }

    private fun setClickListeners() {

        binding.cardViewRequestService.setOnClickListener {
            val intentRequestService = Intent(this, AddRequestActivity::class.java)
            startActivity(intentRequestService)
        }

        binding.cardViewAddNewGuest.setOnClickListener {
            val intentNewGuest = Intent(this, NewGuestActivity::class.java)
            startActivity(intentNewGuest)
        }

    }
}