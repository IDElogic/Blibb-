package se.android.blibb.presentation.screen.smarthome_two.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import se.android.blibb.R
import se.android.blibb.ui.theme.Blur
import se.android.blibb.ui.theme.Blur2
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_12dp
import se.android.blibb.ui.theme.DIMENS_180dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.wheat
import se.android.blibb.ui.theme.zuzmo

@Preview
@Composable
fun RoomTempItems(
    modifier: Modifier = Modifier
) {
    var switch by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = modifier
            .height(DIMENS_180dp)
            .clip(RoundedCornerShape(24.dp))
            .background(color = MSecond)
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "42%",
                    style = TextStyle(
                        color = wheat,
                        fontSize = 32.sp,
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_humidity),
                    contentDescription = "Humidity",
                    tint = wheat)
            }
            Text(
                text = "Humidifier \nAir",
                style = TextStyle(
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = wheat,
                    letterSpacing = 1.sp
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Divider(
                thickness = 1.dp,
                color = MDark,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 24.dp, bottom = 20.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Switch \non/off",
                    style = TextStyle(
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = wheat,
                        fontSize = 12.sp,
                        letterSpacing = 1.sp
                    ),
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .weight(1F)
                )
                Switch(
                    checked = switch,
                    onCheckedChange = { isChecked ->
                        switch = isChecked
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = wheat,
                        checkedTrackColor = Ros
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun OutSideTempItems(
    modifier: Modifier = Modifier
) {
    var switch by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(color = Blur)
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                Text(
                    text = "Outside \nTemperature",
                    style = TextStyle(
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = wheat,
                        letterSpacing = 1.sp)
                )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_bubble_chart_24),
                        contentDescription = "solar",
                        tint = wheat,
                    )
            }

            Text(
                text = "28°C",
                style = TextStyle(
                    color = wheat,
                    fontSize = 32.sp,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "current temperature",
                style = TextStyle(
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = wheat,
                    letterSpacing = 1.sp)
            )

            Divider(
                thickness = 1.dp,
                color = wheat,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = DIMENS_10dp, bottom = DIMENS_12dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Switch \non/off",
                    style = TextStyle(
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = wheat,
                        fontSize = 12.sp,
                        letterSpacing = 1.sp
                    ),
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .weight(1F)
                )

                Switch(
                    checked = switch,
                    onCheckedChange = { isChecked ->
                        switch = isChecked
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = wheat,
                        checkedTrackColor = MDark
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun SolarTempItems(
    modifier: Modifier = Modifier
) {
    var switch by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(color = Blur2)
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                Text(
                    text = "Solar Panel",
                    style = TextStyle(
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = wheat,
                        letterSpacing = 1.sp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_solar_power_24),
                    contentDescription = "solar",
                    tint = wheat,
                )
            }

            Text(
                text = "213",
                style = TextStyle(
                    color = wheat,
                    fontSize = 32.sp,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "watt.hours",
                style = TextStyle(
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = wheat,
                    letterSpacing = 1.sp)
            )

            Divider(
                thickness = 1.dp,
                color = MDark,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = DIMENS_10dp, bottom = DIMENS_12dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Switch \non/off",
                    style = TextStyle(
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = wheat,
                        fontSize = 12.sp,
                        letterSpacing = 1.sp
                    ),
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .weight(1F)
                )
                Switch(
                    checked = switch,
                    onCheckedChange = { isChecked ->
                        switch = isChecked
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = wheat,
                        checkedTrackColor = Ros
                    )
                )
            }
        }
    }
}

@Composable
fun LightSection(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(MDark)
            .padding(20.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(top = 8.dp))
                Text(
                    text = "living room",
                    textAlign = TextAlign.Center,
                    style = LocalTextStyle.current.copy(
                        color = Color.White,
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Black,
                        fontSize = 24.sp),
                )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            LightsSectionItem(
                name = "Main light",
                icon = R.drawable.ic_lamp
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            LightsSectionItem(
                name = "Floor lamp",
                icon = R.drawable.ic_lamp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                RoomTempItems(
                    modifier = Modifier.weight(0.5F)
                )
                Spacer(modifier = Modifier.padding(start = 12.dp))
                BedroomLightItems(
                    navController = navController,
                    modifier = Modifier.weight(0.5F)
                )
            }
        }
    }
}

@Preview
@Composable
fun LightsSectionItem(
    name: String = "Main light",
    @DrawableRes icon: Int = R.drawable.ic_bell
) {
    var sliderPositionMainLight by remember {
        mutableFloatStateOf(60F)
    }
    Column {
        Text(
            text = name,
            style = TextStyle(
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = wheat,
                letterSpacing = 1.sp
            )
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Slider(
                value = sliderPositionMainLight,
                onValueChange = { position ->
                    sliderPositionMainLight = position
                },
                steps = 0,
                valueRange = 0F..100F,
                colors = SliderDefaults.colors(
                    activeTrackColor = Ros,
                    inactiveTrackColor = zuzmo,
                    thumbColor = wheat,
                    activeTickColor = Color.White
                ),
                modifier = Modifier
                    .weight(1F)
                    .padding(end = 16.dp)
            )

            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Main Light",
                tint = wheat
            )
        }
    }
}