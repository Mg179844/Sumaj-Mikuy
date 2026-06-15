package com.familytrack.sumajmikuy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.familytrack.sumajmikuy.ui.MainScreen
import com.familytrack.sumajmikuy.ui.theme.SumajMikuyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SumajMikuyTheme {
                MainScreen()
            }
        }
    }
}
