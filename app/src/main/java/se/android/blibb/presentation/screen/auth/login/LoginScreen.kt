package se.android.blibb.presentation.screen.auth.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import se.android.blibb.R
import se.android.blibb.presentation.component.NeuButton
import se.android.blibb.presentation.screen.auth.registration.UserViewModel
import se.android.blibb.ui.theme.Black
import se.android.blibb.ui.theme.Blur
import se.android.blibb.ui.theme.Blur5
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_130dp
import se.android.blibb.ui.theme.DIMENS_140dp
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_2dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_48dp
import se.android.blibb.ui.theme.DIMENS_4dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.TEXT_SIZE_10sp
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat
import se.android.blibb.ui.theme.Ros

@Composable
fun LoginScreen(
    userViewModel: UserViewModel,
    onRegisterClick: () -> Unit,
    onLoginSuccess: (Boolean) -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginState by userViewModel.loginState.collectAsState()

    LaunchedEffect(loginState) {
        val currentState = loginState
        when (currentState) {
            is LoginState.Success -> onLoginSuccess(currentState.isAdmin)
            else -> {}
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            val imageModifier = Modifier
                .fillMaxSize()
                .shadow(elevation = DIMENS_32dp)
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = R.drawable.wall),
                contentDescription = "image_on_boarding",
                contentScale = ContentScale.Crop,
                alpha = DefaultAlpha)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Card(
                    shape = CardDefaults.elevatedShape,
                    colors = CardDefaults.cardColors(Color.Transparent),
                    modifier = Modifier
                        .fillMaxWidth(0.68f)
                        .height(DIMENS_140dp)
                        .padding(start = DIMENS_20dp, end = DIMENS_2dp)
                        .padding(top = DIMENS_48dp))
                {
                    Text(
                        text = "Jetpack Compose Playground",
                        textAlign = TextAlign.Center,
                        style = LocalTextStyle.current.copy(
                            color = wheat,
                            fontFamily = GilroyFontFamily,
                            fontWeight = FontWeight.Black,
                            fontSize = 20.sp
                        ),
                        letterSpacing = TEXT_SIZE_1sp,
                        modifier = Modifier
                            .padding(DIMENS_20dp))
                }
                Card(
                    shape = CardDefaults.outlinedShape,
                    colors = CardDefaults.cardColors(Blur5),
                    border = BorderStroke(DIMENS_1dp,Ros),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(DIMENS_140dp)
                        .padding(start = DIMENS_2dp, end = DIMENS_20dp)
                        .padding(top = DIMENS_32dp))
                {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(0.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            colorFilter = ColorFilter.tint(wheat),
                            painter = painterResource(id = R.drawable.baseline_qr_code_24),
                            contentDescription = "attached-file",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(0.dp)
                                .size(DIMENS_32dp)
                        )
                    }
                }
            }

            Card(
                shape = CardDefaults.elevatedShape,
                colors = CardDefaults.cardColors(Blur),
                border = BorderStroke(DIMENS_1dp,wheat),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = DIMENS_20dp)
                    .padding(top = 148.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Blur)
                        .padding(horizontal = DIMENS_20dp)
                        .padding(vertical = DIMENS_130dp),
                ) {
                    Column(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Welcome Back!",
                            textAlign = TextAlign.Start,
                            style = LocalTextStyle.current.copy(
                                color = MDark,
                                fontFamily = GilroyFontFamily,
                                fontWeight = FontWeight.Black,
                                fontSize = 20.sp
                            ),
                            letterSpacing = TEXT_SIZE_1sp,
                            modifier = Modifier
                                .padding(bottom = DIMENS_20dp)

                        )
                        Text(
                            text = "Get started for free.",
                            textAlign = TextAlign.Start,
                            style = LocalTextStyle.current.copy(
                                color = MDark,
                                fontFamily = GilroyFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp
                            ),
                            letterSpacing = TEXT_SIZE_1sp,
                            modifier = Modifier
                                .padding(bottom = DIMENS_32dp)
                        )
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = {
                                Text(
                                    text = "e-mail address",
                                    color = MDark,
                                    fontFamily = GilroyFontFamily,
                                    fontSize = TEXT_SIZE_10sp,
                                    fontWeight = FontWeight.Normal,
                                    letterSpacing = TEXT_SIZE_1sp
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(DIMENS_4dp))
                        )
                        Spacer(modifier = Modifier.height(DIMENS_16dp))
                        OutlinedTextField(
                            colors = OutlinedTextFieldDefaults.colors(Black.copy(0.66f)),
                            value = password,
                            onValueChange = { password = it },
                            label = {
                                Text(
                                    text = "password",
                                    color = MDark,
                                    fontFamily = GilroyFontFamily,
                                    fontSize = TEXT_SIZE_10sp,
                                    fontWeight = FontWeight.Normal,
                                    letterSpacing = TEXT_SIZE_1sp
                                )
                            },
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(DIMENS_4dp))
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = DIMENS_20dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(
                                text = "Forgot password?",
                                color = MDark,
                                style = LocalTextStyle.current.copy(
                                    color = MDark,
                                    fontFamily = GilroyFontFamily,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp
                                ),
                                letterSpacing = TEXT_SIZE_1sp,)
                        }
                        Spacer(modifier = Modifier.height(DIMENS_20dp))
                        NeuButton(
                            shape = RoundedCornerShape(90.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .padding(DIMENS_10dp)
                                .border(1.dp, Ros, RoundedCornerShape(90.dp)),
                            lightColor = Ros,
                            onClick = { userViewModel.login(email, password) },
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Sign in",
                                    color = wheat,
                                    fontFamily = GilroyFontFamily,
                                    fontSize = TEXT_SIZE_12sp,
                                    fontWeight = FontWeight.SemiBold,
                                    letterSpacing = TEXT_SIZE_1sp
                                )
                                Spacer(modifier = Modifier.width(DIMENS_8dp))
                                Icon(
                                    modifier = Modifier
                                        .size(DIMENS_20dp),
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "arrow_right",
                                    tint = wheat)
                            }
                        }
                        when (loginState) {
                            is LoginState.Error -> {
                                Text(
                                    text = (loginState as LoginState.Error).message,
                                    color = wheat.copy(0.66f),
                                    fontFamily = GilroyFontFamily,
                                    fontSize = TEXT_SIZE_10sp,
                                    fontWeight = FontWeight.Normal,
                                    letterSpacing = TEXT_SIZE_1sp
                                )
                            }
                            LoginState.Loading -> {
                                CircularProgressIndicator()
                            }
                            else -> {}
                        }
                        if (loginState is LoginState.Error) {
                            Text(
                                text = (loginState as LoginState.Error).message,
                                color = wheat.copy(0.66f),
                                fontFamily = GilroyFontFamily,
                                fontSize = TEXT_SIZE_10sp,
                                fontWeight = FontWeight.Normal,
                                letterSpacing = TEXT_SIZE_1sp,
                                modifier = Modifier
                                    .padding(top = 8.dp))
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = DIMENS_20dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            TextButton(onClick = onRegisterClick) {
                                Text(
                                    "New to The Platform?",
                                    style = LocalTextStyle.current.copy(
                                        color = MDark,
                                        fontFamily = GilroyFontFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 12.sp
                                    ),
                                    letterSpacing = TEXT_SIZE_1sp,
                                )
                            }
                            TextButton(onClick = onRegisterClick) {
                                Text(
                                    "Sign Up!",
                                    style = LocalTextStyle.current.copy(
                                        color = MDark,
                                        fontFamily = GilroyFontFamily,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 12.sp
                                    ),
                                    letterSpacing = TEXT_SIZE_1sp,
                                )
                            }
                        }
                    } }
            }
        }
    }
}