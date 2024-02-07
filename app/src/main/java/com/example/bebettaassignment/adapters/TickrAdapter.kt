package com.example.bebettaassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bebettaassignment.R
import com.example.bebettaassignment.databinding.LayoutTickrItemBinding
import com.example.bebettaassignment.models.TickrModel

class TickrAdapter :
    ListAdapter<TickrModel, TickrAdapter.TickrViewHolder>(TickrDiffCallback()) {


    inner class TickrViewHolder(private val binding: LayoutTickrItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(
            tickrModel: TickrModel
        ) {
            binding.apply {
                tickrModelItem = tickrModel
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TickrViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: LayoutTickrItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.layout_tickr_item, parent, false)

        return TickrViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TickrViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

class TickrDiffCallback : DiffUtil.ItemCallback<TickrModel>() {
    override fun areItemsTheSame(
        oldItem: TickrModel,
        newItem: TickrModel,
    ): Boolean = oldItem.name == newItem.name

    override fun areContentsTheSame(
        oldItem: TickrModel,
        newItem: TickrModel,
    ): Boolean = oldItem == newItem
}

