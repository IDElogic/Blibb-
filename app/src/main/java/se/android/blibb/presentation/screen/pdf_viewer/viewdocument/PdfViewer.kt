package se.android.blibb.presentation.screen.pdf_viewer.viewdocument

import android.graphics.pdf.PdfRenderer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import retrofit2.http.Url
import se.android.blibb.presentation.screen.pdf_viewer.network.provideDownloadInterface
import se.android.blibb.presentation.screen.pdf_viewer.utils.PfdHelper
import se.android.blibb.ui.theme.wheat
import se.android.blibb.ui.theme.zuzmo


@Composable
fun PdfViewer(
   modifier: Modifier = Modifier,
   @Url
   url: String,
   headers: HashMap<String, String>? = null,
   pagesVerticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(8.dp),
   accentColor: Color = zuzmo,
   iconTint: Color = wheat,
   controlsAlignment: Alignment = Alignment.BottomEnd,
   bitmapScale : Int = 1
) {

   val rendererScope = rememberCoroutineScope()
   val mutex = remember { Mutex() }

   val context = LocalContext.current

   val renderer by produceState<PdfRenderer?>(null, url) {
      rendererScope.launch(Dispatchers.IO) {
         val pfdHelper = PfdHelper()

         value = PdfRenderer(pfdHelper.getPfd(url.split("/").last(), context, provideDownloadInterface(headers).downloadFile(url)))
      }
      awaitDispose {
         val currentRenderer = value
         rendererScope.launch(Dispatchers.IO) { mutex.withLock { currentRenderer?.close() } }
      }
   }

   PdfViewerDisplay(
      accentColor = accentColor,
      modifier = modifier,
      context = context,
      renderer = renderer,
      documentIdentifier = url,
      pagesVerticalArrangement = pagesVerticalArrangement,
      mutex = mutex,
      controlsAlignment = controlsAlignment,
      iconTint = iconTint,
      bitmapScale = bitmapScale
   )
}




