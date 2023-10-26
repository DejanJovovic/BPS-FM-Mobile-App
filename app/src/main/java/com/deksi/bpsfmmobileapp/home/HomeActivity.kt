package com.deksi.bpsfmmobileapp.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
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
                R.id.nav_home, R.id.nav_energy_consumption, R.id.nav_diesel_monitoring
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//       getDashboardData()

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