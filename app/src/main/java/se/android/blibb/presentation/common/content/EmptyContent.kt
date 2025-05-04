package se.android.blibb.presentation.common.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import se.android.blibb.R
import se.android.blibb.ui.theme.*

@Composable
fun EmptyContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
     //       .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       /* Image(
            modifier = Modifier
                .size(DIMENS_140dp),
            painter = painterResource(id = R.drawable.shopping),
            contentDescription = stringResource(R.string.image_content_empty)
        )

        Spacer(modifier = Modifier.height(DIMENS_16dp))*/

        Text(
            modifier = modifier.fillMaxWidth(),
            text = stringResource(R.string.oops_no_data),
            fontFamily = GilroyFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = TEXT_SIZE_24sp,
            color = wheat,
            textAlign = TextAlign.Center,
        )
    }
}