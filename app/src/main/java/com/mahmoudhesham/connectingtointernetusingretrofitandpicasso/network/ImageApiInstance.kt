/*
 * Copyright (c) Mahmoud Hesham.
 * All rights reserved.
 */

package com.mahmoudhesham.connectingtointernetusingretrofitandpicasso.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ImageApiInstance {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    val api : ImageApi by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImageApi::class.java)

    }
}