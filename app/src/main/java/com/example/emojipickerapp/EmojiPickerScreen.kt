package com.example.emojipickerapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.emojipickerapp.data.local.EmojiLoader
import com.example.emojipickerapp.data.model.EmojiEntry

@Composable
fun EmojiPickerScreen() {
    val context = LocalContext.current
    var allEmojis by remember { mutableStateOf<List<EmojiEntry>>(emptyList()) }
    var query by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        allEmojis = EmojiLoader.loadFromAssets(context)
    }

    val filtered = remember(allEmojis, query) {
        allEmojis.filter {
            it.description.contains(
                query,
                ignoreCase = true
            )
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Search emoji...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(6),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(filtered) { emoji ->
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxWidth()
                        .clickable {
                            Toast
                                .makeText(
                                    context,
                                    emoji.emoji,
                                    Toast.LENGTH_SHORT
                                ).show()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = emoji.emoji,
                        fontSize = 28.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
