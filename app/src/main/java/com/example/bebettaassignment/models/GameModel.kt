package com.example.bebettaassignment.models

data class GameModel(
    var gameName: String,          // Name of the game
    var gameIconDrawable: Int,       // Drawable resource ID for the game icon
    var backgroundDrawable: Int, // Drawable resource ID for the game background
    var textColor : Int
)