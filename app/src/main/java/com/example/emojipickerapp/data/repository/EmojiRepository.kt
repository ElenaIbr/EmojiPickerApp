package com.example.emojipickerapp.data.repository

import android.content.Context
import com.example.emojipickerapp.data.local.EmojiLoader
import com.example.emojipickerapp.data.model.EmojiEntry

class EmojiRepository(private val context: Context) {
    fun loadEmojis(): List<EmojiEntry> {
        return EmojiLoader.loadFromAssets(context)
    }
}
