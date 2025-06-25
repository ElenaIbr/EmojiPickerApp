package com.example.emojipickerapp.data.local

import android.content.Context
import com.example.emojipickerapp.data.model.EmojiEntry
import kotlinx.serialization.json.Json


object EmojiLoader {
    fun loadFromAssets(context: Context): List<EmojiEntry> {
        val json = context.assets.open("emojis.json").bufferedReader().use { it.readText() }
        return Json.decodeFromString(json)
    }
}
