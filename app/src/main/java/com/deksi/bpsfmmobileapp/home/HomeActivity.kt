package com.deksi.bpsfmmobileapp.home

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.deksi.bpsfmmobileapp.R
import com.deksi.bpsfmmobileapp.databinding.ActivityHomeBinding
import com.deksi.bpsfmmobileapp.home.notifications.NotificationsActivity
import com.deksi.bpsfmmobileapp.home.quickActions.QuickActionActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageViewNotifications = binding.appBarHome.imageViewAppbarNotification

        imageViewNotifications.setOnClickListener {
            val intentNotification = Intent(this, NotificationsActivity::class.java)
            startActivity(intentNotification)
        }


        setSupportActionBar(binding.appBarHome.toolbar)

        binding.appBarHome.fab.setOnClickListener {
            val intent = Intent(this, QuickActionActivity::class.java)
            startActivity(intent)
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_notifications
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        receiveEmail()
        setupSpinner()

    }
    private fun receiveEmail() {
        val receivedEmail = intent
        val email = receivedEmail.getStringExtra("email")
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val headerView = navigationView.getHeaderView(0)
        val textViewEmail = headerView.findViewById<TextView>(R.id.text_view_email)
        val textViewWelcome = findViewById<TextView>(R.id.text_view_welcome_back)
        val displayedText = "Welcome back $email,"
        textViewWelcome.text = displayedText
        textViewEmail.text = email
    }

    private fun setupSpinner() {
        val items = arrayOf("Grid", "Diesel", "Solar", "Gas")
        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}