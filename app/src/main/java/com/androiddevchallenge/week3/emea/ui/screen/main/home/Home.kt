/*
 * Copyright 2022 The Android Open Source Project
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
package com.androiddevchallenge.week3.emea.ui.screen.main.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.androiddevchallenge.week3.emea.R
import com.androiddevchallenge.week3.emea.data.CollectionRepository
import com.androiddevchallenge.week3.emea.data.ExerciseRepository
import com.androiddevchallenge.week3.emea.model.Collection
import com.androiddevchallenge.week3.emea.model.Exercise
import com.androiddevchallenge.week3.emea.ui.theme.MySootheTheme

@Composable
fun Home() {
    var query by remember { mutableStateOf("") }

    Column(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
        Spacer(modifier = Modifier.height(56.dp))

        TextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            label = {
                Text(
                    text = stringResource(id = R.string.home_label_search),
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.body1
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp),
                    tint = MaterialTheme.colors.onSurface
                )
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            singleLine = true,
            shape = MaterialTheme.shapes.small,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface
            )
        )

        Column(
            modifier = Modifier
                .padding(top = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(id = R.string.home_title_favorite).uppercase(),
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                    .padding(start = 16.dp),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.h2
            )

            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                modifier = Modifier.height(120.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = CollectionRepository.getFavoriteCollections(),
                    key = { it.id }
                ) {
                    CollectionItem(
                        collection = it,
                        onCollectionClicked = {}
                    )
                }
            }

            Text(
                text = stringResource(id = R.string.home_title_body).uppercase(),
                modifier = Modifier
                    .paddingFromBaseline(top = 48.dp, bottom = 8.dp)
                    .padding(start = 16.dp),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.h2
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = ExerciseRepository.getBodyExercises(),
                    key = { it.id }
                ) {
                    ExerciseItem(
                        exercise = it,
                        onExerciseClicked = {}
                    )
                }
            }

            Text(
                text = stringResource(id = R.string.home_title_mind).uppercase(),
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                    .padding(start = 16.dp),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.h2
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = ExerciseRepository.getMindExercises(),
                    key = { it.id }
                ) {
                    ExerciseItem(
                        exercise = it,
                        onExerciseClicked = {}
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CollectionItem(
    collection: Collection,
    onCollectionClicked: (Collection) -> Unit = {}
) {
    Card(
        onClick = { onCollectionClicked(collection) },
        modifier = Modifier.size(192.dp, 56.dp),
        shape = MaterialTheme.shapes.small,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 0.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberAsyncImagePainter(collection.imageUrl),
                contentDescription = null,
                modifier = Modifier.size(56.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = collection.name,
                modifier = Modifier.padding(horizontal = 16.dp),
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.h3
            )
        }
    }
}

@Composable
fun ExerciseItem(
    exercise: Exercise,
    onExerciseClicked: (Exercise) -> Unit = {}
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = rememberAsyncImagePainter(exercise.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
                .clickable { onExerciseClicked(exercise) },
            contentScale = ContentScale.Crop
        )

        Text(
            text = exercise.name,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h3
        )
    }
}

@Preview(name = "Light Theme", widthDp = 360, heightDp = 640, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark Theme", widthDp = 360, heightDp = 640, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomePreview() {
    MySootheTheme {
        Home()
    }
}
