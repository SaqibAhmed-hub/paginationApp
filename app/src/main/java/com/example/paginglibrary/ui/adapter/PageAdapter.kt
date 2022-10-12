package com.example.paginglibrary.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paginglibrary.R
import com.example.paginglibrary.data.model.Character
import javax.inject.Inject

class PageAdapter @Inject constructor() :
    PagingDataAdapter<Character, PageAdapter.PageViewHolder>(CharacterComparator) {

    inner class PageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val characterName: TextView = itemView.findViewById(R.id.tvName)
        private val characterImage: ImageView = itemView.findViewById(R.id.imageView)
        fun bindCharacter(data: Character) {
            characterName.text = data.name
            Glide.with(characterImage)
                .load(data.image)
                .into(characterImage)

        }

    }


    override fun onBindViewHolder(holder: PageAdapter.PageViewHolder, position: Int) {
            holder.bindCharacter(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageAdapter.PageViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_layout, parent, false)
        return PageViewHolder(view)
    }


}

object CharacterComparator : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character) =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Character, newItem: Character) =
        oldItem.name == newItem.name
}