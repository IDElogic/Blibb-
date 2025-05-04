package se.android.blibb.presentation.screen.explore.profile

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDpAsState
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import se.android.blibb.R
import se.android.blibb.navigation.screen.Screen
import se.android.blibb.presentation.component.NeuButton
import se.android.blibb.ui.theme.Blur
import se.android.blibb.ui.theme.Blur2
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_160dp
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_248dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_4dp
import se.android.blibb.ui.theme.DIMENS_90dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_10sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat

@Composable
fun ProfileScreen(
    navController: NavController,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp)
{
    var showDialog by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val myPageUrl = "https://www.iwoio.com/"

    val elevation = animateDpAsState(
        targetValue = 42.dp,
        finishedListener = {}, label = "show_delete_confirm"
    )

    val offset = remember { Animatable(Offset(0f, 0f), Offset.VectorConverter) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        val imageModifier = Modifier
            .fillMaxSize()
            .shadow(elevation = DIMENS_32dp)
        Image(
            modifier = Modifier
                .fillMaxSize()
                .shadow(elevation = DIMENS_32dp)
                .align(Alignment.Center),
            painter = painterResource(id = R.drawable.wall),
            contentDescription = stringResource(R.string.image_on_boarding),
            contentScale = ContentScale.Crop,
            alpha = DefaultAlpha)
        Column(
            modifier = Modifier
                .animateContentSize()
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = DIMENS_20dp)
                ) {
                    Text(
                        text = "Jetpack Compose Playground",
                        color = Ros,
                        fontFamily = GilroyFontFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        letterSpacing = TEXT_SIZE_1sp,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .blur(DIMENS_1dp, BlurredEdgeTreatment.Unbounded)
                    )
                    Text(
                        text = "...in progress",
                        color = wheat.copy(0.86f),
                        fontFamily = GilroyFontFamily,
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TEXT_SIZE_1sp,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(top = DIMENS_32dp, bottom = DIMENS_10dp)
                            .blur(DIMENS_4dp, BlurredEdgeTreatment.Unbounded)
                    )
                }
            Spacer(modifier = Modifier.height(DIMENS_160dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = DIMENS_10dp)
                    .clip(RoundedCornerShape(topStart = DIMENS_20dp, topEnd = DIMENS_20dp, bottomStart = DIMENS_20dp, bottomEnd = DIMENS_20dp))
                    .height(DIMENS_248dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Blur)
                        .padding(horizontal = DIMENS_10dp, vertical = DIMENS_20dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    NeuButton(
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .fillMaxWidth(0.2f)
                            .height(60.dp)
                            .padding(start = DIMENS_4dp)
                            .border(1.dp, MDark, RoundedCornerShape(20.dp)),
                        lightColor = MDark,
                        onClick = {
                            navController.navigate(Screen.Settings.route)
                        }
                    ) {
                        Text(
                            text = "bio",
                            color = wheat,
                            fontFamily = GilroyFontFamily,
                            fontSize = TEXT_SIZE_10sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = TEXT_SIZE_1sp
                        )
                    }
                    NeuButton(
                        shape = RoundedCornerShape(90.dp),
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(60.dp)
                            .padding(start = DIMENS_20dp)
                            .border(1.dp, MDark, RoundedCornerShape(90.dp)),
                        lightColor = MDark,
                        onClick = {
                            navController.navigate("documentation")
                        }
                    )
                    {
                        Text(
                            text = "edu",
                            color = wheat,
                            fontFamily = GilroyFontFamily,
                            fontSize = TEXT_SIZE_10sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = TEXT_SIZE_1sp
                        )
                    }
                    NeuButton(
                        shape = RoundedCornerShape(90.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(start = DIMENS_20dp)
                            .border(1.dp, MSecond, RoundedCornerShape(90.dp)),
                        lightColor = MSecond,
                        onClick = {}
                    ) {
                        Box {
                            Text(
                                text = "exp",
                                color = wheat,
                                fontFamily = GilroyFontFamily,
                                fontSize = TEXT_SIZE_10sp,
                                fontWeight = FontWeight.Medium,
                                letterSpacing = TEXT_SIZE_1sp
                            )
                        }
                    }
                }

            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = DIMENS_10dp)
                    .clip(RoundedCornerShape(topStart = DIMENS_90dp, topEnd = DIMENS_90dp, bottomStart = DIMENS_90dp, bottomEnd = DIMENS_90dp))
                    .height(100.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = DIMENS_10dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    NeuButton(
                        shape = RoundedCornerShape(90.dp),
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(60.dp)
                            .padding(start = DIMENS_4dp)
                            .border(1.dp, Ros, RoundedCornerShape(90.dp)),
                        lightColor = Ros,
                        onClick = {
                            CustomTabsIntent
                                .Builder()
                                .build()
                                .launchUrl(context, myPageUrl.toUri())
                        }
                    ) {
                        Text(
                            text = "Explore min website",
                            color = wheat,
                            fontFamily = GilroyFontFamily,
                            fontSize = TEXT_SIZE_10sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = TEXT_SIZE_1sp
                        )
                    }
                    NeuButton(
                        shape = RoundedCornerShape(90.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(start = DIMENS_20dp)
                            .border(1.dp, MDark, RoundedCornerShape(90.dp)),
                        lightColor = MDark,
                        onClick = {
                            CustomTabsIntent
                                .Builder()
                                .build()
                                .launchUrl(context, Uri.parse(myPageUrl))
                        }
                    )
                    {
                        Text(
                            text = "Share the app",
                            color = wheat,
                            fontFamily = GilroyFontFamily,
                            fontSize = TEXT_SIZE_10sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = TEXT_SIZE_1sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(DIMENS_20dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = DIMENS_10dp)
                    .clip(RoundedCornerShape(topStart = DIMENS_90dp, topEnd = DIMENS_90dp, bottomStart = DIMENS_90dp, bottomEnd = DIMENS_90dp))
                    .border(1.dp, MDark, RoundedCornerShape(90.dp))
                    .height(100.dp),
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .shadow(elevation = DIMENS_32dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.bg_b),
                    contentDescription = stringResource(R.string.image_on_boarding),
                    contentScale = ContentScale.Crop,
                    alpha = DefaultAlpha)

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Blur2)
                        .padding(start = DIMENS_20dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "",
                        color = MSecond.copy(0.66f),
                        fontFamily = GilroyFontFamily,
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TEXT_SIZE_1sp,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .blur(DIMENS_4dp, BlurredEdgeTreatment.Unbounded)
                    )
                    NeuButton(
                        shape = RoundedCornerShape(90.dp),
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(60.dp)
                            .padding(end =  0.dp)
                            .border(1.dp, MDark, RoundedCornerShape(90.dp)),
                        lightColor = MDark,
                        onClick = {
                            navController.navigate("documentation")
                        }
                    )
                    {
                        Text(
                            text = "Open",
                            color = wheat,
                            fontFamily = GilroyFontFamily,
                            fontSize = TEXT_SIZE_10sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = TEXT_SIZE_1sp
                        )
                    }
                }
            }
        }
    }
}





