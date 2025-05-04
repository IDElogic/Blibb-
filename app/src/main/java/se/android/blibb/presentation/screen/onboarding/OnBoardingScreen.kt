package se.android.blibb.presentation.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import se.android.blibb.R
import se.android.blibb.navigation.graph.Graph
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_40dp
import se.android.blibb.ui.theme.DIMENS_68dp
import se.android.blibb.ui.theme.DIMENS_90dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.TEXT_SIZE_16sp
import se.android.blibb.ui.theme.wheat

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
) {
    OnBoarding(
        modifier = modifier.fillMaxSize(),
        onClick = {
            navController.popBackStack()
            navController.navigate(Graph.MAIN)
            onBoardingViewModel.saveOnBoardingState(isCompleted = true)
        }
    )
}

@Composable
fun OnBoarding(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.wall),
            contentDescription = stringResource(R.string.image_on_boarding),
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = DIMENS_90dp),
            color = Color.Transparent
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(DIMENS_40dp))
                Button(
                    onClick = {
                        onClick.invoke()
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(height = DIMENS_68dp)
                        .padding(start = DIMENS_16dp, end = DIMENS_16dp),
                    colors = ButtonDefaults.buttonColors(wheat),
                    shape = RoundedCornerShape(50.dp),
                ) {
                    Text(
                        text = "start",
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = TEXT_SIZE_16sp,
                        color = MDark
                    )
                }
            }
        }
    }
}
