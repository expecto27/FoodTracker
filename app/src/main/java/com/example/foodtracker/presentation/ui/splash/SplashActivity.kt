package com.example.foodtracker.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.foodtracker.databinding.ActivitySplashBinding
import com.example.foodtracker.domain.usecase.CheckServerConnection
import com.example.foodtracker.presentation.MainActivity
import com.example.foodtracker.presentation.ui.error.ErrorActivity
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    @Inject
    lateinit var checkServerConnection: CheckServerConnection
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val intent = Intent(this, MainActivity::class.java)
        val intentError = Intent(this, ErrorActivity::class.java)
        var flag = false
        lifecycleScope.launch(Dispatchers.IO) {
            delay(2000)
            flag = try {
                checkServerConnection.execute()
            } catch(e: SocketTimeoutException) {
                false
            }
            if(flag){
                startActivity(intent)
            } else{
                startActivity(intentError)
            }
            finish()
        }
    }
}