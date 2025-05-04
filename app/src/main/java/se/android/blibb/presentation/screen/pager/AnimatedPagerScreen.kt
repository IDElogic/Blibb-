package se.android.blibb.presentation.screen.pager

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import se.android.blibb.R
import se.android.blibb.ui.theme.BlibbTheme
import se.android.blibb.ui.theme.DIMENS_180dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_48dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.TEXT_SIZE_18sp
import se.android.blibb.ui.theme.wheat
import kotlin.math.absoluteValue


@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
internal fun AnimatedPagerScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val pageWidth = (screenWidth / 3f).dp
    val drawables =
        listOf(
            R.drawable.pic_2,
            R.drawable.pic_2,
            R.drawable.pic_2,
            R.drawable.rea,
            R.drawable.pic_2,
        )

    BlibbTheme {
        Surface(
            modifier = modifier
                .padding(horizontal = 0.dp, vertical = DIMENS_20dp),

        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(DIMENS_48dp))
                AnimatedViewPager(
                    modifier = Modifier
                        .fillMaxWidth()
                        .semantics { contentDescription = context.getString(R.string.content_description_viewpager) },
                    pageSize = pageWidth, // Page is in square shape
                    drawables = drawables,
                )
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun AnimatedViewPager(
    modifier: Modifier = Modifier,
    pageSize: Dp,
    @DrawableRes
    drawables: List<Int>,
) {
    val endlessPagerMultiplier = 1000
    val pageCount = endlessPagerMultiplier * drawables.size
    val initialPage = pageCount / 2

    val pagerState = rememberPagerState(
        initialPage = initialPage,
        initialPageOffsetFraction = 0f,
        pageCount = { pageCount },
    )

    var currentPageIndex by remember { mutableIntStateOf(initialPage) }
    val hapticFeedback = LocalHapticFeedback.current
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { currentPage ->
            if (currentPageIndex != currentPage) {
                hapticFeedback.performHapticFeedback(
                    hapticFeedbackType = HapticFeedbackType.LongPress,
                )
                currentPageIndex = currentPage
            }
            // Anything to be triggered by page-change can be done here
        }
    }

    HorizontalPager(
        modifier = modifier,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = pageSize),
        verticalAlignment = Alignment.CenterVertically,
    ) { absolutePageIndex ->
        val resolvedPageContentIndex = absolutePageIndex % drawables.size

        PageLayout(
            modifier = Modifier
                .size(size = pageSize)
                .pagerAnimation(
                    pagerState = pagerState,
                    thisPageIndex = absolutePageIndex,
                ),
            drawable = drawables[resolvedPageContentIndex],
        )
    }
}

@Composable
internal fun PageLayout(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,
) {
    Card(
        modifier = modifier
            .width(DIMENS_180dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(wheat),
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .width(DIMENS_180dp),
                painter = painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
fun Modifier.pagerAnimation(
    pagerState: PagerState,
    thisPageIndex: Int,
): Modifier {
    val pageOffset =
        (pagerState.currentPage - thisPageIndex) + pagerState.currentPageOffsetFraction

    return this then Modifier.graphicsLayer {
        alpha =
            lerp(
                start = 0.4f,
                stop = 1f,
                fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f),
            )

        cameraDistance = 8 * density
        rotationY =
            lerp(
                start = 0f,
                stop = 40f,
                fraction = pageOffset.coerceIn(-1f, 1f),
            )

        lerp(
            start = 0.5f,
            stop = 1f,
            fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f),
        ).also { scale ->
            scaleX = scale
            scaleY = scale
        }
    }
}

