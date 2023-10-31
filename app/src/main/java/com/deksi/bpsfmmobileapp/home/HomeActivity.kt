package com.deksi.bpsfmmobileapp.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.google.android.material.snackbar.Snackbar
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

        // treba da centriram title
//        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
//        supportActionBar?.setCustomView(R.layout.action_bar_layout_dashboard)


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



//       getDashboardData()

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
        val displayedText = "Welcome back $email"
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





//   private fun getDashboardData() {
//
//   }
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://bps-fms-staging.azurewebsites.net/api/dashboard/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val getDashboardDataService = retrofit.create(DashboardApiService::class.java)
//
//        val call = getDashboardDataService.getDashboardData()
//        call.enqueue(object: Callback<Dashboard> {
//            override fun onResponse(call: Call<Dashboard>, response: Response<Dashboard>) {
//                val gson = Gson()
//
//                if(response.isSuccessful) {
//                    val responseJsonDashboard = response.body()
//                    val dashboard = gson.toJson(responseJsonDashboard, Dashboard::class.java)
//                    if(dashboard != null) {
//                        val message = responseJsonDashboard?.message
//                        val success = responseJsonDashboard?.success
//                    }
//
//                }
//                else{
//                    Toast.makeText(applicationContext, "Neuspesno", Toast.LENGTH_LONG).show()
//                }
//                Toast.makeText(applicationContext, "Radi", Toast.LENGTH_LONG).show()
//
//
//            }
//
//            override fun onFailure(call: Call<Dashboard>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//        })
//
//    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}