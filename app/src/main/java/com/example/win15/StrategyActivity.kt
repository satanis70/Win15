package com.example.win15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.win15.adapters.StrategyAdapter
import com.example.win15.adapters.TipsAdapter
import com.example.win15.databinding.ActivityStrategyBinding
import com.example.win15.models.Strategy
import com.example.win15.retrofit.ApiAviator
import com.example.win15.retrofit.RetrofitCreate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class StrategyActivity : AppCompatActivity() {
    lateinit var binding: ActivityStrategyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStrategyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listStrategy = ArrayList<Strategy>()
        getData(listStrategy)
    }

    private fun getData(listStrategy: ArrayList<Strategy>) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitCreate.create().getStrategy().awaitResponse()
            if (call.isSuccessful){
                listStrategy.addAll(call.body()!!.strategy)
            }
            launch(Dispatchers.Main){
                val rv = binding.strategyRecyclerView
                rv.layoutManager = LinearLayoutManager(this@StrategyActivity)
                rv.adapter = StrategyAdapter(listStrategy)
            }
        }
    }
}