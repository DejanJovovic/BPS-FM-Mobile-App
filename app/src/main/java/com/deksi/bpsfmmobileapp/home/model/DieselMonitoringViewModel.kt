package com.deksi.bpsfmmobileapp.home.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DieselMonitoringViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Diesel monitoring Fragment"
    }
    val text: LiveData<String> = _text
}