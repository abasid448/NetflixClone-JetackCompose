package com.netflix.netflix.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.netflix.netflix.presentation.movielist.screen.welcome.WelcomeScreen



class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            WelcomeScreen()
        }
    }
}