package com.deksi.bpsfmmobileapp.home.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.deksi.bpsfmmobileapp.databinding.FragmentHomeBinding
import com.deksi.bpsfmmobileapp.home.api.DashboardApiService
import com.deksi.bpsfmmobileapp.home.api.DashboardRequest
import com.deksi.bpsfmmobileapp.home.api.DashboardResponse
import okhttp3.Headers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

        dataLoading()
    }

        private fun dataLoading() {
            val sharedPreferences =
                requireActivity().getSharedPreferences("AuthToken", Context.MODE_PRIVATE)
            val authToken = sharedPreferences.getString("transferObject", null)

            val headers = HashMap<String, String>()
            authToken?.let {
                headers["Authorization"] = "Bearer $it"
            }

            val retrofit = Retrofit.Builder()
                .baseUrl("https://bps-fms-staging.azurewebsites.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val dashboardApiService = retrofit.create(DashboardApiService::class.java)
            val requestDashboard = DashboardRequest(16, "11-09-2023", "12-10-2023")


            val call = dashboardApiService.getDashboardData(requestDashboard, Headers.of(headers))
            call.enqueue(object : Callback<DashboardResponse> {
                override fun onResponse(
                    call: Call<DashboardResponse>,
                    response: Response<DashboardResponse>
                ) {
                    if (response.isSuccessful) {
                        val dashboardResponse = response.body()
                        val textViewAnnoucment = binding.textViewAnnouncement
                        Log.d("Debug", "Dashboard Response: $dashboardResponse")
                        val accountsCount = dashboardResponse?.transferObject?.powerCuts?.ts
                        Log.d("Debug", "Accounts Count: $accountsCount")
                        textViewAnnoucment.text = accountsCount

                    }
                }

                override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                    Log.e("Error", "Failed to make the API request", t)
                }
            })
        }
    }