/*
 * Copyright (c) Mahmoud Hesham.
 * All rights reserved.
 */

package com.mahmoudhesham.connectingtointernetusingretrofitandpicasso.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mahmoudhesham.connectingtointernetusingretrofitandpicasso.databinding.ImageItemBinding
import com.mahmoudhesham.connectingtointernetusingretrofitandpicasso.network.ImageData
import com.squareup.picasso.Picasso

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback =object : DiffUtil.ItemCallback<ImageData>(){
        override fun areItemsTheSame(oldItem: ImageData, newItem: ImageData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ImageData, newItem: ImageData): Boolean {
            return oldItem == newItem
        }

    }

    private val differ =AsyncListDiffer(this, diffCallback)
    var images : List<ImageData>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder{

        return ImageViewHolder(

            ImageItemBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false))

    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        holder.binding.apply {

            val imageItem = images[position]
            Picasso.get().load(imageItem.thumbnailUrl).into(imageIV)
            titleTV.text = imageItem.title
            albumIdTextView.text = imageItem.albumId.toString()

        }
    }

    override fun getItemCount(): Int = images.size

}