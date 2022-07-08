package com.lestrades.adaptadores_sports

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lestrades.adaptadores_sports.databinding.ItemSportBinding

class SportListAdapter(private val listerner: OnClickListener):
    ListAdapter<Sport,RecyclerView.ViewHolder>(SportDiffCallback()) {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_sport, parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val sport = getItem(position)
        with(holder as ViewHolder){
            binding.tvName.text = sport.name
            Glide.with(context)
                .load(sport.imgUrl)
                .into(binding.imgPhoto)
        }
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemSportBinding.bind(view)
    }

    class SportDiffCallback: DiffUtil.ItemCallback<Sport>(){
        override fun areItemsTheSame(oldItem: Sport, newItem: Sport): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Sport, newItem: Sport): Boolean = oldItem == newItem
    }


}