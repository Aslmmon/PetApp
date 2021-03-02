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
package com.example.androiddevchallenge.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.DogModel
import com.example.androiddevchallenge.ui.theme.ProvideSpace
import com.example.androiddevchallenge.ui.utils.AGE_TITLE
import com.example.androiddevchallenge.ui.utils.AppBarTitle
import com.example.androiddevchallenge.ui.utils.NAME_TITLE
import com.example.androiddevchallenge.ui.utils.NetworkImage

@Composable
fun Home(dogs: List<DogModel>, goToDogDetails: (DogModel) -> Unit) {
    Column {
        ProvideAppBar(AppBarTitle)
        LazyColumn(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxHeight()
        ) {
            itemsIndexed(dogs) { _, dogData ->
                ProvideSpace()
                DogView(dogData, goToDogDetails)
            }
        }
    }
}

@Composable
fun DogView(dogData: DogModel, goToDogDetails: (DogModel) -> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { goToDogDetails(dogData) }

    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(5.dp)) {
            NetworkImage(
                url = dogData.image,
                contentDescription = dogData.brand,
                modifier = Modifier
                    .size(80.dp)
                    .clip(
                        CircleShape
                    )
            )
            Column(modifier = Modifier.padding(5.dp)) {
                Text(text = NAME_TITLE + dogData.name)
                ProvideSpace()
                Text(text = AGE_TITLE + dogData.age.toString())
            }
        }
    }
}

@Composable
fun ProvideAppBar(appBarTitle: String) {
    TopAppBar(title = { Text(text = appBarTitle) })
}
