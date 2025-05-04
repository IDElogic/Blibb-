package se.android.blibb.presentation.screen.startscreen

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Attachment
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import se.android.blibb.R
import se.android.blibb.navigation.screen.BottomNavItemScreen
import se.android.blibb.navigation.screen.Screen
import se.android.blibb.presentation.component.NeuButton
import se.android.blibb.presentation.screen.auth.navigation.AuthScreen
import se.android.blibb.presentation.screen.auth.registration.UserViewModel
import se.android.blibb.ui.theme.Black
import se.android.blibb.ui.theme.Blur
import se.android.blibb.ui.theme.Blur2
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_12dp
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_24dp
import se.android.blibb.ui.theme.DIMENS_2dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_4dp
import se.android.blibb.ui.theme.DIMENS_80dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.DIMENS_90dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_10sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat
import se.android.blibb.ui.theme.zuzmo

@SuppressLint("SuspiciousIndentation")
@Composable
fun StartScreen(
    userViewModel: UserViewModel,
    navController: NavController,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
)
{
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val elevation = animateDpAsState(
        targetValue = 42.dp,
        finishedListener = {}, label = "show_delete_confirm"
    )

    Scaffold(
        modifier = Modifier,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MSecond)
                    .padding(paddingValues),
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                        .clip(
                            RoundedCornerShape(
                                bottomStart = DIMENS_80dp,
                                bottomEnd = DIMENS_80dp
                            )
                        ),
                    painter = painterResource(id = R.drawable.wall),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    alpha = DefaultAlpha
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = DIMENS_12dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(
                                    topStart = 0.dp,
                                    topEnd = 0.dp,
                                    bottomStart = DIMENS_90dp,
                                    bottomEnd = DIMENS_90dp
                                )
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .background(Blur2)
                                .padding(start = DIMENS_20dp, end = DIMENS_20dp)
                                .padding(bottom = DIMENS_20dp, top = DIMENS_32dp)

                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = DIMENS_10dp)
                            ) {
                                NeuButton(
                                    shape = RoundedCornerShape(90.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(70.dp)
                                        .border(1.dp, MSecond, RoundedCornerShape(90.dp))
                                        .clickable(
                                            enabled = true,
                                            onClick = {
                                                navController.navigate(route = BottomNavItemScreen.Cart.route)
                                            }
                                        ),
                                    lightColor = MSecond,
                                    onClick = {
                                        navController.navigate(route = BottomNavItemScreen.Cart.route)
                                    }
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Spacer(
                                            modifier = Modifier
                                                .weight(0.5f)
                                        )
                                        Icon(
                                            modifier = Modifier
                                                .size(DIMENS_20dp)
                                                .clickable {
                                                    navController.navigate(Screen.Settings.route)
                                                },
                                            imageVector = Icons.Default.Settings,
                                            contentDescription = "arrow_right",
                                            tint = wheat.copy(0.66f)
                                        )
                                        Spacer(
                                            modifier = Modifier
                                                .weight(1f)
                                        )
                                        Text(
                                            text = "Jetpack Compose Playground",
                                            style = MaterialTheme.typography.labelLarge.copy(
                                                color = wheat.copy(0.86f),
                                                fontFamily = GilroyFontFamily,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                        )
                                        Spacer(
                                            modifier = Modifier
                                                .weight(1f)
                                        )
                                        Icon(
                                            modifier = Modifier
                                                .size(DIMENS_20dp)
                                                .clickable {
                                                    navController.navigate("documentation")
                                                },
                                            imageVector = Icons.Default.Attachment,
                                            contentDescription = "person",
                                            tint = wheat.copy(0.66f)
                                        )
                                        Spacer(
                                            modifier = Modifier
                                                .weight(0.5f)
                                        )
                                    }
                                }
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = DIMENS_32dp)
                            ) {
                                Column {
                                    Card(
                                        colors = CardDefaults.cardColors(MSecond),
                                        shape = RoundedCornerShape(20.dp),
                                        modifier = Modifier
                                            .fillMaxWidth(0.5f)
                                            .height(164.dp)
                                            .padding(
                                                bottom = DIMENS_4dp,
                                                end = DIMENS_10dp,
                                                start = 0.dp
                                            )
                                            .border(
                                                1.dp,
                                                MSecond.copy(0.66f),
                                                RoundedCornerShape(20.dp)
                                            )
                                            .clickable(
                                                enabled = true,
                                                onClick = {})
                                    )
                                    {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(DIMENS_10dp),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        )
                                        {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(
                                                        start = DIMENS_2dp,
                                                        end = DIMENS_2dp,
                                                        top = DIMENS_2dp,
                                                        bottom = DIMENS_2dp
                                                    )
                                            )
                                            {
                                                NeuButton(
                                                    shape = RoundedCornerShape(DIMENS_16dp),
                                                    modifier = Modifier
                                                        .fillMaxWidth(0.5f)
                                                        .height(64.dp)
                                                        .padding(
                                                            end = DIMENS_1dp,
                                                            start = DIMENS_2dp
                                                        ),
                                                    lightColor = MDark,
                                                    onClick = {
                                                        navController.navigate("documentation")
                                                    }
                                                ) {
                                                    Box {
                                                        Column(
                                                            verticalArrangement = Arrangement.Center,
                                                            horizontalAlignment = Alignment.CenterHorizontally
                                                        ) {
                                                            Image(
                                                                colorFilter = ColorFilter.tint(
                                                                    wheat
                                                                ),
                                                                painter = painterResource(id = R.drawable.baseline_bubble_chart_24),
                                                                contentDescription = "attached-file",
                                                                contentScale = ContentScale.Crop,
                                                                modifier = Modifier
                                                                    .padding(0.dp)
                                                                    .size(DIMENS_20dp),
                                                            )
                                                        }
                                                    }
                                                }
                                                NeuButton(
                                                    shape = RoundedCornerShape(DIMENS_16dp),
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .height(64.dp)
                                                        .padding(
                                                            start = DIMENS_1dp,
                                                            end = DIMENS_2dp
                                                        )
                                                        .clickable(
                                                            enabled = true,
                                                            onClick = {
                                                                navController.navigate("documentation")
                                                            }),
                                                    lightColor = zuzmo,
                                                    onClick = {
                                                        navController.navigate("documentation")
                                                    }
                                                ) {
                                                    Column(
                                                        modifier = Modifier
                                                            .fillMaxSize(),
                                                        verticalArrangement = Arrangement.Center,
                                                        horizontalAlignment = Alignment.CenterHorizontally
                                                    )
                                                    {
                                                        Box(
                                                            modifier = Modifier
                                                                .fillMaxSize(0.5f)
                                                                .border(
                                                                    DIMENS_2dp,
                                                                    zuzmo,
                                                                    RoundedCornerShape(
                                                                        DIMENS_90dp))
                                                                .clip(RoundedCornerShape(DIMENS_90dp))
                                                        ) {
                                                            Image(
                                                                painter = rememberImagePainter(
                                                                    data = imageUri
                                                                        ?: R.drawable.bg_b,
                                                                    builder = {
                                                                        crossfade(true)
                                                                        placeholder(R.drawable.bg_b)
                                                                    }),
                                                                contentDescription = "bg",
                                                                contentScale = ContentScale.Crop,
                                                                modifier = Modifier
                                                                    .fillMaxSize()
                                                                    .clickable {
                                                                        navController.navigate("image_screen")
                                                                    }
                                                            )
                                                        }
                                                    }
                                                }
                                            }

                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(
                                                        start = DIMENS_2dp,
                                                        end = DIMENS_2dp,
                                                        bottom = DIMENS_2dp,
                                                        top = DIMENS_2dp
                                                    )
                                            )
                                            {
                                                NeuButton(
                                                    shape = RoundedCornerShape(DIMENS_16dp),
                                                    modifier = Modifier
                                                        .fillMaxWidth(0.5f)
                                                        .height(64.dp)
                                                        .padding(
                                                            start = DIMENS_2dp,
                                                            end = DIMENS_1dp
                                                        ),
                                                    lightColor = Ros,
                                                    onClick = {
                                                        navController.navigate("documentation")
                                                    }
                                                ) {
                                                    Column(
                                                        modifier = Modifier
                                                            .fillMaxSize(),
                                                        verticalArrangement = Arrangement.Center,
                                                        horizontalAlignment = Alignment.CenterHorizontally
                                                    )
                                                    {
                                                        Box(
                                                            modifier = Modifier
                                                                .fillMaxSize(0.5f)
                                                                .border(
                                                                    DIMENS_2dp,
                                                                    Ros,
                                                                    RoundedCornerShape(
                                                                        DIMENS_90dp
                                                                    )
                                                                )
                                                                .clip(
                                                                    RoundedCornerShape(
                                                                        DIMENS_90dp
                                                                    )
                                                                )
                                                        ) {
                                                            Image(
                                                                painter = rememberImagePainter(
                                                                    data = imageUri
                                                                        ?: R.drawable.bg_b,
                                                                    builder = {
                                                                        crossfade(true)
                                                                        placeholder(R.drawable.bg_b)
                                                                    }),
                                                                contentDescription = "bg",
                                                                contentScale = ContentScale.Crop,
                                                                modifier = Modifier
                                                                    .fillMaxSize()
                                                                    .clickable {
                                                                        navController.navigate("image_screen")
                                                                    }
                                                            )
                                                        }
                                                    }
                                                }
                                                NeuButton(
                                                    shape = RoundedCornerShape(DIMENS_16dp),
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .height(64.dp)
                                                        .padding(
                                                            start = DIMENS_1dp,
                                                            end = DIMENS_2dp
                                                        ),
                                                    lightColor = wheat,
                                                    onClick = {
                                                        navController.navigate("documentation")
                                                    }
                                                ) {
                                                    Column(
                                                        modifier = Modifier
                                                            .fillMaxSize(),
                                                        verticalArrangement = Arrangement.Center,
                                                        horizontalAlignment = Alignment.CenterHorizontally
                                                    )
                                                    {
                                                        Box(
                                                            modifier = Modifier
                                                                .fillMaxSize(0.5f)
                                                                .border(
                                                                    DIMENS_2dp,
                                                                    wheat,
                                                                    RoundedCornerShape(
                                                                        DIMENS_90dp
                                                                    )
                                                                )
                                                                .clip(
                                                                    RoundedCornerShape(
                                                                        DIMENS_90dp
                                                                    )
                                                                )
                                                        ) {
                                                            Image(
                                                                painter = rememberImagePainter(
                                                                    data = imageUri
                                                                        ?: R.drawable.bg_b,
                                                                    builder = {
                                                                        crossfade(true)
                                                                        placeholder(R.drawable.bg_b)
                                                                    }),
                                                                contentDescription = "bg",
                                                                contentScale = ContentScale.Crop,
                                                                modifier = Modifier
                                                                    .fillMaxSize()
                                                                    .clickable {
                                                                        navController.navigate("image_screen")
                                                                    }
                                                            )
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))
                                    NeuButton(
                                        shape = RoundedCornerShape(90.dp),
                                        modifier = Modifier
                                            .fillMaxWidth(0.5f)
                                            .height(70.dp)
                                            .padding(
                                                bottom = 5.dp,
                                                end = DIMENS_10dp,
                                                start = 0.dp)
                                            .border(
                                                1.dp,
                                                MDark,
                                                RoundedCornerShape(90.dp)
                                            ),
                                        lightColor = MDark,
                                        onClick = {
                                            navController.navigate(Screen.Pdf.route)
                                        }
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                text = "PDF Reader",
                                                style = MaterialTheme.typography.bodySmall.copy(
                                                    color = wheat,
                                                    fontFamily = GilroyFontFamily,
                                                    fontWeight = FontWeight.SemiBold
                                                )
                                            )
                                        }
                                    }
                                }
                                NeuButton(
                                    shape = RoundedCornerShape(DIMENS_20dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(238.dp)
                                        .padding(bottom = 5.dp, end = 0.dp, start = DIMENS_10dp)
                                        .border(0.5.dp, MDark, RoundedCornerShape(20.dp))
                                        .clickable(
                                            enabled = true,
                                            onClick = {
                                                navController.navigate("statistic_screen")
                                            }
                                        ),
                                    lightColor = Black,
                                    onClick = {
                                        navController.navigate("statistic_screen")
                                    }
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    )
                                    {
                                        Box {
                                            Image(
                                                painter = rememberImagePainter(
                                                    data = imageUri ?: R.drawable.bg_b,
                                                    builder = {
                                                        crossfade(true)
                                                        placeholder(R.drawable.bg_b)
                                                    }),
                                                contentDescription = "bg",
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .clickable {
                                                    }
                                            )
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth(),
                                                verticalArrangement = Arrangement.Center,
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            )
                                            {
                                                Row(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(DIMENS_10dp)
                                                )
                                                {
                                                    NeuButton(
                                                        shape = RoundedCornerShape(50.dp),
                                                        modifier = Modifier
                                                            .fillMaxWidth(0.5f)
                                                            .height(70.dp)
                                                            .padding(DIMENS_4dp)
                                                            .border(
                                                                1.dp,
                                                                MDark,
                                                                RoundedCornerShape(50.dp)
                                                            ),
                                                        lightColor = MDark,
                                                        onClick = {
                                                            navController.navigate("qr_scanner_screen")
                                                        }
                                                    ) {
                                                        Column(
                                                            modifier = Modifier
                                                                .fillMaxSize(),
                                                            verticalArrangement = Arrangement.Center,
                                                            horizontalAlignment = Alignment.CenterHorizontally
                                                        )
                                                        {
                                                            Row {
                                                                Image(
                                                                    colorFilter = ColorFilter.tint(
                                                                        wheat
                                                                    ),
                                                                    painter = painterResource(id = R.drawable.baseline_qr_code_24),
                                                                    contentDescription = "attached-file",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .padding(0.dp)
                                                                        .size(DIMENS_16dp),
                                                                )
                                                                Spacer(
                                                                    modifier = Modifier.width(
                                                                        DIMENS_2dp
                                                                    )
                                                                )
                                                            }
                                                        }
                                                    }
                                                    NeuButton(
                                                        shape = RoundedCornerShape(50.dp),
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .height(70.dp)
                                                            .padding(DIMENS_4dp)
                                                            .border(
                                                                1.dp,
                                                                MSecond,
                                                                RoundedCornerShape(50.dp)
                                                            ),
                                                        lightColor = MSecond,
                                                        onClick = {
                                                            navController.navigate("grid_screen")
                                                        }
                                                    ) {
                                                        Column(
                                                            modifier = Modifier
                                                                .fillMaxSize(),
                                                            verticalArrangement = Arrangement.Center,
                                                            horizontalAlignment = Alignment.CenterHorizontally
                                                        )
                                                        {
                                                            Row {
                                                                Image(
                                                                    colorFilter = ColorFilter.tint(
                                                                        wheat
                                                                    ),
                                                                    painter = painterResource(id = R.drawable.baseline_grid_view_24),
                                                                    contentDescription = "attached-file",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .padding(0.dp)
                                                                        .size(DIMENS_16dp),
                                                                )
                                                                Spacer(
                                                                    modifier = Modifier.width(
                                                                        DIMENS_2dp
                                                                    )
                                                                )
                                                            }
                                                        }
                                                    }
                                                }
                                                Row(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(10.dp)
                                                )
                                                {
                                                    NeuButton(
                                                        shape = RoundedCornerShape(20.dp),
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .height(130.dp)
                                                            .padding(
                                                                start = DIMENS_10dp,
                                                                end = DIMENS_10dp,
                                                                bottom = DIMENS_10dp
                                                            )
                                                            .border(
                                                                2.dp,
                                                                wheat,
                                                                RoundedCornerShape(20.dp)
                                                            )
                                                            .clickable(
                                                                enabled = true,
                                                                onClick = {}
                                                            ),
                                                        lightColor = wheat,
                                                        onClick = {}
                                                    ) {
                                                        Column(
                                                            modifier = Modifier
                                                                .fillMaxSize(),
                                                            verticalArrangement = Arrangement.Center,
                                                            horizontalAlignment = Alignment.CenterHorizontally
                                                        )
                                                        {
                                                            Box {
                                                                Image(
                                                                    painter = rememberImagePainter(
                                                                        data = imageUri
                                                                            ?: R.drawable.pic_2,
                                                                        builder = {
                                                                            crossfade(true)
                                                                            placeholder(R.drawable.pic_2)
                                                                        }),
                                                                    contentDescription = "bg",
                                                                    contentScale = ContentScale.Crop,
                                                                    modifier = Modifier
                                                                        .fillMaxSize()
                                                                        .clickable {
                                                                            navController.navigate(
                                                                                "image_screen"
                                                                            )
                                                                        }
                                                                )
                                                                Box(
                                                                    modifier = Modifier
                                                                        .padding(
                                                                            top = 94.dp,
                                                                            start = 70.dp
                                                                        )
                                                                ) {
                                                                    Text(
                                                                        text = "images",
                                                                        color = Black,
                                                                        fontFamily = GilroyFontFamily,
                                                                        fontSize = TEXT_SIZE_10sp,
                                                                        fontWeight = FontWeight.SemiBold,
                                                                        letterSpacing = TEXT_SIZE_1sp
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = DIMENS_10dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                NeuButton(
                                    shape = RoundedCornerShape(20.dp),
                                    modifier = Modifier
                                        .fillMaxWidth(0.5f)
                                        .height(80.dp)
                                        .padding(
                                            bottom = 5.dp,
                                            top = 5.dp,
                                            end = DIMENS_10dp,
                                            start = 0.dp
                                        )
                                        .border(1.dp, MSecond, RoundedCornerShape(20.dp)),
                                    lightColor = MSecond,
                                    onClick = {
                                        navController.navigate("recipes_list_screen")
                                    })
                                {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Row {
                                            Text(
                                                modifier = Modifier
                                                    .align(Alignment.CenterVertically),
                                                text = "Recipe UI",
                                                style = MaterialTheme.typography.bodySmall.copy(
                                                    color = wheat,
                                                    fontFamily = GilroyFontFamily,
                                                    fontWeight = FontWeight.SemiBold
                                                )
                                            )
                                            Spacer(modifier = Modifier.width(DIMENS_4dp))

                                            Image(
                                                colorFilter = ColorFilter.tint(wheat),
                                                painter = painterResource(id = R.drawable.btn_2),
                                                contentDescription = "attached-file",
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .padding(0.dp)
                                                    .size(DIMENS_16dp),
                                            )
                                        }
                                    }
                                }
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(80.dp)
                                        .padding(
                                            bottom = 5.dp,
                                            top = 5.dp,
                                            end = 0.dp,
                                            start = DIMENS_10dp
                                        )
                                        .clickable {
                                            navController.navigate(route = Screen.MainTodoScreen.route)
                                        }
                                        .graphicsLayer {
                                            this.shadowElevation = elevation.value.toPx()
                                        }
                                ) {
                                    Canvas(modifier = Modifier.matchParentSize()) {
                                        val clipPath = Path().apply {
                                            lineTo(size.width - cutCornerSize.toPx(), 0f)
                                            lineTo(size.width, cutCornerSize.toPx())
                                            lineTo(size.width, size.height)
                                            lineTo(0f, size.height)
                                            close()
                                        }
                                        clipPath(clipPath) {
                                            drawRoundRect(
                                                color = wheat,
                                                size = size,
                                                cornerRadius = CornerRadius(cornerRadius.toPx())
                                            )
                                            drawRoundRect(
                                                color = MDark.copy(0.36f),
                                                topLeft = Offset(
                                                    size.width - cutCornerSize.toPx(),
                                                    -100f
                                                ),
                                                size = Size(
                                                    cutCornerSize.toPx() + 100f,
                                                    cutCornerSize.toPx() + 100f
                                                ),
                                                cornerRadius = CornerRadius(cornerRadius.toPx())
                                            )
                                        }
                                    }
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "simple",
                                            style = MaterialTheme.typography.bodySmall.copy(
                                                color = MDark,
                                                fontFamily = GilroyFontFamily,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                        )
                                        Spacer(modifier = Modifier.height(DIMENS_2dp))
                                        Text(
                                            text = "TodoList",
                                            style = MaterialTheme.typography.bodySmall.copy(
                                                color = MDark,
                                                fontFamily = GilroyFontFamily,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier
                                    .padding(vertical = DIMENS_10dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                NeuButton(
                                    shape = RoundedCornerShape(90.dp),
                                    modifier = Modifier
                                        .fillMaxWidth(0.5f)
                                        .height(90.dp)
                                        .width(90.dp)
                                        .padding(vertical = DIMENS_10dp)
                                        .padding(end = DIMENS_10dp)
                                        .border(1.dp, Ros, RoundedCornerShape(90.dp)),
                                    lightColor = Ros,
                                    onClick = {
                                        navController.navigate(Screen.DetailsUI.route)
                                    }
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "Call-to-Action",
                                            style = MaterialTheme.typography.bodySmall.copy(
                                                color = MSecond,
                                                fontFamily = GilroyFontFamily,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                        )
                                    }
                                }
                                NeuButton(
                                    shape = RoundedCornerShape(DIMENS_20dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(90.dp)
                                        .width(90.dp)
                                        .padding(vertical = DIMENS_10dp)
                                        .padding(start = DIMENS_10dp)
                                        .border(1.dp, Color.Transparent, RoundedCornerShape(DIMENS_20dp)),
                                    lightColor = Ros,
                                    onClick = {
                                        navController.navigate("dialog_screen")
                                    }
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(
                                                brush = Brush.horizontalGradient(
                                                    listOf(
                                                        MDark,
                                                        MSecond,
                                                    )
                                                )
                                            ),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "Cards & Buttons",
                                            style = MaterialTheme.typography.bodySmall.copy(
                                                color = wheat,
                                                fontFamily = GilroyFontFamily,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                        )
                                    }
                                }
                            }
                            Row(
                                modifier = Modifier
                                    .padding()
                                    .align(Alignment.CenterHorizontally),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    colorFilter = ColorFilter.tint(wheat),
                                    painter = painterResource(id = R.drawable.baseline_bubble_chart_24),
                                    contentDescription = "attached-file",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .padding(0.dp)
                                        .size(DIMENS_24dp),
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(DIMENS_20dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = DIMENS_20dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = DIMENS_90dp,
                                    topEnd = DIMENS_90dp,
                                    bottomStart = DIMENS_90dp,
                                    bottomEnd = DIMENS_90dp))
                            .height(100.dp),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Blur)
                                .padding(horizontal = DIMENS_10dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            NeuButton(
                                shape = CircleShape,
                                modifier = Modifier
                                    .fillMaxWidth(0.2f)
                                    .height(60.dp)
                                    .padding(start = DIMENS_8dp)
                                    .border(1.dp, MSecond, CircleShape),
                                lightColor = MSecond,
                                onClick = {
                                    navController.navigate("animated_pager")
                                }
                            ) {
                                Image(
                                    colorFilter = ColorFilter.tint(wheat),
                                    painter = painterResource(id = R.drawable.baseline_pages_24),
                                    contentDescription = "attached-file",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .padding(0.dp)
                                        .size(DIMENS_16dp),
                                )
                            }
                            Spacer(modifier = Modifier.width(DIMENS_8dp))
                            NeuButton(
                                shape = RoundedCornerShape(90.dp),
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .height(60.dp)
                                    .padding(start = DIMENS_8dp)
                                    .border(1.dp, MDark, RoundedCornerShape(90.dp)),
                                lightColor = MDark,
                                onClick = { navController.navigate("ui_ex_screen") }
                            )
                            {
                                Text(
                                    text = "SmartHome",
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = wheat,
                                        fontFamily = GilroyFontFamily,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.width(DIMENS_16dp))
                            NeuButton(
                                shape = RoundedCornerShape(90.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .padding(end = DIMENS_8dp)
                                    .border(1.dp, Ros, RoundedCornerShape(90.dp)),
                                lightColor = Ros,
                                onClick = {
                                    userViewModel.logout()
                                    navController.navigate(AuthScreen.Login.route) {
                                        popUpTo(AuthScreen.Main.route) { inclusive = true }
                                    }
                                }
                            ) {
                                Image(
                                    colorFilter = ColorFilter.tint(wheat),
                                    painter = painterResource(id = R.drawable.baseline_add_reaction_24),
                                    contentDescription = "reaction",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .padding(0.dp)
                                        .size(DIMENS_16dp)
                                        .clickable(
                                            onClick = {
                                                navController.navigate("smart_home_two_screen")
                                            }
                                        )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}





