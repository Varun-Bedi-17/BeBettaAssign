package com.example.bebettaassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bebettaassignment.R
import com.example.bebettaassignment.databinding.LayoutItemLiveMatchBinding
import com.example.bebettaassignment.models.LiveMatchItemModel

class LiveMatchAdapter :
    ListAdapter<LiveMatchItemModel, LiveMatchAdapter.LiveMatchViewHolder>(LiveMatchDiffCallback()) {


    inner class LiveMatchViewHolder(private val binding: LayoutItemLiveMatchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(
            liveMatchItemDetail: LiveMatchItemModel
        ) {
            binding.apply {
                liveMatchItem = liveMatchItemDetail
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveMatchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: LayoutItemLiveMatchBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.layout_item_live_match, parent, false)

        return LiveMatchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LiveMatchViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

class LiveMatchDiffCallback : DiffUtil.ItemCallback<LiveMatchItemModel>() {
    override fun areItemsTheSame(
        oldItem: LiveMatchItemModel,
        newItem: LiveMatchItemModel,
    ): Boolean = oldItem.firstTeamName == newItem.firstTeamName && oldItem.secondTeamName == newItem.secondTeamName

    override fun areContentsTheSame(
        oldItem: LiveMatchItemModel,
        newItem: LiveMatchItemModel,
    ): Boolean = oldItem == newItem
}

