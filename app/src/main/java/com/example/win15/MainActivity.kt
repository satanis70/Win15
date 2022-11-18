package com.example.win15

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.win15.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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