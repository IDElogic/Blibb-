package se.android.blibb.presentation.screen.cards_buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import se.android.blibb.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import se.android.blibb.presentation.component.CardAnimation
import se.android.blibb.presentation.component.InfoCard
import se.android.blibb.presentation.component.PhotoBox
import se.android.blibb.ui.theme.Blur
import se.android.blibb.ui.theme.Blur2
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_48dp
import se.android.blibb.ui.theme.DIMENS_68dp
import se.android.blibb.ui.theme.DIMENS_80dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_16sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.TEXT_SIZE_24sp
import se.android.blibb.ui.theme.wheat

@Composable
fun CardScreen(modifier: Modifier = Modifier,navController: NavController) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MSecond)
            .padding(start = DIMENS_20dp, top = DIMENS_20dp, end = DIMENS_20dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
                .clip(
                    RoundedCornerShape(
                        bottomStart = DIMENS_80dp,
                        bottomEnd = DIMENS_80dp)
                ),
            painter = painterResource(id = R.drawable.wall),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            alpha = DefaultAlpha
        )
        Text(
            text = "Card Solutions",
            color = MDark,
            fontFamily = GilroyFontFamily,
            fontSize = TEXT_SIZE_24sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = TEXT_SIZE_1sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = DIMENS_48dp)
        )
        CustomCardExample()
        SimpleCardExample()
        Row (
            modifier = Modifier
                .fillMaxWidth())
        {
            Card (
                colors = CardDefaults.cardColors(Blur),
                shape = RoundedCornerShape(DIMENS_20dp),
                elevation = CardDefaults.cardElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(DIMENS_8dp))
            {
                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.wall),
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        alpha = DefaultAlpha
                    )
                    Column {
                        Spacer(modifier = Modifier.width(DIMENS_8dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            RectangleShapeCardExample()
                            CircleShapeCardExample()
                        }
                        Spacer(modifier = Modifier.width(DIMENS_8dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            CutCornerShapeCardExample()
                            RoundedCornerShapeCardExample()
                        }
                    }
            } }
        }
        PhotoBox()
        Spacer(modifier = Modifier.height(DIMENS_68dp))
        CardAnimation()
        InfoCard( painterResource(id = R.drawable.rea),
            "Effective Sales Text Message",
            "Thanks for reaching out about a quote for our venue! It depends on several factors like guest count and time of year. Are you free for a call to discuss your needs?")
    }
}

@Composable
fun SimpleCardExample() {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(wheat),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable{}
    ) {
        Text(
            text = "Simple Card",
            color = MDark,
            fontFamily = GilroyFontFamily,
            fontSize = TEXT_SIZE_24sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = TEXT_SIZE_1sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = DIMENS_48dp)
        )
    }
}

@Composable
fun RectangleShapeCardExample() {
    val paddingModifier  = Modifier
        .padding(DIMENS_10dp)
    Card(
        colors = CardDefaults.cardColors(Blur2),
        shape = RoundedCornerShape(DIMENS_20dp),
        modifier = paddingModifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable{}
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = DIMENS_20dp, vertical = DIMENS_10dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically)
        {
        Text(
            text = "Rectangle Shape",
            color = wheat,
            fontFamily = GilroyFontFamily,
            fontSize = TEXT_SIZE_16sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = TEXT_SIZE_1sp,
        )
            Spacer(modifier = Modifier.width(DIMENS_20dp))
            Card(
                colors = CardDefaults.cardColors(wheat),
                shape = RoundedCornerShape(DIMENS_20dp),
                elevation = CardDefaults.cardElevation(DIMENS_10dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clickable{}
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = DIMENS_10dp, vertical = DIMENS_32dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        colorFilter = ColorFilter.tint(Ros),
                        painter = painterResource(id = R.drawable.baseline_bubble_chart_24),
                        contentDescription = "attached-file",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(DIMENS_10dp)
                            .size(DIMENS_20dp),
                    )
                }
            }
    }}
}

@Composable
fun CircleShapeCardExample() {
    val paddingModifier  = Modifier
        .padding(DIMENS_10dp)
    Card(
        colors = CardDefaults.cardColors(MDark),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = paddingModifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable{}
    ) {
        Text(
            text = "Circle Shape Card",
            color = wheat.copy(0.66f),
            fontFamily = GilroyFontFamily,
            fontSize = TEXT_SIZE_16sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = TEXT_SIZE_1sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = DIMENS_48dp))
    }
}

@Composable
fun CutCornerShapeCardExample() {
    val paddingModifier  = Modifier
        .padding(DIMENS_10dp)
    Card(
        shape = CutCornerShape(
            bottomEnd = DIMENS_20dp,
            bottomStart = DIMENS_20dp,
            topStart = DIMENS_20dp,
            topEnd = DIMENS_20dp),
        elevation = CardDefaults.cardElevation(DIMENS_20dp),
        modifier = paddingModifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable{},
        colors = CardDefaults.cardColors(Ros.copy(0.9f)))
    {
        Text(
            text = "Cut Corner Shape",
            color = MDark,
            fontFamily = GilroyFontFamily,
            fontSize = TEXT_SIZE_16sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = TEXT_SIZE_1sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = DIMENS_48dp)
        )
    }
}

@Composable
fun RoundedCornerShapeCardExample() {
    val paddingModifier  = Modifier.padding(10.dp)
    Card(
        shape = RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp, topStart = 8.dp, topEnd = 8.dp),
        colors = CardDefaults.cardColors(Blur),
        border = BorderStroke(DIMENS_1dp,wheat),
        modifier = paddingModifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable{}
    ) {
        Text(
            text = "Rounded Corner Card",
            color = MDark,
            fontFamily = GilroyFontFamily,
            fontSize = TEXT_SIZE_16sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = TEXT_SIZE_1sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = DIMENS_48dp)
        )
    }
}

@Composable
fun CustomCardExample() {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MSecond)
            .padding(bottom = 20.dp, top = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(MDark)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_b),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(10.dp)
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(
                    text = "ANDROID", color = MaterialTheme.colorScheme.onSecondaryContainer)
                Text(text = "Jetpack Compose", color = MaterialTheme.colorScheme.outline)
            }
        }
    }
}