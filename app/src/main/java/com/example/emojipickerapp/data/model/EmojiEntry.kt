package com.example.emojipickerapp.data.model
import kotlinx.serialization.Serializable

@Serializable
data class EmojiEntry(
    val emoji: String,
    val description: String,
    val group: String,
    val subcategory: String
)
