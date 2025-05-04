package se.android.blibb.presentation.screen.smarthome_two.search

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import se.android.blibb.R
import se.android.blibb.navigation.screen.BottomNavItemScreen
import se.android.blibb.presentation.component.NeuButton
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_48dp
import se.android.blibb.ui.theme.DIMENS_4dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat


@SuppressLint("UnrememberedMutableState")
@Composable
fun SearchDeviceList(
    navController: NavController
) {

    val listDevices = listOf<SearchDevice>(
        SearchDevice(
            picture = R.drawable.loupe,
            title = "Search device",
            deviceType = "Select manually"
        ),
        SearchDevice(
            picture = R.drawable.bulb,
            title = "Device1",
            deviceType = "device",
            isSelected = true
        ),
        SearchDevice(
            picture = R.drawable.bulb,
            title = "Device2",
            deviceType = "device"
        ),
        SearchDevice(
            picture = R.drawable.bulb,
            title = "Device3",
            deviceType = "device",
            isSelected = true
        ),
        SearchDevice(
            picture = R.drawable.bulb,
            title = "Device4",
            deviceType = "device"
        ),
        SearchDevice(
            picture = R.drawable.bulb,
            title = "Device5",
            deviceType = "device"
        ),
    )

    var selectedItemIndex by remember {
        mutableIntStateOf(0)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MSecond)
            .padding(horizontal = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column() {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .padding(top = 16.dp)
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
                    Text(
                        text = "search device",
                        textAlign = TextAlign.Center,
                        style = LocalTextStyle.current.copy(
                            color = Color.White,
                            fontFamily = GilroyFontFamily,
                            fontWeight = FontWeight.Black,
                            fontSize = 24.sp),
                        modifier = Modifier
                            .padding(vertical = DIMENS_4dp)
                            .weight(weight = 1F, fill = true)
                    )

                    Text(
                        text = "Wifi:sdf_489_5G",
                        style = TextStyle(
                            color = wheat.copy(0.66f),
                            fontSize = 12.sp,
                            fontFamily = GilroyFontFamily,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.padding(top = 32.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(items = listDevices) {
                        if (it.picture == R.drawable.baseline_bubble_chart_24) {
                            SearchDeviceManually(searchDevice = it)
                        } else {
                            SearchDeviceItem(
                                searchDevice = it,
                                isSelected = selectedItemIndex == listDevices.indexOf(it)
                            ) { searchDevice ->
                                selectedItemIndex = listDevices.indexOf(searchDevice)
                            }
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .padding(bottom = DIMENS_48dp)
            ) {
                NeuButton(
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    lightColor = Ros,
                    onClick = {
                        navController.navigate(route = BottomNavItemScreen.Start.route)
                    }
                )
                {
                    Text(
                        text = "add device",
                        color = wheat,
                        fontFamily = GilroyFontFamily,
                        fontSize = TEXT_SIZE_12sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TEXT_SIZE_1sp,
                        modifier = Modifier
                            .padding(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SearchDeviceItem(
    searchDevice: SearchDevice,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier,
    onItemClick: (SearchDevice) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) MDark else wheat
        ),
        border = BorderStroke(
            width = 2.dp,
            color = if (isSelected) wheat.copy(0.26f) else MDark.copy(0.26f)
        ),
        shape = RoundedCornerShape(DIMENS_20dp),
        modifier = modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(searchDevice)
            }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 24.dp),
        ) {
            Image(
                painter = painterResource(id = searchDevice.picture),
                contentDescription = "Search Device Item Picture",
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .size(DIMENS_48dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.padding(top = 16.dp))
            Text(
                text = searchDevice.title,
                style = TextStyle(
                    color = if (isSelected) wheat else MDark,
                    fontSize = 16.sp,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.padding(top = 4.dp))
            Text(
                text = searchDevice.deviceType,
                style = TextStyle(
                    color = if (isSelected) wheat else MDark,
                    fontSize = 12.sp,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Medium
                )
            )
        }

    }
}

@Composable
fun SearchDeviceManually(
    searchDevice: SearchDevice
) {
    val stroke = Stroke(
        width = 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 20f), 0f)
    )

    Box(
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(color = MSecond)
            .padding(2.dp)
            .drawBehind {
                drawRoundRect(
                    color = MDark,
                    style = stroke,
                    cornerRadius = CornerRadius(24.dp.toPx())
                )
            }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 24.dp)
        ) {
            Image(
                painter = painterResource(
                    id = searchDevice.picture
                ),
                contentDescription = searchDevice.title,
                contentScale = ContentScale.Crop,
            )

            Text(
                text = searchDevice.title,
                style = TextStyle(
                    color = wheat,
                    fontSize = 18.sp,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )

            Text(
                text = searchDevice.deviceType,
                style = TextStyle(
                    color = Ros,
                    fontSize = 12.sp,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )
        }
    }
}