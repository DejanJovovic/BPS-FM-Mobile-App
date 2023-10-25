package com.deksi.bpsfmmobileapp.home.notifications

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.deksi.bpsfmmobileapp.R
import com.deksi.bpsfmmobileapp.home.adapters.NotificationsAdapter
import com.deksi.bpsfmmobileapp.databinding.ActivityNotificationsBinding
import com.deksi.bpsfmmobileapp.home.model.Notifications

class NotificationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)


        val listView = findViewById<ListView>(R.id.list_view_notifications)

        val customItems = listOf(
            Notifications("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                , R.drawable.clock, "FEB 21, 2023"),
            Notifications("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                , R.drawable.clock, "FEB 21, 2023"),
            Notifications("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                , R.drawable.clock, "FEB 21, 2023"),
            Notifications("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                , R.drawable.clock, "FEB 21, 2023"),
            Notifications("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                , R.drawable.clock, "FEB 21, 2023"),
            Notifications("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                , R.drawable.clock, "FEB 21, 2023")

        )

        val adapter = NotificationsAdapter(this, customItems)
        listView.adapter = adapter


    }


}