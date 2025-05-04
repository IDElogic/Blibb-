package se.android.blibb.presentation.screen.settings.notifications

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import se.android.blibb.ui.theme.Blur
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_2dp
import se.android.blibb.ui.theme.DIMENS_48dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat

data class NotificationSetting(
    val title: String,
    var enabled: Boolean
)

@Composable
fun NotificationSettingsScreen(navController: NavController) {
    var notificationSettings by rememberSaveable {
        mutableStateOf(
            listOf(
                NotificationSetting("New Messages", true),
                NotificationSetting("Mentions", true),
                NotificationSetting("Updates", false),
                NotificationSetting("Promotions", false)
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Blur),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier
            .height(DIMENS_48dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(DIMENS_20dp)
                    .background(Blur)
                    .border(DIMENS_1dp,wheat))
            {
                Spacer(modifier = Modifier.height(DIMENS_20dp))
                Text(
                    modifier = Modifier.padding(DIMENS_20dp),
                    textAlign = TextAlign.Center,
                    text = "Notifications",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(DIMENS_10dp))
                notificationSettings.forEachIndexed { index, setting ->
                    NotificationSettingItem(
                        setting = setting,
                        onToggle = { enabled ->
                            notificationSettings = notificationSettings.toMutableList().also {
                                it[index] = setting.copy(enabled = enabled)
                            }
                        },
                    )
                }
            }

        Spacer(modifier = Modifier.height(DIMENS_20dp))

            Button(
                modifier = Modifier
                    .height(60.dp)
                    .width(120.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = DIMENS_2dp, horizontal = DIMENS_16dp),
                colors = ButtonDefaults.buttonColors(Ros),
                onClick = {
                    navController.navigate("profile_details")
                },)
                {
                    Text(
                        text = "Save",
                        color = wheat,
                        fontFamily = GilroyFontFamily,
                        fontSize = TEXT_SIZE_12sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TEXT_SIZE_1sp
                    )
                }

        Spacer(modifier = Modifier.height(DIMENS_10dp))
            IconButton(
                modifier = Modifier
                    .height(60.dp)
                    .width(120.dp)
                    .fillMaxWidth(0.8f)
                    .border(DIMENS_1dp, MDark.copy(0.26f), RoundedCornerShape(DIMENS_20dp))
                    .padding(DIMENS_10dp),
                onClick = {
                    navController.popBackStack()})
            {
                Column {
                    Icon(
                        Icons.Default.Refresh,
                        contentDescription = "back",
                        modifier = Modifier
                            .size(DIMENS_20dp),
                        tint = MDark
                    )
                }
            }
        }
    }




