package se.android.blibb.presentation.screen.settings.notifications

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_48dp
import se.android.blibb.ui.theme.MSecond

@Composable
fun NotificationSettingItem(
    setting: NotificationSetting,
    onToggle: (Boolean) -> Unit
) {
    Column {
        Divider(
            modifier = Modifier
                .height(DIMENS_1dp),
            color = MSecond.copy(0.26f)
        )
        Row(
            modifier = Modifier
                .padding(DIMENS_20dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = setting.title,
                modifier = Modifier
            )
            Switch(
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(0xFF9F18A4)
                ),
                modifier = Modifier
                    .width(DIMENS_48dp),
                checked = setting.enabled,
                onCheckedChange = onToggle
            )
        }
    }
}