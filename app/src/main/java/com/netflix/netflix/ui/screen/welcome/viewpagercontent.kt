package com.netflix.netflix.ui.screen.welcome

import com.netflix.netflix.R

data class PagerData(
    val title: String,
    val description: String,
    val imgUri: Int
)

val itemList = listOf(
    PagerData(
        "Unlimited entertainment,one low price.", "Everything on Netflix,starting at just RS.149",
        R.drawable.a
    ),
    PagerData(
        "Download and watch offline", "Always have something to watch offline.",
        R.drawable.watchanddownolod
    ),
    PagerData(
        "No annoying contracts", "Join today, cancel at any time.",
        R.drawable.contracts
    ),
    PagerData(
        "Watch everywhere",
        "Stream on your phone, tablet, laptop, TV and more.",
        R.drawable.watcheverywhere
    ),
)