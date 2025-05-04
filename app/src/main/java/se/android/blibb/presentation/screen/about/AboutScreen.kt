package se.android.blibb.presentation.screen.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import se.android.blibb.presentation.common.card.ProfileCard
import se.android.blibb.presentation.common.content.ListContentAbout
import se.android.blibb.presentation.component.NeuButton
import se.android.blibb.ui.theme.Black
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.wheat

@Composable
fun AboutScreen() {

    Scaffold(
        content = { innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding))
            {
                Box (
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Black)
                        .padding(horizontal = DIMENS_20dp, vertical = DIMENS_32dp))
                {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Black)
                            .padding(DIMENS_20dp), verticalArrangement = Arrangement.SpaceAround
                    ) {
                        ProfileCard()
                        ListContentAbout()
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            NeuButton(
                                shape = RoundedCornerShape(50.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 40.dp)
                                    .height(60.dp),
                                lightColor = MDark,
                                onClick = {})
                            {
                                Text(
                                    text = "log out",
                                    color = wheat,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp,
                                    modifier = Modifier
                                        .padding(20.dp))
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Ros))
                {
                    Text(
                        text = "String"
                    )// Row elemei
                }
            }
        }
    )
}