package se.android.blibb.presentation.component

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import se.android.blibb.ui.theme.Black
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_2sp
import se.android.blibb.ui.theme.wheat

@Composable
fun UserButtonSection(navController: NavController, modifier: Modifier)
{
    val activity = LocalContext.current as Activity
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 10.dp)
            .padding(horizontal = 20.dp)
            .background(Ros))
    {
        Column(modifier = Modifier
            .padding(end = 10.dp)
            .align(Alignment.CenterVertically))
        {
            NeuButton(
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .height(70.dp)
                    .padding(5.dp)
                    .clickable(
                        enabled = true,
                        onClick = {
                        }
                    ),
                lightColor = MDark,
                onClick = {
                }
            )
            {
                Text(
                    modifier = Modifier
                        .padding(DIMENS_20dp),
                    text = "button",
                    fontWeight = FontWeight.Medium,
                    letterSpacing = TEXT_SIZE_2sp,
                    fontSize = 12.sp,
                    color = wheat
                )
            }
        }
        Column(modifier = Modifier
            .padding(end = 10.dp)
            .align(Alignment.CenterVertically))
        {
            NeuButton(
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(5.dp)
                    .clickable(
                        enabled = true,
                        onClick = {}
                    ),
                lightColor = MDark,
                onClick = {}
            )
            {
                Text(
                    modifier = Modifier
                        .padding(DIMENS_20dp),
                    text = "button",
                    fontWeight = FontWeight.Medium,
                    letterSpacing = TEXT_SIZE_2sp,
                    fontSize = 12.sp,
                    color = wheat
                )
            }
        }
    }
}