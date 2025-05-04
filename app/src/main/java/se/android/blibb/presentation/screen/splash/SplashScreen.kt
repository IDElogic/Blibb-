package se.android.blibb.presentation.screen.splash

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import se.android.blibb.R
import se.android.blibb.navigation.graph.Graph
import se.android.blibb.navigation.screen.Screen
import se.android.blibb.ui.theme.Blur2
import se.android.blibb.ui.theme.DIMENS_160dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_353dp
import se.android.blibb.ui.theme.wheat

enum class WelcomeState {
    INITIAL,
    RUNNING,
    GONE
}
@Composable
fun SplashScreen(
    navController: NavHostController
) {
    val animState = remember { MutableStateFlow(WelcomeState.INITIAL) }
    var isFirstTime by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        while (true) {
            animState.value = WelcomeState.INITIAL
            if (isFirstTime) {
                isFirstTime = false
            } else {
                delay(3000)
            }
            animState.value = WelcomeState.RUNNING
            delay(3000)
            animState.value = WelcomeState.GONE
            delay(2500)
            navController.navigate(Graph.AUTH) {
                popUpTo(Screen.Splash.route) { inclusive = true }
            }
        }
    }
    RunningWelcomeScreenSkeleton(
        animState
    )
}

@Composable
fun RunningWelcomeScreenSkeleton(
    animStateFlow: StateFlow<WelcomeState>
) {
    val animState = animStateFlow.collectAsState()
    Scaffold(
        modifier = Modifier
            .navigationBarsPadding()
            .imePadding()
            .statusBarsPadding()
            .fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = R.drawable.wall),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                alpha = DefaultAlpha)
            Column(modifier =Modifier
                .fillMaxSize()
                .background(Blur2),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(top = DIMENS_353dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    val transition = rememberInfiniteTransition()
                    val updateTransition =
                        updateTransition(animState.value, label = "fore&back-ground")
                    val animateCarPositionX by updateTransition.animateFloat(
                        label = "Car X position",
                        transitionSpec = {
                            tween(
                                2000,
                                easing = CubicBezierEasing(0.0f, 0.0f, 0.5f, 1.0f)
                            )
                        }
                    ) { state ->
                        when (state) {
                            WelcomeState.INITIAL -> -1000f
                            WelcomeState.RUNNING -> 0f
                            WelcomeState.GONE -> 1000f
                        }
                    }

                    val animatePositionCar by transition.animateFloat(
                        initialValue = 3f,
                        targetValue = -3f,
                        animationSpec = infiniteRepeatable(
                            tween(300),
                            RepeatMode.Reverse
                        ),
                        label = "welcome"
                    )
                    Image(
                        painterResource(id = R.drawable.welcome),
                        contentDescription = "welcome",
                        colorFilter = ColorFilter.tint(wheat),
                        modifier = Modifier
                            .padding(bottom = DIMENS_32dp)
                            .size(DIMENS_160dp)
                            .graphicsLayer {
                                translationX = animateCarPositionX
                                translationY = animatePositionCar
                            }
                    )
                }
            }
        }
    }
}