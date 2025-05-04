package se.android.blibb.presentation.screen.call_to_action.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import se.android.blibb.R
import se.android.blibb.presentation.screen.call_to_action.data.PreviewState
import se.android.blibb.ui.theme.Black
import se.android.blibb.ui.theme.Blur
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_12dp
import se.android.blibb.ui.theme.DIMENS_140dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_24dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_40dp
import se.android.blibb.ui.theme.DIMENS_48dp
import se.android.blibb.ui.theme.DIMENS_90dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat

@Composable
fun FirstSection(
    modifier: Modifier = Modifier,
    state: PreviewState
    ) {
        Box(
            modifier = modifier
                .height(IntrinsicSize.Max)
        ) {
            ProductBackground(
                Modifier
                    .padding(bottom = 20.dp))
            Content(
                state = state,
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(top = 24.dp))
        }
    }

        @Composable
        private fun ProductBackground(
            modifier: Modifier = Modifier
        ) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                      .background(
                            Brush.verticalGradient(
                            0f to White,
                            0.6f to Black,
                            1f to wheat))
            )
            Card(modifier = modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(0.dp),
                colors = CardDefaults.cardColors(wheat),
                shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 140.dp),
                elevation = CardDefaults.cardElevation(DIMENS_12dp))
            {
                val imageModifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp)
                    .blur(0.dp)
                Image(
                    painter = painterResource(id = R.drawable.sprint),
                    contentDescription = "sprint",
                    modifier = imageModifier,
                    contentScale = ContentScale.Crop)

            }
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(DIMENS_20dp)
                    .clip(RoundedCornerShape(
                        topStart = DIMENS_20dp,
                        topEnd = DIMENS_20dp,
                        bottomStart = DIMENS_20dp,
                        bottomEnd = DIMENS_140dp))
                    .background(Blur))
            {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = DIMENS_20dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center)
                {
                    Text(
                        text = "Running Shoes",
                        color = wheat,
                        fontFamily = GilroyFontFamily,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = TEXT_SIZE_1sp,
                        modifier = Modifier
                            .padding(top = DIMENS_24dp, bottom = DIMENS_10dp)
                    )
            }}
        }

        @Composable
        private fun Content(
            modifier: Modifier = Modifier,
            state: PreviewState
        ) {
            ConstraintLayout(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                val (actionBar, _, productImg) = createRefs()
                ActionBar(
                    headline = state.headline,
                    modifier = Modifier
                        .padding(horizontal = DIMENS_10dp)
                        .constrainAs(actionBar) {
                            top.linkTo(parent.top)
                        })
                Image(
                    painter = painterResource(id = state.productImg),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .height(248.dp)
                        .padding(start = DIMENS_32dp)
                        .constrainAs(productImg) {
                            start.linkTo(parent.start)
                            top.linkTo(anchor = actionBar.bottom, margin = DIMENS_90dp) })

            }
        }

        @Composable
        private fun ActionBar(
            modifier: Modifier = Modifier,
            headline: String
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(DIMENS_20dp)
                    .padding(top = DIMENS_48dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = headline,
                    color = wheat,
                    fontFamily = GilroyFontFamily,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = TEXT_SIZE_1sp,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .padding(top = DIMENS_40dp, bottom = DIMENS_10dp)
                        .blur(4.dp)
                )
            }
        }


