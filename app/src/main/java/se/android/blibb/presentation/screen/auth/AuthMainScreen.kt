package se.android.blibb.presentation.screen.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import se.android.blibb.navigation.graph.Graph
import se.android.blibb.presentation.screen.auth.navigation.AuthScreen
import se.android.blibb.presentation.screen.auth.registration.UserViewModel


@Composable
fun AuthMainScreen(userViewModel: UserViewModel, navController: NavController) {
    val currentUser by userViewModel.currentUser.collectAsState()

    LaunchedEffect(currentUser) {
        when {
            currentUser == null -> navController.navigate(AuthScreen.Login.route)
            currentUser?.isAdmin == true -> navController.navigate(Graph.MAIN) {
                popUpTo(Graph.AUTH) { inclusive = true }
            }
            else -> navController.navigate(Graph.MAIN) {
                popUpTo(Graph.AUTH) { inclusive = true }
            }
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}





