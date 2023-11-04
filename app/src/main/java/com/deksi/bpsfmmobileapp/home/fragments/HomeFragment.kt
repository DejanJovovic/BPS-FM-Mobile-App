package com.deksi.bpsfmmobileapp.home.fragments

import android.content.Context
import android.graphics.Color
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
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
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

                        sliderCards(dashboardResponse)
                        totalConsumptionSeparatedTabGraph(dashboardResponse)

                    }
                }

                override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                    Log.e("Error", "Failed to make the API request", t)
                }
            })
        }

    private fun sliderCards(dashboardResponse: DashboardResponse?) {

        /// *** powerCuts card ***
        val textViewCurrentValuePowerCuts = binding.textViewCurrentValuePowerCuts
        val currentValuePowerCuts = dashboardResponse?.transferObject?.powerCuts?.currentValue
        textViewCurrentValuePowerCuts.text = currentValuePowerCuts.toString()

        val textViewPreviousValuePowerCuts = binding.textViewPreviousValuePowerCuts
        val previousValuePowerCuts = dashboardResponse?.transferObject?.powerCuts?.previousValue
        textViewPreviousValuePowerCuts.text = previousValuePowerCuts.toString()

        val textViewPercentageDiffPowerCuts = binding.textViewPercentageDiffPowerCuts
        val percentageDiffPowerCuts = dashboardResponse?.transferObject?.powerCuts?.percentageDiff.toString()
        val formattedPercentageDiffPowerCuts = "$percentageDiffPowerCuts%"
        textViewPercentageDiffPowerCuts.text = formattedPercentageDiffPowerCuts


        /// *** powerCutsNum card ***
        val textViewCurrentValuePowerCutsNum = binding.textViewCurrentValuePowerCutsNum
        val currentValuePowerCutsNum = dashboardResponse?.transferObject?.powerCutsNum?.currentValue
        textViewCurrentValuePowerCutsNum.text = currentValuePowerCutsNum.toString()

        val textViewPreviousValuePowerCutsNum = binding.textViewPreviousValuePowerCutsNum
        val previousValuePowerCutsNum = dashboardResponse?.transferObject?.powerCutsNum?.previousValue
        textViewPreviousValuePowerCutsNum.text = previousValuePowerCutsNum.toString()

        val textViewPercentageDiffPowerCutsNum = binding.textViewPercentageDiffPowerCutsNum
        val percentageDiffPowerCutsNum = dashboardResponse?.transferObject?.powerCutsNum?.percentageDiff.toString()
        val formattedPercentageDiffPowerCutsNum = "$percentageDiffPowerCutsNum%"
        textViewPercentageDiffPowerCutsNum.text = formattedPercentageDiffPowerCutsNum



        /// *** energySavings card ***
        val textViewCurrentValueEnergySavings = binding.textViewCurrentValueEnergySavings
        val currentValueEnergySavings = dashboardResponse?.transferObject?.energySavings?.currentValue
        textViewCurrentValueEnergySavings.text = currentValueEnergySavings.toString()

        val textViewPreviousValueEnergySavings = binding.textViewPreviousValueEnergySavings
        val previousValueEnergySavings = dashboardResponse?.transferObject?.energySavings?.previousValue
        textViewPreviousValueEnergySavings.text = previousValueEnergySavings.toString()

        val textViewPercentageDiffEnergySavings = binding.textViewPercentageDiffEnergySavings
        val percentageDiffEnergySavings = dashboardResponse?.transferObject?.energySavings?.percentageDiff.toString()
        val formattedPercentageDiffEnergySavings = "$percentageDiffEnergySavings%"
        textViewPercentageDiffEnergySavings.text = formattedPercentageDiffEnergySavings



        /// *** carbonSavings card ***
        val textViewCurrentValueCarbonSavings = binding.textViewCurrentValueCarbonSavings
        val currentValueCarbonSavings = dashboardResponse?.transferObject?.carbonSavings?.currentValue
        textViewCurrentValueCarbonSavings.text = currentValueCarbonSavings.toString()

        val textViewPreviousValueCarbonSavings = binding.textViewPreviousValueCarbonSavings
        val previousValueCarbonSavings = dashboardResponse?.transferObject?.carbonSavings?.previousValue
        textViewPreviousValueCarbonSavings.text = previousValueCarbonSavings.toString()

        val textViewPercentageDiffCarbonSavings = binding.textViewPercentageDiffCarbonSavings
        val percentageDiffCarbonSavings = dashboardResponse?.transferObject?.energySavings?.percentageDiff.toString()
        val formattedPercentageDiffCarbonSavings = "$percentageDiffCarbonSavings%"
        textViewPercentageDiffCarbonSavings.text = formattedPercentageDiffCarbonSavings

    }


    private fun totalConsumptionSeparatedTabGraph(dashboardResponse: DashboardResponse?) {
        val totalConsumptionSeparated = dashboardResponse?.transferObject?.totalConsumptionSeparated
        val gridTotalConsumption = totalConsumptionSeparated?.gridTotalConsumption

        val barChart = binding.totalConsumptionSeperatedBarChart

        val entries = mutableListOf<BarEntry>()

        val customLabelsX = arrayOf("Apr 1", "Apr 2", "Apr 3", "Apr 4",
            "Apr 5", "Apr 6", "Apr 7", "Apr 8", "Apr 9", "Apr 10", "Apr 11", "Apr 12", "Apr 13", "Apr 14",
            "Apr 15", "Apr 16", "Apr 17", "Apr 18", "Apr 19", "Apr 20", "Apr 21", "Apr 22", "Apr 23",
            "Apr 24", "Apr 25", "Apr 26", "Apr 27", "Apr 28", "Apr 29", "Apr 30", "Apr 31"
            )

        for (i in 0 until (gridTotalConsumption?.size ?: 0)) {
            val energy = gridTotalConsumption?.get(i)?.energy ?: 0f
            entries.add(BarEntry(i.toFloat(), energy))
        }

        val dataSet = BarDataSet(entries, "Grid total consumption")
        dataSet.setDrawValues(true)
        dataSet.valueTextColor = Color.BLACK


        val barData = BarData(dataSet)
        dataSet.color = Color.BLUE



        val xAxis = barChart.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(customLabelsX)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.labelCount = customLabelsX.size
        xAxis.labelRotationAngle = -70f
        xAxis.granularity = 1f

        val leftYAxis = barChart.axisLeft
        val rightYAxis = barChart.axisRight

        leftYAxis.setDrawLabels(false)
        leftYAxis.setDrawGridLines(false)

        rightYAxis.setDrawLabels(false)
        rightYAxis.setDrawGridLines(false)


        barChart.legend.isEnabled = false
        barChart.description.isEnabled = false
        barChart.data = barData
        barChart.invalidate()

        }


}