package se.android.blibb.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import se.android.blibb.ui.theme.DIMENS_12dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_10sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat

@Composable
fun InfoCard(image: Painter, title: String, desc: String) {
    Box(
        modifier = Modifier
            .padding(DIMENS_20dp)
            .wrapContentSize()
    ) {
        Card (
            modifier = Modifier
                .padding(DIMENS_20dp)
                .wrapContentHeight(),
            elevation = CardDefaults.cardElevation(DIMENS_20dp),
            colors = CardDefaults.cardColors(
                containerColor = Ros
            )
        ) {
            Column (
                modifier = Modifier
                    .padding(DIMENS_12dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = image,
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        blendMode = BlendMode.ColorBurn
                    )
                )
                Column (
                    modifier = Modifier
                        .padding(bottom = 12.dp, start = 10.dp, end = 10.dp, top = 12.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = title,
                            color = wheat,
                            fontFamily = GilroyFontFamily,
                            fontSize = TEXT_SIZE_10sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = TEXT_SIZE_1sp,
                            modifier = Modifier.weight(1f, true)
                        )
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(DIMENS_8dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Ros
                            )
                        ) {
                            Image(
                                imageVector = Icons.Filled.Share,
                                contentDescription ="",
                                modifier = Modifier.size(15.dp),
                                colorFilter = ColorFilter
                                    .tint(
                                        color = MaterialTheme.colorScheme.surface
                                    )
                            )
                        }
                    }
                    Text(
                        text = desc,
                        color = Ros,
                        fontFamily = GilroyFontFamily,
                        fontSize = TEXT_SIZE_10sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TEXT_SIZE_1sp,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}
