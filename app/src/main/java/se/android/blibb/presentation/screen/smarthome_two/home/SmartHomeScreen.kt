package se.android.blibb.presentation.screen.smarthome_two.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import se.android.blibb.R
import se.android.blibb.navigation.screen.BottomNavItemScreen
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_180dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.wheat

@Composable
fun SmartHomeScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MSecond)
    ) {
        Image(
            painter = painterResource(id = R.drawable.wall),
            contentDescription = "Background Image",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.statusBarsPadding())
            ToolbarSection(navController = navController)
            Column(
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                Spacer(modifier = Modifier.padding(top = 36.dp))
                LightSection(navController = navController)
                Spacer(modifier = Modifier.padding(top = 12.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = DIMENS_10dp)
                ) {
                    SolarTempItems(
                        modifier = Modifier.weight(0.5F))
                    Spacer(modifier = Modifier.padding(start = 12.dp))
                    OutSideTempItems(
                        modifier = Modifier.weight(0.5F))
                }
            }
        }
    }
}


@Composable
fun ToolbarSection(
    navController: NavController
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = "Back button",
            tint = wheat,
            modifier = Modifier
                .size(20.dp)
                .padding(4.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = ripple (bounded = false),
                    onClick = {
                        navController.navigate(BottomNavItemScreen.Start.route)
                    },
                )
        )
        Column(
            modifier = Modifier
                .padding(4.dp)
                .weight(weight = 1F, fill = true),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "SmartHomeDevice",
                style = LocalTextStyle.current.copy(
                    color = MDark,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.SemiBold),
            )
            Text(
                text = "current sensors",
                style = LocalTextStyle.current.copy(
                    color = Color.White,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Black,
                    fontSize = 24.sp),
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.baseline_grid_view_24),
            contentDescription = "button",
            tint = wheat,
            modifier = Modifier
                .size(30.dp)
                .padding(4.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = ripple(bounded = false),
                    onClick = {
                        navController.navigate("search_device_list_screen")
                    },
                )
        )
    }
}

@Composable
fun BedroomLightItems(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(
        modifier = modifier
            .height(DIMENS_180dp)
            .clip(RoundedCornerShape(24.dp))
            .background(color = MSecond)
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.wall),
            contentDescription = "Background Image",
            modifier = Modifier
                .fillMaxSize()
                .clickable(
                    onClick = {
                        navController.navigate( "ui_ex_screen")
                    }
                ),
            contentScale = ContentScale.Crop
        )
        TextButton(
            onClick = {
                navController.navigate("ui_ex_screen")
            })
        {
            Text(
                text = "bedroom light",
                style = LocalTextStyle.current.copy(
                    color = wheat,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Black,
                    fontSize = 20.sp
                )
            )

        }
    }
}