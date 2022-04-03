package com.artemissoftware.narutoglossary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.artemissoftware.narutoglossary.navigation.SetupNavGraph
import com.artemissoftware.narutoglossary.ui.theme.NarutoGlossaryTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NarutoGlossaryTheme {

                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}

