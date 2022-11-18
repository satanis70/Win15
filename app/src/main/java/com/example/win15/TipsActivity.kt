package com.example.win15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.win15.adapters.TipsAdapter
import com.example.win15.databinding.ActivityTipsBinding
import com.example.win15.models.Tipsandtrick
import com.example.win15.retrofit.ApiAviator
import com.example.win15.retrofit.RetrofitCreate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class TipsActivity : AppCompatActivity() {
    lateinit var binding: ActivityTipsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listTips = ArrayList<Tipsandtrick>()
        getData(listTips)
    }

    private fun getData(listTips: ArrayList<Tipsandtrick>) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitCreate.create().getTips().awaitResponse()
            if (call.isSuccessful){
                listTips.addAll(call.body()!!.tipsandtricks)
            }
            launch(Dispatchers.Main){
                val rv = binding.tipsRecyclerView
                Log.i("tips", listTips.toString())
                rv.layoutManager = LinearLayoutManager(this@TipsActivity)
                rv.adapter = TipsAdapter(listTips)
            }
        }
    }
}