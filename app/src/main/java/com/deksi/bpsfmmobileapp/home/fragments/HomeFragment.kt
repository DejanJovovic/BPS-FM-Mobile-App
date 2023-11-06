package com.deksi.bpsfmmobileapp.home.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.TypedArrayUtils.getResourceId
import androidx.fragment.app.Fragment
import com.deksi.bpsfmmobileapp.databinding.FragmentHomeBinding
import com.deksi.bpsfmmobileapp.home.api.DashboardApiService
import com.deksi.bpsfmmobileapp.home.api.DashboardRequest
import com.deksi.bpsfmmobileapp.home.api.DashboardResponse
import com.deksi.bpsfmmobileapp.home.model.revenueSummaries
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
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.PercentFormatter
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

                    cards(dashboardResponse)
                    sliderCards(dashboardResponse)
                    totalConsumptionSeparatedTabGraph(dashboardResponse)
                    costSavingsData(dashboardResponse)
                    pieChart(dashboardResponse)
                    lineGraphs(dashboardResponse)
                    revenueSummariesData(dashboardResponse)

                }
            }

            override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                Log.e("Error", "Failed to make the API request", t)
            }
        })
    }


    private fun cards(dashboardResponse: DashboardResponse?) {

        /// *** accountsCount card ***
        val textViewAccountsCount = binding.textViewAccountsCount
        val accountsCount = dashboardResponse?.transferObject?.accountsCount
        textViewAccountsCount.text = accountsCount.toString()

        /// *** revenue card ***
        val textViewRevenue = binding.textViewRevenue
        val revenue = dashboardResponse?.transferObject?.revenue
        textViewRevenue.text = revenue.toString()

        /// *** serviceRequestsCount card ***
        val textViewServiceRequests = binding.textViewServiceRequests
        val serviceRequestsCount = dashboardResponse?.transferObject?.serviceRequestsCount
        textViewServiceRequests.text = serviceRequestsCount.toString()

        /// *** vendorsCount card ***
        val textViewVendors = binding.textViewVendors
        val vendorsCount = dashboardResponse?.transferObject?.vendorsCount
        textViewVendors.text = vendorsCount.toString()
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
        val percentageDiffPowerCuts =
            dashboardResponse?.transferObject?.powerCuts?.percentageDiff.toString()
        val formattedPercentageDiffPowerCuts = "$percentageDiffPowerCuts%"
        textViewPercentageDiffPowerCuts.text = formattedPercentageDiffPowerCuts


        /// *** powerCutsNum card ***
        val textViewCurrentValuePowerCutsNum = binding.textViewCurrentValuePowerCutsNum
        val currentValuePowerCutsNum = dashboardResponse?.transferObject?.powerCutsNum?.currentValue
        textViewCurrentValuePowerCutsNum.text = currentValuePowerCutsNum.toString()

        val textViewPreviousValuePowerCutsNum = binding.textViewPreviousValuePowerCutsNum
        val previousValuePowerCutsNum =
            dashboardResponse?.transferObject?.powerCutsNum?.previousValue
        textViewPreviousValuePowerCutsNum.text = previousValuePowerCutsNum.toString()

        val textViewPercentageDiffPowerCutsNum = binding.textViewPercentageDiffPowerCutsNum
        val percentageDiffPowerCutsNum =
            dashboardResponse?.transferObject?.powerCutsNum?.percentageDiff.toString()
        val formattedPercentageDiffPowerCutsNum = "$percentageDiffPowerCutsNum%"
        textViewPercentageDiffPowerCutsNum.text = formattedPercentageDiffPowerCutsNum


        /// *** energySavings card ***
        val textViewCurrentValueEnergySavings = binding.textViewCurrentValueEnergySavings
        val currentValueEnergySavings =
            dashboardResponse?.transferObject?.energySavings?.currentValue
        textViewCurrentValueEnergySavings.text = currentValueEnergySavings.toString()

        val textViewPreviousValueEnergySavings = binding.textViewPreviousValueEnergySavings
        val previousValueEnergySavings =
            dashboardResponse?.transferObject?.energySavings?.previousValue
        textViewPreviousValueEnergySavings.text = previousValueEnergySavings.toString()

        val textViewPercentageDiffEnergySavings = binding.textViewPercentageDiffEnergySavings
        val percentageDiffEnergySavings =
            dashboardResponse?.transferObject?.energySavings?.percentageDiff.toString()
        val formattedPercentageDiffEnergySavings = "$percentageDiffEnergySavings%"
        textViewPercentageDiffEnergySavings.text = formattedPercentageDiffEnergySavings


        /// *** carbonSavings card ***
        val textViewCurrentValueCarbonSavings = binding.textViewCurrentValueCarbonSavings
        val currentValueCarbonSavings =
            dashboardResponse?.transferObject?.carbonSavings?.currentValue
        textViewCurrentValueCarbonSavings.text = currentValueCarbonSavings.toString()

        val textViewPreviousValueCarbonSavings = binding.textViewPreviousValueCarbonSavings
        val previousValueCarbonSavings =
            dashboardResponse?.transferObject?.carbonSavings?.previousValue
        textViewPreviousValueCarbonSavings.text = previousValueCarbonSavings.toString()

        val textViewPercentageDiffCarbonSavings = binding.textViewPercentageDiffCarbonSavings
        val percentageDiffCarbonSavings =
            dashboardResponse?.transferObject?.energySavings?.percentageDiff.toString()
        val formattedPercentageDiffCarbonSavings = "$percentageDiffCarbonSavings%"
        textViewPercentageDiffCarbonSavings.text = formattedPercentageDiffCarbonSavings

    }


    private fun totalConsumptionSeparatedTabGraph(dashboardResponse: DashboardResponse?) {
        val totalConsumptionSeparated = dashboardResponse?.transferObject?.totalConsumptionSeparated
        val gridTotalConsumption = totalConsumptionSeparated?.gridTotalConsumption

        val barChart = binding.totalConsumptionSeperatedBarChart

        val entries = mutableListOf<BarEntry>()

        val customLabelsX = arrayOf(
            "Apr 1",
            "Apr 2",
            "Apr 3",
            "Apr 4",
            "Apr 5",
            "Apr 6",
            "Apr 7",
            "Apr 8",
            "Apr 9",
            "Apr 10",
            "Apr 11",
            "Apr 12",
            "Apr 13",
            "Apr 14",
            "Apr 15",
            "Apr 16",
            "Apr 17",
            "Apr 18",
            "Apr 19",
            "Apr 20",
            "Apr 21",
            "Apr 22",
            "Apr 23",
            "Apr 24",
            "Apr 25",
            "Apr 26",
            "Apr 27",
            "Apr 28",
            "Apr 29",
            "Apr 30",
            "Apr 31"
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


    private fun costSavingsData(dashboardResponse: DashboardResponse?) {

        dashboardResponse?.transferObject?.costSavings?.let { costSavings ->
            for ((index, summary) in costSavings.withIndex()) {
                val cardIndex = when (summary.name) {
                    "Diesel" -> 1
                    "Solar" -> 2
                    "Gas" -> 3
                    else -> index + 1
                }

                val costSavingsNameTextView =
                    binding.root.findViewById<TextView>(getResourceId("text_view_cost_savings_name$cardIndex"))
                val costSavingsCostTextView =
                    binding.root.findViewById<TextView>(getResourceId("text_view_cost_savings_cost$cardIndex"))
                val costSavingsEnergyTextView =
                    binding.root.findViewById<TextView>(getResourceId("text_view_cost_savings_energy$cardIndex"))


                costSavingsNameTextView.text = summary.name
                costSavingsCostTextView.text = "${summary.cost}"
                costSavingsEnergyTextView.text = "${summary.energy}kWh"

            }
        }

    }


    private fun pieChart(dashboardResponse: DashboardResponse?) {

        val energySources = dashboardResponse?.transferObject?.energySources

        val totalEnergy = energySources?.sumByDouble { it.energy!! }

        // i need to create a textView in the middle of the pieChart and set the totalEnergy
//        val totalEnergyText = "$totalEnergy kWh"
//        val energyText = binding.
//        energyText.text = totalEnergyText

        val entries = energySources?.map { source ->
            source.energy?.let { PieEntry(it.toFloat(), source.name) }
        }

        val dataSet = PieDataSet(entries, "Energy Sources")

        dataSet.colors = listOf(
            Color.parseColor("#05AA6C"),
            Color.parseColor("#4E5BA6"),
            Color.parseColor("#F79009"),
            Color.parseColor("#EE46BC")
        )
        dataSet.valueTextSize = 12f

        val pieData = PieData(dataSet)
        pieData.setValueFormatter(PercentFormatter())

        val pieChart = binding.pieChartEnergySources

        pieChart.data = pieData
        pieChart.isDrawHoleEnabled = true
        pieChart.holeRadius = 20f
        pieChart.setUsePercentValues(true)
        pieChart.description.isEnabled = false
        pieChart.legend.isEnabled = false

        pieChart.invalidate()

    }

    private fun lineGraphs(dashboardResponse: DashboardResponse?) {

        // graph consists of: expectedDiesel, received, solarTotalConsumption?
        val actual = dashboardResponse?.transferObject?.expectedDiesel
        val received = dashboardResponse?.transferObject?.received
        val expectedSolar =
            dashboardResponse?.transferObject?.totalConsumptionSeparated?.solarTotalConsumption

        val lineChart = binding.lineChartReceivedExpectedActual


        val entriesActual = actual?.mapIndexed { index, data ->
            data.energy?.let { Entry(index.toFloat(), it.toFloat()) }
        }

        val entriesReceived = received?.mapIndexed { index, data ->
            data.energy?.let { Entry(index.toFloat(), it.toFloat()) }
        }

        val entriesExpectedSolar = expectedSolar?.mapIndexed { index, data ->
            data.energy?.let { Entry(index.toFloat(), it) }
        }

        val dataSetActual = LineDataSet(entriesActual, "Actual")
        dataSetActual.color = Color.parseColor("#F79009")
        dataSetActual.setCircleColor(Color.parseColor("#F79009"))
        dataSetActual.setDrawValues(false)

        val dataSetReceived = LineDataSet(entriesReceived, "Received")
        dataSetReceived.color = Color.parseColor("#05AA6C")
        dataSetReceived.setCircleColor(Color.parseColor("#05AA6C"))
        dataSetReceived.setDrawValues(false)

        val dataSetExpected = LineDataSet(entriesExpectedSolar, "Expected")
        dataSetExpected.color = Color.parseColor("#FD5C63")
        dataSetExpected.setCircleColor(Color.parseColor("#FD5C63"))
        dataSetExpected.setDrawValues(false)


        val xAxis = lineChart.xAxis
        xAxis.setDrawLabels(false)
        xAxis.setDrawGridLines(false)

        val leftYAxis = lineChart.axisLeft
        val rightYAxis = lineChart.axisRight

        leftYAxis.setDrawLabels(false)
        leftYAxis.setDrawGridLines(false)

        rightYAxis.setDrawLabels(false)
        rightYAxis.setDrawGridLines(false)


        val lineData = LineData(dataSetActual, dataSetReceived, dataSetExpected)

        lineChart.data = lineData


        lineChart.legend.isEnabled = false
        lineChart.description.isEnabled = false
        lineChart.invalidate()

    }


    private fun revenueSummariesData(dashboardResponse: DashboardResponse?) {

        dashboardResponse?.transferObject?.revenueSummaries?.let { revenueSummaries ->
            for ((index, summary) in revenueSummaries.withIndex()) {
                val cardIndex = when (summary.serviceType) {
                    "Electrical" -> 1
                    "Furniture" -> 2
                    "Generator" -> 3
                    "Plumbing" -> 4
                    "Power" -> 5
                    "Other" -> 6
                    "CleaningAndJanitorial" -> 7
                    else -> index + 1
                }

                val serviceTypeTextView =
                    binding.root.findViewById<TextView>(getResourceId("text_view_service_type$cardIndex"))
                val serviceRequestNosTextView =
                    binding.root.findViewById<TextView>(getResourceId("text_view_service_request_nos$cardIndex"))
                val totalExpenseTextView =
                    binding.root.findViewById<TextView>(getResourceId("text_view_total_expense$cardIndex"))
                val previousYearTextView =
                    binding.root.findViewById<TextView>(getResourceId("text_view_previous_year$cardIndex"))


                serviceTypeTextView.text = summary.serviceType
                serviceRequestNosTextView.text = "${summary.serviceRequestNos} Service Requests"
                totalExpenseTextView.text = "${summary.totalExpense}"
                previousYearTextView.text = "${summary.previousYear}%"

            }
        }
    }

    private fun getResourceId(baseId: String): Int {
        return requireActivity().resources.getIdentifier(
            baseId,
            "id",
            requireActivity().packageName
        )
    }
}




