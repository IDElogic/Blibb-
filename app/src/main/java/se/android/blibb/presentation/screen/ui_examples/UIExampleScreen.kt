package se.android.blibb.presentation.screen.ui_examples

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import se.android.blibb.R
import se.android.blibb.presentation.screen.ui_examples.lightswitch.widgets.COLOR_LIST
import se.android.blibb.presentation.screen.ui_examples.lightswitch.widgets.ColorItem
import se.android.blibb.presentation.screen.ui_examples.lightswitch.widgets.CustomSeekBar
import se.android.blibb.presentation.screen.ui_examples.lightswitch.widgets.LightBeamCanvas
import se.android.blibb.presentation.screen.ui_examples.lightswitch.widgets.RealisticRopeLightSwitch
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_80dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import kotlin.math.roundToInt

@Composable
fun UIExampleScreen(modifier: Modifier = Modifier) {

    var selectedColorIndex by remember { mutableIntStateOf(2) }
    var progress by remember { mutableFloatStateOf(0.6f) }
    var isLightOn by remember { mutableStateOf(false) }

    val animateBeamColor by animateColorAsState(
        targetValue = if (isLightOn) COLOR_LIST[selectedColorIndex] else MSecond,
        label = ""
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MSecond),
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = DIMENS_10dp)
                .fillMaxWidth()
                .height(600.dp)
                .background(Color.Transparent)
        ) {
            val imageModifier = Modifier
                .fillMaxSize()
                .shadow(elevation = DIMENS_32dp)
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

            LightBeamCanvas(
                modifier = Modifier
                    .padding(start = 50.dp)
                    .padding(top = 230.dp)
                    .size(
                        width = 200.dp,
                        height = 300.dp
                    ),
                isVisible = isLightOn,
                lightOpacity = progress,
                lightColor = animateBeamColor
            )
            Image(
                painter = painterResource(R.drawable.light),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 50.dp)
                    .size(
                        height = 250.dp,
                        width = 200.dp
                    )
            )
            LightBeamCanvas(
                modifier = Modifier
                    .padding(top = 180.dp)
                    .offset(x = (-25).dp)
                    .size(
                        width = 200.dp,
                        height = 300.dp
                    ),
                isVisible = isLightOn,
                lightOpacity = progress,
                topConeWidth = 280f,
                lightColor = animateBeamColor
            )
            Image(
                painter = painterResource(R.drawable.light),
                contentDescription = null,
                modifier = Modifier
                    .size(
                        height = 200.dp,
                        width = 150.dp
                    )
            )
            RealisticRopeLightSwitch(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .width(100.dp)
                    .height(400.dp),
                ropeColor = Color.Gray,
                handleColor = Color.Black,
                onLightSwitch = { isOn ->
                    isLightOn = isOn
                }
            )
            RealisticRopeLightSwitch(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .width(100.dp)
                    .height(400.dp)
                    .background(Color.Transparent),
                ropeColor = Ros,
                handleColor = MDark,
                onLightSwitch = { isOn ->
                    isLightOn = isOn
                }
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(horizontal = DIMENS_20dp,
                        vertical = DIMENS_10dp)
                    .fillMaxWidth()
            ) {
                Text(
                text = "Pendant Lighting",
                style = MaterialTheme.typography.labelLarge.copy(
                    color = MDark.copy(0.66f),
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.SemiBold
                    )
                )
                Text(
                    text = "test the brightness",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MDark,
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                )
                Text(
                    text = "${(progress * 100).roundToInt()}%",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MDark,
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
            CustomSeekBar(
                progress = progress,
                onProgressChanged = { progress = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = DIMENS_32dp, vertical = DIMENS_10dp)
            )
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = DIMENS_10dp)
                        .padding(horizontal = DIMENS_32dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(COLOR_LIST.size) { index ->
                        ColorItem(
                            color = COLOR_LIST[index],
                            isSelected = selectedColorIndex == index,
                            onClick = {
                                selectedColorIndex = if (selectedColorIndex == index) -1 else index
                            }
                        )
                    }
                }
        }
    }
}

