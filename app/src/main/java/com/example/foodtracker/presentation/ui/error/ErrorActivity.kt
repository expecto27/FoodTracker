package com.example.foodtracker.presentation.ui.error

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.foodtracker.R
import com.example.foodtracker.databinding.ActivityErrorBinding
import com.example.foodtracker.domain.usecase.CheckServerConnection
import com.example.foodtracker.presentation.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
@AndroidEntryPoint
class ErrorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityErrorBinding

    @Inject
    lateinit var checkServerConnection: CheckServerConnection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityErrorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch(Dispatchers.IO) {
            while (true) {
                delay(3000) // Ждем 3 секунды
                val isConnected = try {
                    checkServerConnection.execute()
                } catch (e: Exception) {
                    Log.e(this.javaClass.name, "Ошибка при проверке подключения к серверу", e)
                    false
                }
                if (isConnected) {
                    val intent = Intent(this@ErrorActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Завершаем текущую активность
                    break // Выходим из цикла
                }
            }
        }
    }
}