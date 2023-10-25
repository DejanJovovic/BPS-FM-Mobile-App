package com.deksi.bpsfmmobileapp.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.deksi.bpsfmmobileapp.databinding.FragmentDieselMonitoringBinding
import com.deksi.bpsfmmobileapp.home.viewModel.DieselMonitoringViewModel

class DieselMonitoringFragment : Fragment() {

    private var _binding: FragmentDieselMonitoringBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dieselMonitoringViewModel =
            ViewModelProvider(this).get(DieselMonitoringViewModel::class.java)

        _binding = FragmentDieselMonitoringBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDieselMonitoring
        dieselMonitoringViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}