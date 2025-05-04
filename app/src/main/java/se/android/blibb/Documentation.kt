package se.android.blibb

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.play.core.integrity.v
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.wheat


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Documentation (
    navController: NavController
) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }

    Scaffold(
        modifier = Modifier
            .padding(horizontal = DIMENS_20dp, vertical = DIMENS_10dp)
            .fillMaxSize(),
        content = {
            Column(
                modifier = Modifier
                    .background(wheat)
                    .fillMaxSize()
                    .padding(top = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = "Jetpack Compose UI Playground",
                    modifier = Modifier
                        .padding(20.dp),
                    color = MDark,
                    style = MaterialTheme.typography.titleLarge
                )
                Divider(
                        modifier = Modifier
                            .padding(10.dp),
                thickness = 1.dp,
                color = MDark
                )
                Text(
                    modifier = Modifier
                        .padding(DIMENS_20dp),
                    text = "A feature-rich demonstration app showcasing Jetpack Compose's capabilities through various polished UI implementations. This project serves as both a learning resource and inspiration for Me ...and maybe for others too.",
                    color = MDark,
                    style = MaterialTheme.typography.titleSmall
                )

                Column(
                    modifier = Modifier
                        .background(wheat)
                        .fillMaxSize()
                        .verticalScroll(state),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ){
                    repeat(1) {
                        Divider(
                            modifier = Modifier
                                .padding(10.dp),
                            thickness = 1.dp,
                            color = MDark
                        )
                        Text(
                            text = "Features ",
                            modifier = Modifier
                                .padding(20.dp),
                            color = MDark,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(DIMENS_20dp))
                        Text(
                            text = stringResource(id = R.string.documentation),
                            modifier = Modifier
                                .padding(20.dp),
                            color = MDark,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Divider(
                            modifier = Modifier
                                .padding(10.dp),
                            thickness = 1.dp,
                            color = MDark
                        )
                }
                    Text(
                        text = "Tech Stack",
                        modifier = Modifier
                            .padding(20.dp),
                        color = MDark,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        modifier = Modifier
                            .padding(20.dp),
                        text = " - 100% Jetpack Compose UI\n" +
                                "- MVVM (Model View View Model)\n" +
                                "- Material 3 Design System\n" +
                                "- Use Case (for interaction data)\n" +
                                "- Room Database\n" +
                                "- Accompanist for permission handling\n" +
                                "- Clean Architecture (data, domain, layer)\n" +
                                "- PDFBox for document rendering\n" +
                                "- Kotlin Coroutines for async operations\n" +
                                "- ViewModel & State management\n" +
                                "- Kotlin & Coroutines (Flow)\n" +
                                "- SQLDelight",
                        color = MDark,
                        style = MaterialTheme.typography.titleSmall
                    )
            }
        }
    }
    )
}





