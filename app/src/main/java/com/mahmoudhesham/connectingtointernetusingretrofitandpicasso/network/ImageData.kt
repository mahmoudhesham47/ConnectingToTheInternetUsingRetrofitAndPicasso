/*
 * Copyright (c) Mahmoud Hesham.
 * All rights reserved.
 */

package com.mahmoudhesham.connectingtointernetusingretrofitandpicasso.network

data class ImageData(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)