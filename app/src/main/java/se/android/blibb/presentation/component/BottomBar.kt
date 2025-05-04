package se.android.blibb.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import se.android.blibb.navigation.screen.BottomNavItemScreen
import se.android.blibb.ui.theme.Black
import se.android.blibb.ui.theme.wheat

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val navigationItems = listOf(
        BottomNavItemScreen.Start,
        BottomNavItemScreen.Home,
        BottomNavItemScreen.Explore,
        BottomNavItemScreen.SmartHomeScreen,
        BottomNavItemScreen.About
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val bottomBarDestination = navigationItems.any { it.route == currentRoute }

    if (bottomBarDestination) {
        BottomNavigation(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(0.dp)),
            backgroundColor = Black,
            contentColor = wheat,)
        {
            navigationItems.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            modifier = Modifier
                                .size(20.dp),
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = if (currentRoute == item.route) {
                                wheat
                            } else wheat.copy(0.26f)
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontWeight = FontWeight.Normal,
                            fontSize = 10.sp,
                            color = if (currentRoute == item.route) {
                                wheat
                            } else wheat.copy(0.26f)
                        )
                    },
                    selectedContentColor = wheat,
                    unselectedContentColor = wheat.copy(0.36f),
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) { saveState = true }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}