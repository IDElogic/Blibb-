package se.android.blibb.presentation.screen.auth.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import se.android.blibb.R
import se.android.blibb.presentation.screen.auth.data.User
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.wheat

@Composable
fun RegistrationScreen(onRegisterClick: (User) -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var gdprConsent by remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
            ) {
                val imageModifier = Modifier
                    .fillMaxSize()
                    .shadow(elevation = DIMENS_32dp)
                    .blur(0.dp)
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .shadow(elevation = DIMENS_32dp)
                        .align(Alignment.Center)
                        .clip(RoundedCornerShape(0.dp)),
                    painter = painterResource(id = R.drawable.wall),
                    contentDescription = "image_on_boarding",
                    contentScale = ContentScale.Crop,
                    alpha = DefaultAlpha
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(wheat.copy(0.90f))
                        .padding(DIMENS_10dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = {
                            Text(
                                text = "e-mail address"
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = {
                            Text(
                                text = "password"
                            )
                        },
                        visualTransformation = PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = firstname,
                        onValueChange = { firstname = it },
                        label = {
                            Text(
                                text = "first name"
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = lastname,
                        onValueChange = { lastname = it },
                        label = {
                            Text(
                                text = "last name"
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = phone,
                        onValueChange = { phone = it },
                        label = {
                            Text(
                                text = "telephone number"
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = gdprConsent,
                            onCheckedChange = { gdprConsent = it }
                        )
                        Text(
                            text = "I accept the privacy policy."
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(Ros),
                        onClick = {
                            if (gdprConsent) {
                                onRegisterClick(
                                    User(
                                        id = "",
                                        email = email,
                                        password = password,
                                        firstname = firstname,
                                        lastname = lastname,
                                        phone = phone,
                                        gdprConsent = if (gdprConsent) "accepted" else "not accepted"
                                    )
                                )
                            }
                        },
                        enabled = gdprConsent
                    ) {
                        Text("Registration")
                    }
                }
            }
        }
    }}
