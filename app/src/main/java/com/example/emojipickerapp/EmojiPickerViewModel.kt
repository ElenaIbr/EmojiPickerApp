package com.example.emojipickerapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.emojipickerapp.data.model.EmojiEntry
import com.example.emojipickerapp.data.repository.EmojiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EmojiPickerViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = EmojiRepository(application)

    private val _emojis = MutableStateFlow<List<EmojiEntry>>(emptyList())
    val emojis: StateFlow<List<EmojiEntry>> = _emojis

    init {
        viewModelScope.launch {
            _emojis.value = repository.loadEmojis()
        }
    }
}
