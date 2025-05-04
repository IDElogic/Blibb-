package se.android.blibb.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import se.android.blibb.navigation.graph.MainNavGraph
import se.android.blibb.presentation.component.BottomBar
import se.android.blibb.presentation.screen.auth.registration.UserViewModel

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    val userViewModel: UserViewModel = hiltViewModel()

    Scaffold(
        bottomBar = {
            Surface(
                shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp)
            ) {
                BottomBar(navController = navController)
            }
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            MainNavGraph(
                cartViewModel = hiltViewModel(),
                navController = navController,
                userViewModel = userViewModel
            )
        }
    }
}