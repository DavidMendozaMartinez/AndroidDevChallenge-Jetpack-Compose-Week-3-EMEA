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
package com.androiddevchallenge.week3.emea.ui.screen.login

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androiddevchallenge.week3.emea.R
import com.androiddevchallenge.week3.emea.ui.theme.MySootheTheme

@Composable
fun LogIn() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
        Image(
            painter = painterResource(id = R.drawable.bg_log_in),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.log_in_title).uppercase(),
                modifier = Modifier.paddingFromBaseline(top = 200.dp, bottom = 32.dp),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.h1
            )

            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = stringResource(id = R.string.log_in_label_email),
                        color = MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.body1
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                shape = MaterialTheme.shapes.small,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = stringResource(id = R.string.log_in_label_password),
                        color = MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.body1
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                shape = MaterialTheme.shapes.small,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                )
            ) {
                Text(
                    text = stringResource(id = R.string.log_in_button_log_in).uppercase(),
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.button
                )
            }

            val account = stringResource(id = R.string.log_in_account)
            val signUp = stringResource(id = R.string.log_in_account_sign_up)

            val annotatedText = buildAnnotatedString {
                append(account)

                val start = account.indexOf(signUp)
                val end = start + signUp.length
                addStringAnnotation(tag = signUp, annotation = signUp, start = start, end = end)
                addStyle(style = SpanStyle(textDecoration = TextDecoration.Underline), start = start, end = end)
            }

            ClickableText(
                text = annotatedText,
                modifier = Modifier.paddingFromBaseline(top = 32.dp),
                style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onBackground)
            ) { offset ->
                annotatedText.getStringAnnotations(start = offset, end = offset).firstOrNull()?.let { annotation ->
                    when (annotation.tag) {
                        signUp -> {}
                    }
                }
            }
        }
    }
}

@Preview(name = "Light Theme", widthDp = 360, heightDp = 640, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark Theme", widthDp = 360, heightDp = 640, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LogInPreview() {
    MySootheTheme {
        LogIn()
    }
}
