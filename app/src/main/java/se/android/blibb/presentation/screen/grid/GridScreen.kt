package se.android.blibb.presentation.screen.grid

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_24dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat

@SuppressLint("UnrememberedMutableState")
@Composable
fun GridScreen(
) {
    Box {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(MSecond)
                .padding(top = DIMENS_20dp)
        ){
            Row(
                modifier = Modifier
                    .padding( DIMENS_20dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Grid Layout",
                    textAlign = TextAlign.Center,
                    color = wheat,
                    fontFamily = GilroyFontFamily,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = TEXT_SIZE_1sp,
                    modifier = Modifier
                        .padding(top = DIMENS_24dp, bottom = DIMENS_10dp)
                )
            }
            PhotosGrid(
                mutableStateOf(emptySet())
            )
        }
    }
}





