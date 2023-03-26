package com.netflix.netflix.ui.screen.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun MyScreen() {
    val searchText = remember { mutableStateOf("") }
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4")

}