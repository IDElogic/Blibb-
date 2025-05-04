package se.android.blibb.presentation.common.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import se.android.blibb.R
import se.android.blibb.ui.theme.*

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(start = DIMENS_16dp, end = DIMENS_16dp)
            .fillMaxWidth()
    ) {
        Card(
            border = BorderStroke(1.dp, color = Black.copy(0.46f)),
            shape = RoundedCornerShape(50.dp),
        ) {
            Image(
                modifier = Modifier
                    .height(DIMENS_80dp)
                    .width(DIMENS_80dp),
                painter = painterResource(id = R.drawable.bg_b),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(R.string.image_profile)
            )
        }
        Spacer(modifier = Modifier.width(DIMENS_16dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
        ) {
            Text(
                text = "About UI Sample",
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = TEXT_SIZE_16sp,
                color = wheat.copy(0.46f)
            )
            Spacer(modifier = Modifier.width(DIMENS_16dp))
            Text(
                text = "e-mail",
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = TEXT_SIZE_12sp,
                color = MDark
            )
        }
    }
}