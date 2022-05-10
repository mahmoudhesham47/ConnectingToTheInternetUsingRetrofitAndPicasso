/*
 * Copyright (c) Mahmoud Hesham.
 * All rights reserved.
 */

package com.mahmoudhesham.connectingtointernetusingretrofitandpicasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.mahmoudhesham.connectingtointernetusingretrofitandpicasso.adapter.ImageAdapter
import com.mahmoudhesham.connectingtointernetusingretrofitandpicasso.databinding.ActivityMainBinding
import com.mahmoudhesham.connectingtointernetusingretrofitandpicasso.network.ImageApiInstance
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getRecyclerView()

        lifecycleScope.launchWhenCreated {
            val response =
                try {
                    ImageApiInstance.api.getImages()
                } catch (e : IOException) {
                    Log.e("MAIN_ACTIVITY","IOException : no internet connection! ")
                    return@launchWhenCreated
                } catch (i : HttpException) {
                    Log.e("MAIN_ACTIVITY","IOException : no internet connection! ")
                    return@launchWhenCreated
                }
            if (response.isSuccessful && response.body()!= null){
                imageAdapter.images =response.body()!!
            } else {
                Log.e("MAIN_ACTIVITY", "No RESPONSE")
            }
        }
    }

    private fun getRecyclerView() = binding.retrofitRecyclerView.apply {
        imageAdapter = ImageAdapter()
        adapter = imageAdapter
        layoutManager = GridLayoutManager(this@MainActivity,3)
    }
}