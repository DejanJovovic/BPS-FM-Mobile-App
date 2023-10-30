package com.deksi.bpsfmmobileapp.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.deksi.bpsfmmobileapp.databinding.FragmentHomeBinding
import com.deksi.bpsfmmobileapp.home.api.DashboardApiService
import com.deksi.bpsfmmobileapp.home.api.DashboardRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        dataLoading()
    }


//    private fun dataLoading() {
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://bps-fms-staging.azurewebsites.net/api/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val requestDashboard = DashboardRequest(16, "11-09-2023", "12-10-2023")
//        val dashboardApiService = retrofit.create(DashboardApiService::class.java)
//        val responseDashboard = dashboardApiService.getDashboardData()
//
//
//        if (responseDashboard.isSuccessful) {
//            val dataResponse = responseDashboard.body()
//            val transferObject = dataResponse?.transferObject
//
//            if (transferObject != null) {
//                // Step 7: Use items to populate your UI components
//                val specificItem = transferObject // Use the first item as an example
//                val itemName = specificItem.transferObject.powerCuts
////                val itemDescription = specificItem.description
//
//                // Update your UI components with the specific data
//                binding.textViewWelcomeBack.text = itemName.toString()
////                textViewDescription.text = itemDescription
//            }
//
//
//        }
//
//    }
}