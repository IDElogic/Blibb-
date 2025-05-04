package se.android.blibb.presentation.screen.pdf_viewer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import se.android.blibb.R
import se.android.blibb.presentation.screen.pdf_viewer.viewdocument.PdfViewer
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_4dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.wheat


@Composable
fun PDFViewerScreen()
{
    Scaffold(
        topBar = {
            Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = DIMENS_20dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier)
                {
                    Text(
                        text = "PDF Reader",
                        textAlign = TextAlign.Center,
                        style = LocalTextStyle.current.copy(
                            color = MDark,
                            fontFamily = GilroyFontFamily,
                            fontWeight = FontWeight.Black,
                            fontSize = 24.sp
                        )
                    )
                }
                Box {
                    Image(
                        painter = rememberImagePainter(
                            data = R.drawable.icon,
                            builder = {
                                crossfade(true)
                                placeholder(R.drawable.icon)
                            }
                        ),
                        contentDescription = "profile",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(50.dp, 50.dp)
                            .clip(RoundedCornerShape(DIMENS_8dp)))
                }
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(wheat)
                    .padding(horizontal = DIMENS_4dp)
                    .padding(paddingValues = it)
            ) {
                    PdfViewer(
                        url = "https://commonsware.com/Jetpack/Jetpack-FINAL.pdf"
                    )
            }
        }
    )
}




