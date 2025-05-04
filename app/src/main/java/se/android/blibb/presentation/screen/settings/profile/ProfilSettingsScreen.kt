package se.android.blibb.presentation.screen.settings.profile

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import se.android.blibb.R
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat

@Composable
fun ProfileSettingsScreen(
    navController: NavHostController,
    viewModel: ProfileSettingsViewModel
) {
    val profileApi = ProfileApiImpl()
    val viewModel: ProfileSettingsViewModel = viewModel(
        factory = ProfileSettingsViewModelFactory(profileApi)
    )

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }
    var profileImageUri by remember { mutableStateOf<Uri?>(null) }

    val updateResult by viewModel.updateResult.collectAsState()

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { profileImageUri = it }
    }

    val userData by viewModel.userData.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(wheat)
            .border(DIMENS_1dp, MDark, RoundedCornerShape(DIMENS_20dp))
            .padding(DIMENS_20dp))
    {
        Text("Edit profile", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))

        // Profile picture
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .clickable { imagePickerLauncher.launch("image/*") }
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = profileImageUri ?: R.drawable.bg_b,
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = "Profile picture",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = "Click on the image to modify",
            color = MDark,
            fontFamily = GilroyFontFamily,
            fontSize = TEXT_SIZE_12sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = TEXT_SIZE_1sp,
            modifier = Modifier
                .padding(DIMENS_8dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = userData.username,
            colors = TextFieldDefaults.textFieldColors(Color(0xFF9F18A4) ),
            onValueChange = { viewModel.updateUserData(userData.copy(username = it)) },
            label = {
                Text(
                    text ="Username",
                    color = MDark,
                    fontFamily = GilroyFontFamily,
                    fontSize = TEXT_SIZE_12sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = TEXT_SIZE_1sp
                )
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = userData.email,
            colors = TextFieldDefaults.textFieldColors(),
            onValueChange = { email = it },
            label = {
                Text(
                    text ="E-mail address",
                    color = MDark,
                    fontFamily = GilroyFontFamily,
                    fontSize = TEXT_SIZE_12sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = TEXT_SIZE_1sp
                )
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = userData.phoneNumber,
            colors = TextFieldDefaults.textFieldColors(),
            onValueChange = { phoneNumber = it },
            label = {
                Text(
                    text ="Telephone Number",
                    color = MDark,
                    fontFamily = GilroyFontFamily,
                    fontSize = TEXT_SIZE_12sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = TEXT_SIZE_1sp
                )
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            colors = ButtonDefaults.buttonColors(Ros ),
            onClick = {
                navController.navigate("profile_details")
            },
            modifier = Modifier
                .height(50.dp)
                .width(120.dp)
                .align(Alignment.End)
                .clip(RoundedCornerShape(50.dp))
        ) {
            Text(
                text = "Save",
                color = wheat,
                fontFamily = GilroyFontFamily,
                fontSize = TEXT_SIZE_12sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = TEXT_SIZE_1sp
            )
        }
    }

    LaunchedEffect(updateResult) {
        updateResult?.let { result ->
            when {
                result.isSuccess -> {
                    //
                    navController.popBackStack()
                }
                result.isFailure -> {
                    //
                }
            }
        }
    }
}