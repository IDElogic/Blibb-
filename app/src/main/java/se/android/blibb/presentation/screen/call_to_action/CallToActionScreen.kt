package se.android.blibb.presentation.screen.call_to_action

import android.annotation.SuppressLint
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import se.android.blibb.R
import se.android.blibb.presentation.component.NeuButton
import se.android.blibb.presentation.screen.call_to_action.components.FirstSection
import se.android.blibb.presentation.screen.call_to_action.components.ItemSection
import se.android.blibb.presentation.screen.call_to_action.data.ItemData
import se.android.blibb.presentation.screen.call_to_action.data.ItemState
import se.android.blibb.presentation.screen.call_to_action.data.PreviewState
import se.android.blibb.ui.theme.Black
import se.android.blibb.ui.theme.Blur
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_4dp
import se.android.blibb.ui.theme.DIMENS_90dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_10sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun CallToActionScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    productPreviewState: PreviewState = PreviewState (),
    productItems: List<ItemState> = ItemData)
{
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Content(navController = navController,
            productItems = productItems,
            productPreviewState = productPreviewState
        )
    }
}

@Composable
private fun Content(
    navController: NavController,
    modifier: Modifier = Modifier,
    productPreviewState: PreviewState,
    productItems: List<ItemState>)
{
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .background(wheat)
            .verticalScroll(scrollState)
    ) {
        FirstSection(
            state = productPreviewState)
        Spacer(modifier = Modifier.height(16.dp))
        ItemSection(
            data = productItems,
            modifier = Modifier.padding(horizontal = 18.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = DIMENS_10dp)
                .clip(
                    RoundedCornerShape(
                        topStart = DIMENS_90dp,
                        topEnd = 0.dp,
                        bottomStart = DIMENS_90dp,
                        bottomEnd = 0.dp))
                .height(100.dp))
        {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Blur)
                    .padding(start = DIMENS_10dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround)
            {
                NeuButton(
                    shape = RoundedCornerShape(90.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.2f)
                        .height(60.dp)
                        .padding(start = DIMENS_20dp)
                        .border(1.dp, Black, RoundedCornerShape(90.dp))
                        .clickable(
                            enabled = true,
                            onClick = {}),
                    lightColor = Ros,
                    onClick = {})
                {
                    Box {
                        Image(
                            painter = rememberImagePainter(R.drawable.sprint,
                                builder = {
                                    crossfade(true)
                                    placeholder(R.drawable.sprint)
                                }),
                            contentDescription = "bg",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable {})
                    }
                }
                NeuButton(
                    shape = RoundedCornerShape(90.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(60.dp)
                        .padding(start = DIMENS_4dp)
                        .border(1.dp, Ros, RoundedCornerShape(90.dp)),
                    lightColor = Ros,
                    onClick = {}
                ) {
                    Image(
                        colorFilter = ColorFilter.tint(wheat),
                        painter = painterResource(id = R.drawable.baseline_bubble_chart_24),
                        contentDescription = "attached-file",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(0.dp)
                            .size(DIMENS_16dp))
                }
                NeuButton(
                    shape = RoundedCornerShape(
                        topStart = DIMENS_90dp,
                        topEnd = 0.dp,
                        bottomStart = DIMENS_90dp,
                        bottomEnd = 0.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(start = DIMENS_4dp)
                        .border(1.dp, MSecond, RoundedCornerShape(
                            topStart = DIMENS_90dp,
                            topEnd = 0.dp,
                            bottomStart = DIMENS_90dp,
                            bottomEnd = 0.dp
                        )),
                    lightColor = MSecond,
                    onClick = {
                        navController.navigate("subscribe")
                    })
                {
                    Text(
                        text = "subscribe",
                        color = wheat,
                        fontFamily = GilroyFontFamily,
                        fontSize = TEXT_SIZE_10sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = TEXT_SIZE_1sp
                    )
                }
            }
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )
    }
}
