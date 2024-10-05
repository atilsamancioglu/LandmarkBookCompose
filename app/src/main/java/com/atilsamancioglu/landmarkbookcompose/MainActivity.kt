package com.atilsamancioglu.landmarkbookcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.atilsamancioglu.landmarkbookcompose.ui.theme.LandmarkBookComposeTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {

    private val landmarkList = ArrayList<Landmark>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            LandmarkBookComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ) {

                        NavHost(
                            navController = navController,
                            startDestination = "list_screen"
                        ) {
                            composable("list_screen") {
                                getData()
                                LandmarkList(landmarks = landmarkList,navController = navController)
                            }
                            composable(
                                "details_screen/{landmark}",
                                arguments = listOf(
                                    navArgument("landmark") {
                                        type = NavType.StringType
                                    }
                                )
                            ) {
                                val landmarkString = remember {
                                    it.arguments?.getString("landmark")
                                }

                                val chosenLandmark = Gson().fromJson(landmarkString, Landmark::class.java)

                                DetailScreen(
                                    landmark = chosenLandmark
                                )

                            }
                        }


                    }
                }
            }
        }

    }


    private fun getData() {
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
    }
}
