/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.model.DogModel
import com.example.androiddevchallenge.model.dogs
import com.example.androiddevchallenge.ui.details.DogDetails
import com.example.androiddevchallenge.ui.main.Home
import com.example.androiddevchallenge.ui.utils.MainDestinations.DOG_ID

object MainDestinations {
    const val Home_ROUTE = "home"
    const val Dog_Details_Route = "DogDetails"
    const val DOG_ID = "dogId"
}

/**
 * we have here two screens presented in Navigation Graph :
 */

@Composable
fun NavGraph(startDestination: String = MainDestinations.Home_ROUTE) {
    val navController = rememberNavController()
    val actions = remember(navController) { Navigation(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.Home_ROUTE) {
            Home(goToDogDetails = actions.selectDog, dogs = dogs)
        }

        composable(
            MainDestinations.Dog_Details_Route,
            arguments = listOf(navArgument(DOG_ID) { type = NavType.LongType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            DogDetails(
                selectedDog = arguments.getParcelable(DETAILS_DOG),
            )
        }
    }
}

/**
 * Models the navigation actions in the app.
 */
class Navigation(navController: NavHostController) {

    val selectDog: (DogModel) -> Unit = { dogModel: DogModel ->
        navController.navigate(MainDestinations.Dog_Details_Route)
        navController.currentBackStackEntry?.arguments?.putParcelable(DETAILS_DOG, dogModel)
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
