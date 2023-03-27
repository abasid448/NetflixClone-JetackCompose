package com.netflix.netflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.netflix.netflix.navigation.MainScreen
import com.netflix.netflix.ui.theme.NetFlixTheme



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