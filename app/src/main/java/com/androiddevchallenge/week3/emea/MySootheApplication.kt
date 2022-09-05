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
package com.androiddevchallenge.week3.emea

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.compose.rememberImagePainter
import com.androiddevchallenge.week3.emea.ui.utils.PexelsSizingInterceptor

@Suppress("unused")
class MySootheApplication : Application(), ImageLoaderFactory {

    /**
     * Create the singleton [ImageLoader].
     * This is used by [rememberImagePainter] to load images in the app.
     */
    override fun newImageLoader(): ImageLoader = ImageLoader.Builder(this)
        .components {
            add(PexelsSizingInterceptor)
        }
        .build()
}
