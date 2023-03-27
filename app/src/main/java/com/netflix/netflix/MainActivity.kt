package com.netflix.netflix

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.netflix.netflix.Repository.MoviesRepository
import com.netflix.netflix.navigation.MainScreen
import com.netflix.netflix.ui.screen.fastlaughs.FastLaughPageUi
import com.netflix.netflix.ui.screen.fastlaughs.FastLaughScreen
import com.netflix.netflix.ui.screen.home.HomeScreen
import com.netflix.netflix.ui.screen.home.HomeScreenTopBar
import com.netflix.netflix.ui.screen.welcome.WelcomeScreen
import com.netflix.netflix.ui.theme.NetFlixTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetFlixTheme {
                MainScreen()

            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}