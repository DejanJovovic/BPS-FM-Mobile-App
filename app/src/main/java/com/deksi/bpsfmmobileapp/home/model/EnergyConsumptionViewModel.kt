package com.deksi.bpsfmmobileapp.home.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EnergyConsumptionViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Energy Consumption Fragment"
    }
    val text: LiveData<String> = _text
}