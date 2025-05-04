package se.android.blibb.presentation.screen.qr_code.create

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_10sp
import se.android.blibb.ui.theme.wheat

@Composable
fun QrScannerScreen(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    var scanText by remember { mutableStateOf("") }

    Scaffold(modifier = Modifier.fillMaxSize())
    { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(Ros ),
                        onClick = {
                        scanQrResult(context = context) {
                            scanText = this
                        }
                    }) {
                        Text(
                            text = "Scan QR Code",
                            fontFamily = GilroyFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = TEXT_SIZE_10sp,
                            color = MDark
                        )
                    }
                    Button(
                        colors = ButtonDefaults.buttonColors(MDark),
                        onClick = {
                        scanText = ""
                    }) {
                        Text(
                            text = "Clear",
                            fontFamily = GilroyFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = TEXT_SIZE_10sp,
                            color = wheat)
                    }
                }
                AnimatedVisibility(
                    visible = scanText.isNotEmpty()
                ) {
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        text = scanText,
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = TEXT_SIZE_10sp,
                        color = MSecond)
                }
            }
        }
    }
}
