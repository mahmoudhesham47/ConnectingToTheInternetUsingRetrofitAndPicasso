/*
 * Copyright (c) Mahmoud Hesham.
 * All rights reserved.
 */

package com.mahmoudhesham.connectingtointernetusingretrofitandpicasso.network

import retrofit2.Response
import retrofit2.http.GET

interface ImageApi {

    @GET("/photos")
    suspend fun getImages() :Response<List<ImageData>>

}