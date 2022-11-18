package com.example.win15

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.win15.databinding.ActivityMainBinding
import com.onesignal.OneSignal

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId("714b9f14-381d-4fc4-a93c-28d480557381")

        binding.buttonTips.setOnClickListener {
            startActivity(Intent(this, TipsActivity::class.java))
        }
        binding.buttonStrategy.setOnClickListener {
            startActivity(Intent(this, StrategyActivity::class.java))
        }
        binding.buttonFaq.setOnClickListener {
            startActivity(Intent(this, FaqActivity::class.java))
        }
    }
}