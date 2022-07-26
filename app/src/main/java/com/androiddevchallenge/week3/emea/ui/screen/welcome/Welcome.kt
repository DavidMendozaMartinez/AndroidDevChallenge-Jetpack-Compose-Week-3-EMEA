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
package com.androiddevchallenge.week3.emea.ui.screen.welcome

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androiddevchallenge.week3.emea.R
import com.androiddevchallenge.week3.emea.ui.theme.MySootheTheme

@Composable
fun Welcome(
    onSignUpClicked: () -> Unit = {},
    onLogInClicked: () -> Unit = {}
) {
    Box(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
        Image(
            painter = painterResource(id = R.drawable.bg_welcome),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logotype),
                contentDescription = stringResource(id = R.string.app_name)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onSignUpClicked,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                )
            ) {
                Text(
                    text = stringResource(id = R.string.welcome_button_sign_up).uppercase(),
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.button
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onLogInClicked,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary
                )
            ) {
                Text(
                    text = stringResource(id = R.string.welcome_button_log_in).uppercase(),
                    color = MaterialTheme.colors.onSecondary,
                    style = MaterialTheme.typography.button
                )
            }
        }
    }
}

@Preview(name = "Light Theme", widthDp = 360, heightDp = 640, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark Theme", widthDp = 360, heightDp = 640, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun WelcomePreview() {
    MySootheTheme {
        Welcome()
    }
}
