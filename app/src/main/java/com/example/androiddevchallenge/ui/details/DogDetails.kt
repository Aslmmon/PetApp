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
import com.example.androiddevchallenge.ui.utils.AGE_TITLE
import com.example.androiddevchallenge.ui.utils.DOG_BRAND
import com.example.androiddevchallenge.ui.utils.NAME_TITLE
import com.example.androiddevchallenge.ui.utils.NetworkImage

@Composable
fun DogDetails(selectedDog: DogModel?) {
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
            ProviderDataAsPoints(text = NAME_TITLE + selectedDog?.name.toString())
            ProviderDataAsPoints(text = DOG_BRAND + selectedDog?.brand.toString())
            ProviderDataAsPoints(text = AGE_TITLE + selectedDog?.age.toString())
        }
    }
}

@Composable
fun ProviderDataAsPoints(text: String) {
    ProvideSpace()
    Text(text = text)
}
