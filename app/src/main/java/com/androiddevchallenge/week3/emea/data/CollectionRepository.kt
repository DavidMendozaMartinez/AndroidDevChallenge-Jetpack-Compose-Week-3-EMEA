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
package com.androiddevchallenge.week3.emea.data

import com.androiddevchallenge.week3.emea.model.Collection

/**
 * Fake repository
 */
object CollectionRepository {
    fun getFavoriteCollections(): List<Collection> = listOf(
        Collection(
            id = 1,
            name = "Short mantras",
            imageUrl = "https://images.pexels.com/photos/1825206/pexels-photo-1825206.jpeg",
            imageContentDescription = "Body of water view"
        ),
        Collection(
            id = 2,
            name = "Nature meditations",
            imageUrl = "https://images.pexels.com/photos/3571551/pexels-photo-3571551.jpeg",
            imageContentDescription = "Photo of Green Leaves"
        ),
        Collection(
            id = 3,
            name = "Stress and anxiety",
            imageUrl = "https://images.pexels.com/photos/1557238/pexels-photo-1557238.jpeg",
            imageContentDescription = "Aerial View of Body of Water"
        ),
        Collection(
            id = 4,
            name = "Self-massage",
            imageUrl = "https://images.pexels.com/photos/1029604/pexels-photo-1029604.jpeg",
            imageContentDescription = "Photography of Stones"
        ),
        Collection(
            id = 5,
            name = "Overwhelmed",
            imageUrl = "https://images.pexels.com/photos/3560044/pexels-photo-3560044.jpeg",
            imageContentDescription = "White Clouds"
        ),
        Collection(
            id = 6,
            name = "Nightly wind down",
            imageUrl = "https://images.pexels.com/photos/924824/pexels-photo-924824.jpeg",
            imageContentDescription = "Time Lapse Photo of Stars on Night"
        )
    )
}
