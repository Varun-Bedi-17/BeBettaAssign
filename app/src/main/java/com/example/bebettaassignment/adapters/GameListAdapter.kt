package com.example.bebettaassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bebettaassignment.R
import com.example.bebettaassignment.databinding.LayoutGameItemBinding
import com.example.bebettaassignment.models.GameModel

class GameListAdapter(private val onItemClickListener: OnItemClickListener) :
    ListAdapter<GameModel, GameListAdapter.GameListViewHolder>(GameItemDiffCallback()) {


    inner class GameListViewHolder(private val binding: LayoutGameItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(
            game: GameModel,
            onItemClickListener: OnItemClickListener,
        ) {
            binding.apply {
                gameModel = game
                cvGame.setOnClickListener {
                    onItemClickListener.onItemClickCallback(game.gameName)
                }
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: LayoutGameItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.layout_game_item, parent, false)

        return GameListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameListViewHolder, position: Int) {
        holder.onBind(getItem(position), onItemClickListener)
    }

    interface OnItemClickListener {
        fun onItemClickCallback(title: String)
    }
}

class GameItemDiffCallback : DiffUtil.ItemCallback<GameModel>() {
    override fun areItemsTheSame(oldItem: GameModel, newItem: GameModel): Boolean =
        oldItem.gameName == newItem.gameName

    override fun areContentsTheSame(
        oldItem: GameModel,
        newItem: GameModel,
    ): Boolean = oldItem == newItem
}

