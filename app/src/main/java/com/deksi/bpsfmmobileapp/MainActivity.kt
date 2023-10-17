package com.deksi.bpsfmmobileapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.deksi.bpsfmmobileapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setUpListeners()

        setUpImageTextAdapter()


    }

    private fun setUpImageTextAdapter() {
        val pages = listOf(
            PageContent(R.drawable.main_image, "Make informed energy decisions effortlessly with Beacon."),
            PageContent(R.drawable.main_image2, "Find, Hire and Manage vendors at your fingertips."),
            PageContent(R.drawable.main_image3, "Save cost and effectively manage your billing cycles.")
        )

        val viewPager = findViewById<ViewPager>(R.id.view_pager_main_image)
        val adapter = ImagePagesAdapter(pages, this)
        viewPager.adapter = adapter
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