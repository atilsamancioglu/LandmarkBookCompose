package com.atilsamancioglu.landmarkbookcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.atilsamancioglu.landmarkbookcompose.ui.theme.LandmarkBookComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LandmarkBookComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val landmarkList = ArrayList<Landmark>()
    val pisa = Landmark("Pisa","Italy",R.drawable.pisa)
    val colosseum = Landmark("Colloseum","Italy",R.drawable.colosseum)
    val eiffel = Landmark("Eiffel","France",R.drawable.eiffel)
    val londonBridge = Landmark("London Bridge","UK",R.drawable.londonbridge)
    landmarkList.add(pisa)
    landmarkList.add(colosseum)
    landmarkList.add(eiffel)
    landmarkList.add(londonBridge)

}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    LandmarkBookComposeTheme {
        MainScreen()
    }
}