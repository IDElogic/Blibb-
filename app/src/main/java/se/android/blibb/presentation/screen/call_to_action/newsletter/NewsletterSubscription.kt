package se.android.blibb.presentation.screen.call_to_action.newsletter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import se.android.blibb.R
import se.android.blibb.ui.theme.DIMENS_108dp
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_2dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_90dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat
import se.android.blibb.ui.theme.zuzmo


@Composable
fun NewsletterSubscription(
    viewModel: NewsletterViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold()
    { paddingvalues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingvalues)
                .background(wheat)
        ) {

            Column(
                modifier = Modifier
                    .background(wheat)
                    .padding(horizontal = DIMENS_20dp)
                    .padding(top = DIMENS_108dp, bottom = DIMENS_10dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // isError logic
                OutlinedTextField(
                    value = uiState.email,
                    onValueChange = { newEmail ->
                        viewModel.onEmailChange(newEmail) //Let's send the new email.
                    },
                    label = {
                        Text(
                            text = "Email address",
                            style = LocalTextStyle.current.copy(
                                color = MDark,
                                fontFamily = GilroyFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 10.sp
                            ),
                            letterSpacing = TEXT_SIZE_1sp,
                        )
                    },
                    shape = OutlinedTextFieldDefaults.shape,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    isError = uiState.email.isNotBlank() && !uiState.isEmailValid,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                if (uiState.email.isNotBlank() && !uiState.isEmailValid) {
                    Text(
                        modifier = Modifier
                            .padding(top = DIMENS_2dp),
                        text = "Invalid email address",
                        textAlign = TextAlign.End,
                        style = LocalTextStyle.current.copy(
                            color = Ros,
                            fontFamily = GilroyFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 10.sp
                        ),
                        letterSpacing = TEXT_SIZE_1sp,
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(Ros),
                    onClick = { viewModel.subscribe() },
                    enabled = uiState.isEmailValid && !uiState.isLoading,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .align(Alignment.CenterHorizontally)
                        .height(62.dp)
                ) {
                    if (uiState.isLoading) {
                        CircularProgressIndicator(
                            color = Ros,
                            strokeWidth = 2.dp,
                            modifier = Modifier.size(24.dp)
                        )
                    } else {
                        Text(
                            modifier = Modifier,
                            text = "Subscription",
                            textAlign = TextAlign.End,
                            style = LocalTextStyle.current.copy(
                                color = MDark,
                                fontFamily = GilroyFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp
                            ),
                            letterSpacing = TEXT_SIZE_1sp,
                        )
                    }
                }

                if (uiState.isSubscribed) {
                    Text(
                        text = "✓ Successful subscription!",
                        textAlign = TextAlign.End,
                        style = LocalTextStyle.current.copy(
                            color = zuzmo,
                            fontFamily = GilroyFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp
                        ),
                        letterSpacing = TEXT_SIZE_1sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                uiState.error?.let { error ->
                    Text(
                        text = "Error: $error",
                        textAlign = TextAlign.End,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(top = 8.dp),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            ProductBackground(
                Modifier
                    .padding(20.dp)
            )

        }
    }
}


    @Composable
    private fun ProductBackground(
        modifier: Modifier = Modifier
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
        )
        {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = DIMENS_10dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )
            {
                Column(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                )
                {
                    Text(
                        textAlign = TextAlign.Justify,
                        text = "Sign up for the Newsletter",
                        color = MDark,
                        fontFamily = GilroyFontFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = TEXT_SIZE_1sp,
                        modifier = Modifier
                    )
                    Image(
                        colorFilter = ColorFilter.tint(Ros),
                        painter = painterResource(id = R.drawable.feather),
                        contentDescription = "attached-file",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(0.dp)
                            .size(DIMENS_32dp),
                    )

                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .height(DIMENS_90dp)
                .padding(start = DIMENS_10dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceAround
        )
        {}
    }




