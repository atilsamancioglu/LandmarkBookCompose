package com.atilsamancioglu.landmarkbookcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atilsamancioglu.landmarkbookcompose.ui.theme.LandmarkBookComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LandmarkBookComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        MainScreen()

                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val landmarkList = ArrayList<Landmark>()
    val pisa = Landmark("Pisa","Italy",R.drawable.pisa)
    val colosseum = Landmark("Colloseum","Italy",R.drawable.colosseum)
    val eiffel = Landmark("Eiffel","France",R.drawable.eiffel)
    val londonBridge = Landmark("London Bridge","UK",R.drawable.londonbridge)
    landmarkList.add(pisa)
    landmarkList.add(colosseum)
    landmarkList.add(eiffel)
    landmarkList.add(londonBridge)
    landmarkList.add(pisa)
    landmarkList.add(colosseum)
    landmarkList.add(eiffel)
    landmarkList.add(londonBridge)
    landmarkList.add(pisa)
    landmarkList.add(colosseum)
    landmarkList.add(eiffel)
    landmarkList.add(londonBridge)

    CryptoList(landmarks = landmarkList)

}


@Composable
fun CryptoList(landmarks: List<Landmark>) {
    LazyColumn(contentPadding = PaddingValues(5.dp),
    modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.primaryContainer))
     {
        items(landmarks) {
            LandmarkRow(landmark = it)
        }
    }
}

@Composable
fun LandmarkRow(landmark: Landmark) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.primaryContainer)) {
        Text(text = landmark.name,
            //color = MaterialTheme.colorScheme.surfaceContainerLow,
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(2.dp),
            fontWeight = FontWeight.Bold
        )
        Text(text = landmark.country,
            //color = MaterialTheme.colorScheme.surfaceContainerHigh,
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(2.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    LandmarkBookComposeTheme {
        MainScreen()
    }
}