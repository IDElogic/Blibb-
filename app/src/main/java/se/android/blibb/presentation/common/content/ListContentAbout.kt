package se.android.blibb.presentation.common.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import se.android.blibb.R
import se.android.blibb.domain.model.AboutItem
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_4dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.wheat
import se.android.blibb.utils.DataDummy

@Composable
fun ListContentAbout(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(top = DIMENS_32dp),
        verticalArrangement = Arrangement.spacedBy(DIMENS_8dp)
    ) {
        items(DataDummy.generateDummyAbout()) { items ->
            ItemAbout(aboutItem = items)
        }
    }

    Spacer(modifier = Modifier.height(DIMENS_8dp))

    Divider(
        modifier = Modifier
            .height(DIMENS_4dp),
        color = wheat.copy(0.26f))
}

@Composable
fun ItemAbout(
    modifier: Modifier = Modifier,
    aboutItem: AboutItem
) {
    Column {
        Divider(
            modifier = Modifier
                .height(DIMENS_1dp),
            color = wheat.copy(0.26f)
        )
        Row(
            modifier = modifier
                .padding(start = DIMENS_16dp, end = DIMENS_16dp, top = DIMENS_20dp)
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .size(DIMENS_16dp),
                colorFilter = ColorFilter.tint(wheat.copy(0.26f)),
                painter = painterResource(id = aboutItem.image),
                contentDescription = stringResource(R.string.image_category)
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = DIMENS_8dp)
                    .weight(1f),
                text = aboutItem.title,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = TEXT_SIZE_12sp,
                color = wheat.copy(0.46f)
            )

            Icon(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = stringResource(id = R.string.arrow_right),
                tint = MDark
            )
        }
    }
}