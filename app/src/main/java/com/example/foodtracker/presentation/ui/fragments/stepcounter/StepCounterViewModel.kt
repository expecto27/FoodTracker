package com.example.foodtracker.presentation.ui.fragments.stepcounter

import android.app.Application
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class StepCounterViewModel(private var application: Application) : AndroidViewModel(application), SensorEventListener {

    private val _stepCount = MutableLiveData<Int>()

    val stepCount: LiveData<Int> get() = _stepCount

    private val sensorManager = application.getSystemService(SensorManager::class.java)
    private val stepCounterSensor: Sensor? =
        sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_STEP_COUNTER) {
            _stepCount.value = event.values[0].toInt()
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // nothing
    }

    fun registerSensor() {
        sensorManager.registerListener(this, stepCounterSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    fun unregisterSensor() {
        sensorManager.unregisterListener(this)
    }

}