package com.example.win15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.win15.adapters.FaqAdapter
import com.example.win15.adapters.StrategyAdapter
import com.example.win15.databinding.ActivityFaqBinding
import com.example.win15.models.Faq
import com.example.win15.retrofit.RetrofitCreate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.awaitResponse

class FaqActivity : AppCompatActivity() {
    lateinit var binding: ActivityFaqBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaqBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listFaq = ArrayList<Faq>()
        getData(listFaq)
    }

    private fun getData(listFaq: ArrayList<Faq>) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitCreate.create().getFaq().awaitResponse()
            if (call.isSuccessful){
                listFaq.addAll(call.body()!!.faq)
            }
            launch(Dispatchers.Main){
                val rv = binding.faqRecyclerView
                rv.layoutManager = LinearLayoutManager(this@FaqActivity)
                rv.adapter = FaqAdapter(listFaq)
            }
        }
    }
}