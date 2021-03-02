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
package com.example.androiddevchallenge.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Parcelize
@Immutable
data class DogModel(
    val name: String,
    val brand: String,
    val image: String,
    var id: Long
) : Parcelable

/**
 * A fake repo
 */
object DogRepo {
    fun getDogsDetails(dogID: Long): DogModel = dogs.find { it.id == dogID }!!
}

val dogs = listOf(
    DogModel(
        name = "First Dog ",
        brand = "Test 1",
        image = "https://images.dog.ceo/breeds/husky/n02110185_4522.jpg",
        id = 1
    ),
    DogModel(
        name = "Second Dog ",
        brand = "Test 2",
        image = "https://images.dog.ceo/breeds/saluki/n02091831_10823.jpg",
        id = 2
    ),
    DogModel(
        name = "Third Dog",
        brand = "Test 3",
        image = "https://images.dog.ceo/breeds/eskimo/n02109961_3946.jpg",
        id = 3
    ),
    DogModel(
        name = "Fourth Dog  ",
        brand = "Test 3",
        image = "https://images.dog.ceo/breeds/terrier-tibetan/n02097474_6113.jpg",
        id = 3
    ),
    DogModel(
        name = "Fifth Dog ",
        brand = "Test 3",
        image = "https://images.dog.ceo/breeds/briard/n02105251_7115.jpg",
        id = 3
    ),
    DogModel(
        name = "Fifth Dog ",
        brand = "Test 3",
        image = "https://images.dog.ceo/breeds/briard/n02105251_7115.jpg",
        id = 3
    ),
    DogModel(
        name = "Fifth Dog ",
        brand = "Test 3",
        image = "https://images.dog.ceo/breeds/briard/n02105251_7115.jpg",
        id = 3
    ),
    DogModel(
        name = "Fifth Dog ",
        brand = "Test 3",
        image = "https://images.dog.ceo/breeds/briard/n02105251_7115.jpg",
        id = 3
    ),
    DogModel(
        name = "Fifth Dog ",
        brand = "Test 3",
        image = "https://images.dog.ceo/breeds/briard/n02105251_7115.jpg",
        id = 3
    ),
    DogModel(
        name = "Fifth Dog ",
        brand = "Test 3",
        image = "https://images.dog.ceo/breeds/briard/n02105251_7115.jpg",
        id = 3
    ),
    DogModel(
        name = "Fifth Dog ",
        brand = "Test 3",
        image = "https://images.dog.ceo/breeds/briard/n02105251_7115.jpg",
        id = 3
    ),
    DogModel(
        name = "Fifth Dog ",
        brand = "Test 3",
        image = "https://images.dog.ceo/breeds/briard/n02105251_7115.jpg",
        id = 3
    ),

)
