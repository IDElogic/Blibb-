package se.android.blibb.presentation.screen.smarthome_two

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import se.android.blibb.R
import se.android.blibb.presentation.screen.smarthome_two.model.SmartHomeTwoBottomNavigationItem
import se.android.blibb.presentation.screen.smarthome_two.navigation.SmartHomeTwoNavigation
import se.android.blibb.ui.theme.BlibbTheme
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.wheat
import kotlin.collections.forEachIndexed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmartHomeTwo(navController : NavController)
{
    BlibbTheme(
             darkTheme = true
             ) {
         val smartHomeTwoBottomNavigationItems = listOf(
             SmartHomeTwoBottomNavigationItem(
                 route = "home",
                 title = "Home",
                 selectedIcon = R.drawable.ic_home,
                 hasNews = false
             ),
             SmartHomeTwoBottomNavigationItem(
                 route = "search",
                 title = "Search",
                 selectedIcon = R.drawable.ic_search,
                 hasNews = true
             ),
             SmartHomeTwoBottomNavigationItem(
                 route = "application",
                 title = "Application",
                 selectedIcon = R.drawable.ic_grid,
                 hasNews = false,
                 badgeCount = 20
             ),
             SmartHomeTwoBottomNavigationItem(
                 route = "profile",
                 title = "Profile",
                 selectedIcon = R.drawable.ic_profile,
                 hasNews = false,
             ),
         )
         Surface(
             modifier = Modifier.fillMaxSize(),
             color = MaterialTheme.colorScheme.background
         ) {
             Scaffold(
                 bottomBar = {
                     SmartHomeTwoBottomNavigationBar(
                         items = smartHomeTwoBottomNavigationItems,
                         navController = navController,
                         onItemCLick = {
                             if (
                                 it == smartHomeTwoBottomNavigationItems.first()
                                 || it == smartHomeTwoBottomNavigationItems.component2()
                             ) {
                                 navController.navigate(it.route) {
                                     popUpTo(0)
                                 }
                             }
                         },
                     )
                 },
                 contentWindowInsets = WindowInsets(
                     left = 0.dp,
                     top = 0.dp,
                     right = 0.dp,
                     bottom = 0.dp
                 )
             ) {
                 Box(modifier = Modifier.padding(it)) {
                     SmartHomeTwoNavigation(navController = navController as NavHostController)
                 }
             }
             }
         }
     }


    @Composable
    fun SmartHomeTwoBottomNavigationBar(
        items: List<SmartHomeTwoBottomNavigationItem>,
        navController: NavController,
        onItemCLick: (SmartHomeTwoBottomNavigationItem) -> Unit
    ) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    NavigationBar(
        containerColor = MSecond,
        tonalElevation = 4.dp,
        modifier = Modifier
    ) {
        items.forEachIndexed { index, smartHomeTwoBottomNavigationItem ->

            val selected = smartHomeTwoBottomNavigationItem.route == backStackEntry.value?.destination?.route

            NavigationBarItem(
                selected = selected,
                colors = NavigationBarItemDefaults
                    .colors(
                        selectedIconColor = MSecond,
                        indicatorColor = MDark
                    ),
                onClick = {
                    onItemCLick(smartHomeTwoBottomNavigationItem)
                },
                label = {
                    Text(text = smartHomeTwoBottomNavigationItem.title)
                },
                alwaysShowLabel = false,
                icon = {
                    BadgedBox(
                        badge = {
                            if (smartHomeTwoBottomNavigationItem.badgeCount != null) {
                                Badge {
                                    Text(text = smartHomeTwoBottomNavigationItem.badgeCount.toString())
                                }
                            } else if (smartHomeTwoBottomNavigationItem.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = smartHomeTwoBottomNavigationItem.selectedIcon),
                            contentDescription = smartHomeTwoBottomNavigationItem.title,
                            tint = if (selected)
                                Ros
                            else
                                wheat
                        )
                    }
                }
            )
        }
    }
}








