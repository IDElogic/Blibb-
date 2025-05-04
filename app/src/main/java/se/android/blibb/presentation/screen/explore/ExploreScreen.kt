package se.android.blibb.presentation.screen.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import se.android.blibb.R
import se.android.blibb.presentation.component.PortfolioCardAnimation
import se.android.blibb.ui.theme.Blur2
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.MSecond

@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        modifier = Modifier,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = modifier
                    .background(MSecond)
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
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
                        .fillMaxSize()
                        .background(Blur2)
                        .padding(DIMENS_20dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Content(navController = navController)
                }
            }
        }}
}

@Composable
private fun Content(
    navController: NavController)
{
    val scrollState = rememberScrollState()
    PortfolioCardAnimation(
        navController = navController
    )
}



