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
package com.example.androiddevchallenge.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.DogModel
import com.example.androiddevchallenge.ui.theme.ProvideSpace
import com.example.androiddevchallenge.ui.utils.NetworkImage

@Composable
fun DogDetails( selectedDog: DogModel?) {
    Scaffold {

        val modifier = Modifier.padding(10.dp)
        Column(modifier = modifier) {
            NetworkImage(
                url = selectedDog?.image.toString(),
                contentDescription = selectedDog?.brand,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
            )
            ProvideSpace()
            Text(text = selectedDog?.name.toString())
            ProvideSpace()
            Text(text = selectedDog?.brand.toString())
        }
    }
}
