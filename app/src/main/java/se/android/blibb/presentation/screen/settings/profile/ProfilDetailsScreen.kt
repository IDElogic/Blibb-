package se.android.blibb.presentation.screen.settings.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_2dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat

@Composable
fun ProfileDetailsScreen(viewModel: ProfileSettingsViewModel) {
    val userData by viewModel.userData.collectAsState()

    Column(modifier = Modifier
        .padding(top = 16.dp)) {
        Text(
            modifier = Modifier
                .padding(horizontal = DIMENS_20dp, vertical = DIMENS_2dp),
            text ="Username: ${userData.username}",
            color = wheat.copy(0.66f),
            fontFamily = GilroyFontFamily,
            fontSize = TEXT_SIZE_12sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = TEXT_SIZE_1sp)
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        Text(
            modifier = Modifier
                .padding(horizontal = DIMENS_20dp, vertical = DIMENS_2dp),
            text ="E-mail: ${userData.email}",
            color = wheat.copy(0.66f),
            fontFamily = GilroyFontFamily,
            fontSize = TEXT_SIZE_12sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = TEXT_SIZE_1sp)
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        Text(
            modifier = Modifier
                .padding(horizontal = DIMENS_20dp, vertical = DIMENS_2dp),
            text ="Mobil: ${userData.phoneNumber}",
            color = wheat.copy(0.66f),
            fontFamily = GilroyFontFamily,
            fontSize = TEXT_SIZE_12sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = TEXT_SIZE_1sp)
    }
}