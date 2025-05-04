package se.android.blibb.presentation.screen.image

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import se.android.blibb.R
import se.android.blibb.presentation.component.InfoCard
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_2dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_48dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.wheat

@Composable
fun ImageScreen(modifier: Modifier = Modifier)
{
    val rainbowImage = ImageBitmap.imageResource(id = R.drawable.rea)
    val dogImage = ImageBitmap.imageResource(id = R.drawable.rea)
    val customPainter = remember {
        OverlayImagePainter(dogImage, rainbowImage)
    }

    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(DIMENS_48dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "images",
                style = TextStyle(
                    color = MDark,
                    fontSize = 24.sp,
                    fontFamily = GilroyFontFamily
                )
            )
            Text(
                text = "pre-defined composable",
                style = TextStyle(
                    color = MDark,
                    fontSize = 18.sp,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Black
                )
            )
        }
        Spacer(modifier = Modifier.height(DIMENS_32dp))
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = DIMENS_20dp,
                        vertical = DIMENS_8dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Simple Image",
                        style = TextStyle(
                            color = MDark,
                            fontSize = 12.sp,
                            fontFamily = GilroyFontFamily
                        )
                    )
                    SimpleImageExample()
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Circle Image",
                        style = TextStyle(
                            color = MDark,
                            fontSize = 12.sp,
                            fontFamily = GilroyFontFamily
                        )
                    )
                    CircleImageExample()
                }
            }
            Spacer(modifier = Modifier.height(DIMENS_16dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = DIMENS_20dp,
                        vertical = DIMENS_8dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(
                            horizontal = DIMENS_20dp,
                            vertical = DIMENS_8dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Image with border",
                        style = TextStyle(
                            color = MDark,
                            fontSize = 12.sp,
                            fontFamily = GilroyFontFamily
                        )
                    )
                    ImageWithBorderExample()
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = DIMENS_20dp,
                            vertical = DIMENS_8dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Custom aspect ratio Image",
                        style = TextStyle(
                            color = MDark,
                            fontSize = 12.sp,
                            fontFamily = GilroyFontFamily
                        )
                    )
                    CustomAspectRatioImageExample()
                }

            }
            Spacer(modifier = Modifier.height(DIMENS_16dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = DIMENS_20dp,
                        vertical = DIMENS_8dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(
                            horizontal = DIMENS_20dp,
                            vertical = DIMENS_8dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Tint Image",
                        style = TextStyle(
                            color = MDark,
                            fontSize = 12.sp,
                            fontFamily = GilroyFontFamily
                        )
                    )
                    TintImageExample()
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = DIMENS_20dp,
                            vertical = DIMENS_8dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Blurred Image",
                        style = TextStyle(
                            color =MDark,
                            fontSize = 12.sp,
                            fontFamily = GilroyFontFamily
                        )
                    )
                    BlurImageExample()
                }
            }
            Spacer(modifier = Modifier.height(DIMENS_16dp))

            InfoCard( painterResource(id = R.drawable.rea),
                "Effective Sales Text Message",
                "Thanks for reaching out about a quote for our venue! It depends on several factors like guest count and time of year. Are you free for a call to discuss your needs?")
        }
    }
}
@Composable
fun SimpleImageExample() {
    Image(
        painter = painterResource(id = R.drawable.rea),
        contentDescription = "text",
        modifier = Modifier
            .padding(10.dp)
            .size(120.dp)
    )
}

@Composable
fun CircleImageExample() {
    Image(
        painter = painterResource(id = R.drawable.rea),
        contentDescription = "text",
        modifier = Modifier
            .padding(10.dp)
            .size(120.dp)
            .clip(CircleShape)
    )
}

@Composable
fun ImageWithBorderExample() {
    val borderWidth = 4.dp
    Image(
        painter = painterResource(id = R.drawable.rea),
        contentDescription = "text",
        modifier = Modifier
            .size(140.dp)
            .padding(10.dp)
            .border(DIMENS_2dp, wheat, CircleShape)
            .padding(borderWidth)
            .clip(CircleShape)
    )
}

@Composable
fun CustomAspectRatioImageExample() {
    Image(
        painter = painterResource(id = R.drawable.rea),
        contentDescription = "text",
        modifier = Modifier
            .size(160.dp)
            .aspectRatio(16f / 9f)
    )
}

@Composable
fun TintImageExample() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        Image(
            painter = painterResource(id = R.drawable.rea),
            contentDescription = "text",
            modifier = Modifier
                .padding(10.dp)
                .size(120.dp),
            colorFilter = ColorFilter.tint(
                MDark.copy(0.26f),
                blendMode = BlendMode.Darken)
        )
    }
}

@Composable
fun BlurImageExample() {
    Image(
        painter = painterResource(id = R.drawable.rea),
        contentDescription = "text",
        modifier = Modifier
            .padding(10.dp)
            .size(120.dp)
            .blur(
                radiusX = 5.dp,
                radiusY = 5.dp,
                edgeTreatment = BlurredEdgeTreatment(CircleShape)
            )
    )
}
