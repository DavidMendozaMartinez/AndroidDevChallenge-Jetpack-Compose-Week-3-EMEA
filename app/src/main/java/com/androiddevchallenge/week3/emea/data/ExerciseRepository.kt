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

import com.androiddevchallenge.week3.emea.model.Exercise

/**
 * Fake repository
 */
object ExerciseRepository {
    fun getBodyExercises(): List<Exercise> = listOf(
        Exercise(
            id = 1,
            name = "Inversions",
            imageUrl = "https://images.pexels.com/photos/317157/pexels-photo-317157.jpeg",
            imageContentDescription = "Low Angle View of Woman Relaxing on Beach Against Blue Sky"
        ),
        Exercise(
            id = 2,
            name = "Quick yoga",
            imageUrl = "https://images.pexels.com/photos/1812964/pexels-photo-1812964.jpeg",
            imageContentDescription = "Photo of Woman Stretching Her body"
        ),
        Exercise(
            id = 3,
            name = "Stretching",
            imageUrl = "https://images.pexels.com/photos/4056723/pexels-photo-4056723.jpeg",
            imageContentDescription = "Photo Of Women Stretching Together"
        ),
        Exercise(
            id = 4,
            name = "Tabata",
            imageUrl = "https://images.pexels.com/photos/4662438/pexels-photo-4662438.jpeg",
            imageContentDescription = "Man in Black Shorts Doing Yoga"
        ),
        Exercise(
            id = 5,
            name = "HIIT",
            imageUrl = "https://images.pexels.com/photos/999309/pexels-photo-999309.jpeg",
            imageContentDescription = "Man Wearing White Pants Under Blue Sky"
        ),
        Exercise(
            id = 6,
            name = "Pre-natal yoga",
            imageUrl = "https://images.pexels.com/photos/396133/pexels-photo-396133.jpeg",
            imageContentDescription = "Woman Doing Yoga"
        )
    )

    fun getMindExercises(): List<Exercise> = listOf(
        Exercise(
            id = 7,
            name = "Meditate",
            imageUrl = "https://images.pexels.com/photos/3822622/pexels-photo-3822622.jpeg",
            imageContentDescription = "Candles and Incense for Meditation"
        ),
        Exercise(
            id = 8,
            name = "With kids",
            imageUrl = "https://images.pexels.com/photos/3094230/pexels-photo-3094230.jpeg",
            imageContentDescription = "Woman Wearing White Sleeveless Top"
        ),
        Exercise(
            id = 9,
            name = "Aromatherapy",
            imageUrl = "https://images.pexels.com/photos/4498318/pexels-photo-4498318.jpeg",
            imageContentDescription = "Faceless woman practicing ardha padmasana exercise with " +
                "burning natural white sage incense in hand"
        ),
        Exercise(
            id = 10,
            name = "On the go",
            imageUrl = "https://images.pexels.com/photos/1241348/pexels-photo-1241348.jpeg",
            imageContentDescription = "Man Meditating Under Rock"
        ),
        Exercise(
            id = 11,
            name = "With pets",
            imageUrl = "https://images.pexels.com/photos/4056535/pexels-photo-4056535.jpeg",
            imageContentDescription = "Woman meditating with her dog"
        ),
        Exercise(
            id = 12,
            name = "High stress",
            imageUrl = "https://images.pexels.com/photos/897817/pexels-photo-897817.jpeg",
            imageContentDescription = "Man in Blue and Brown Plaid Dress Shirt Touching His Hair"
        )
    )
}
