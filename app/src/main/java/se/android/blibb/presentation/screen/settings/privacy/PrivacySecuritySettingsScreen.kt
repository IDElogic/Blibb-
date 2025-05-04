package se.android.blibb.presentation.screen.settings.privacy

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.TEXT_SIZE_16sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat

@Composable
fun PrivacySecuritySettingsScreen(navController: NavController) {
    var currentPassword by rememberSaveable { mutableStateOf("") }
    var newPassword by rememberSaveable { mutableStateOf("") }
    var confirmNewPassword by rememberSaveable { mutableStateOf("") }
    var twoFactorEnabled by rememberSaveable { mutableStateOf(false) }
    var dataSharing by rememberSaveable { mutableStateOf(true) }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(wheat)
            .padding(DIMENS_20dp))
    {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(DIMENS_1dp, MDark.copy(0.26f), RoundedCornerShape(DIMENS_10dp))
            .padding(DIMENS_10dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        IconButton(
            onClick = { navController.popBackStack() }) {
            Icon(Icons.Default.Settings,
                contentDescription = "Back")
        }
        Spacer(modifier = Modifier.height(DIMENS_20dp))
        Text(
            text = "Privacy and Security",
            color = MDark,
            fontFamily = GilroyFontFamily,
            fontSize = TEXT_SIZE_16sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = TEXT_SIZE_1sp)

        Spacer(modifier = Modifier.height(DIMENS_10dp))
        // Password change
        Text(
            text ="Change password",
            color = MDark,
            fontFamily = GilroyFontFamily,
            fontSize = TEXT_SIZE_12sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = TEXT_SIZE_1sp)

        Spacer(modifier = Modifier.height(DIMENS_10dp))
        OutlinedTextField(
            value = currentPassword,
            onValueChange = { currentPassword = it },
            label = {
                Text(
                    text = "Current password",
                    color = MDark,
                    fontFamily = GilroyFontFamily,
                    fontSize = TEXT_SIZE_12sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = TEXT_SIZE_1sp) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth())

        OutlinedTextField(
            value = newPassword,
            onValueChange = { newPassword = it },
            label = {
                Text(
                    text = "New password",
                    color = MDark,
                    fontFamily = GilroyFontFamily,
                    fontSize = TEXT_SIZE_12sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = TEXT_SIZE_1sp) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth())

        OutlinedTextField(
            value = confirmNewPassword,
            onValueChange = { confirmNewPassword = it },
            label = {
                Text(
                    text = "Confirm new password",
                    color = MDark,
                    fontFamily = GilroyFontFamily,
                    fontSize = TEXT_SIZE_12sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = TEXT_SIZE_1sp) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(DIMENS_20dp))

        Button(
            colors = ButtonDefaults.buttonColors(Ros),
            onClick = {
                navController.navigate("profile_details")
            },
            modifier = Modifier
                .height(60.dp)
                .width(200.dp)
                .align(Alignment.End)
                .clip(RoundedCornerShape(50.dp)))

        {
            Text(
                text = "Change password",
                color = wheat,
                fontFamily = GilroyFontFamily,
                fontSize = TEXT_SIZE_12sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = TEXT_SIZE_1sp
            )
        }
        Spacer(modifier = Modifier.height(DIMENS_20dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Two-step verification",
                color = MDark,
                fontFamily = GilroyFontFamily,
                fontSize = TEXT_SIZE_12sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = TEXT_SIZE_1sp)
            Switch(
                colors = SwitchDefaults.colors(
                    checkedThumbColor = wheat
                ),
                checked = twoFactorEnabled,
                onCheckedChange = {
                    twoFactorEnabled = it
                }
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Data sharing settings",
                color = MDark,
                fontFamily = GilroyFontFamily,
                fontSize = TEXT_SIZE_12sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = TEXT_SIZE_1sp)
            Switch(
                colors = SwitchDefaults.colors(checkedThumbColor = wheat),
                checked = dataSharing,
                onCheckedChange = {
                    dataSharing = it
                }
            )
        }
        Spacer(modifier = Modifier.height(DIMENS_20dp))

        // Save button
        Button(

            colors = ButtonDefaults.buttonColors(
                Ros ),
            onClick = {  },
            modifier = Modifier
                .height(60.dp)
                .width(160.dp)
                .align(Alignment.End)
        ) {
            Text(text = "Save settings",
                color = wheat,
                fontFamily = GilroyFontFamily,
                fontSize = TEXT_SIZE_12sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = TEXT_SIZE_1sp)
        }
    }
}}