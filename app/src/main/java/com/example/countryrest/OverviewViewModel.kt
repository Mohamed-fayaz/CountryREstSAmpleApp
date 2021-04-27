package com.example.countryrest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _properties = MutableLiveData<List<CountryProperty>>()

    val properties: LiveData<List<CountryProperty>>
        get() = _properties
    init {
        getCountryProperties()
    }

    private fun getCountryProperties() {
        coroutineScope.launch {
            var getPropertiesDeferred = CountryApi.retrofitService.getProperties()

            try {

                var listResult = getPropertiesDeferred.await()
                _properties.value = listResult


            } catch (e: Exception) {
                _status.value = e.message
                e.message?.let { Log.i("Error Msg", it) }
            }

        }

    }
}