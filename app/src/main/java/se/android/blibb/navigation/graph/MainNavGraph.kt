package se.android.blibb.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.google.accompanist.pager.ExperimentalPagerApi
import se.android.blibb.navigation.screen.BottomNavItemScreen
import se.android.blibb.navigation.screen.Screen
import se.android.blibb.presentation.screen.about.AboutScreen
import se.android.blibb.presentation.screen.auth.AuthMainScreen
import se.android.blibb.presentation.screen.auth.login.LoginScreen
import se.android.blibb.presentation.screen.auth.navigation.AuthScreen
import se.android.blibb.presentation.screen.auth.registration.UserViewModel
import se.android.blibb.presentation.screen.call_to_action.CallToActionScreen
import se.android.blibb.presentation.screen.call_to_action.data.ItemData
import se.android.blibb.presentation.screen.call_to_action.data.PreviewState
import se.android.blibb.presentation.screen.call_to_action.newsletter.NewsletterSubscription
import se.android.blibb.presentation.screen.cards_buttons.ButtonScreen
import se.android.blibb.presentation.screen.cards_buttons.CardScreen
import se.android.blibb.presentation.screen.cards_buttons.DialogScreen
import se.android.blibb.presentation.screen.shop.cart.CartScreen
import se.android.blibb.presentation.screen.shop.cart.CartViewModel
import se.android.blibb.presentation.screen.shop.cart.SummaryScreen
import se.android.blibb.presentation.screen.todolist.presentation.screen.ListScreen
import se.android.blibb.presentation.screen.shop.detail.DetailScreen
import se.android.blibb.presentation.screen.explore.ExploreScreen
import se.android.blibb.presentation.screen.shop.ShopHomeScreen
import se.android.blibb.Documentation
import se.android.blibb.presentation.screen.image.ImageScreen
import se.android.blibb.presentation.screen.explore.profile.ProfileScreen
import se.android.blibb.presentation.screen.grid.GridScreen
import se.android.blibb.presentation.screen.pager.AnimatedPagerScreen
import se.android.blibb.presentation.screen.pdf_viewer.PDFViewerScreen
import se.android.blibb.presentation.screen.qr_code.create.QrScannerScreen
import se.android.blibb.presentation.screen.recipe.RecipeUIScreen
import se.android.blibb.presentation.screen.shop.search.SearchScreen
import se.android.blibb.presentation.screen.settings.SettingsMainScreen
import se.android.blibb.presentation.screen.settings.inboxplayground.InboxScreen
import se.android.blibb.presentation.screen.settings.notifications.NotificationSettingsScreen
import se.android.blibb.presentation.screen.settings.privacy.PrivacySecuritySettingsScreen
import se.android.blibb.presentation.screen.settings.profile.ProfileApiImpl
import se.android.blibb.presentation.screen.settings.profile.ProfileSettingsScreen
import se.android.blibb.presentation.screen.settings.profile.ProfileSettingsViewModel
import se.android.blibb.presentation.screen.startscreen.StartScreen
import se.android.blibb.presentation.screen.ui_examples.UIExampleScreen
import se.android.blibb.presentation.screen.smarthome_two.home.SmartHomeScreen
import se.android.blibb.presentation.screen.smarthome_two.search.SearchDeviceList
import se.android.blibb.presentation.screen.userdata.UserDataScreen
import se.android.blibb.utils.Constants.PRODUCT_ARGUMENT_KEY

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainNavGraph(
    navController: NavHostController,
    cartViewModel: CartViewModel,
    userViewModel: UserViewModel
)
{
    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = BottomNavItemScreen.Start.route
    ) {
        composable(route = BottomNavItemScreen.Start.route) {
            StartScreen(navController = navController,
                userViewModel = UserViewModel())
        }

        composable(route = BottomNavItemScreen.Profile.route) {
            ProfileScreen(navController = navController)
        }

        composable(route = BottomNavItemScreen.Explore.route) {
            ExploreScreen(navController = navController)
        }

        composable(route = BottomNavItemScreen.Home.route) {
            ShopHomeScreen(navController = navController)
        }

        composable(route = BottomNavItemScreen.Cart.route) {
            val viewModel: CartViewModel = hiltViewModel()
            CartScreen(
                navController = navController,
                modifier = Modifier,
                cartViewModel = viewModel
            )
        }

        composable("recipes_list_screen") {
            RecipeUIScreen()
        }
        composable("animated_pager") {
            AnimatedPagerScreen()
        }
        composable("qr_scanner_screen") {
            QrScannerScreen ()
        }
        composable("grid_screen") {
            GridScreen()
        }

        composable("smart_home_two_screen") {
            SmartHomeScreen(navController = navController)
        }
        composable("search_device_list_screen") {
            SearchDeviceList(navController = navController)
        }

        fun NavGraphBuilder.pdfNavGraph(modifier: Modifier, navController: NavController) {
            navigation(
                route = Graph.PDF,
                startDestination = Screen.Pdf.route
            ) {
                composable(route = Screen.Pdf.route) {
                    PDFViewerScreen()
                }
            }
        }
        composable("user_data") {
            UserDataScreen(
                onDataSubmit = { userData ->
                    navController.navigate("payment_options/${cartViewModel.totalPrice.value}")
                },
                onCancel = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Screen.SummaryScreen.route) {
            val viewModel: CartViewModel = hiltViewModel()
         SummaryScreen(
             viewModel = viewModel,
                modifier = Modifier
            )
        }
        composable("dialog_screen") {
            DialogScreen(navController = navController, modifier = Modifier)
        }
        composable("card_screen") {
            CardScreen(navController = navController, modifier = Modifier)
        }
        composable("button_screen") {
            ButtonScreen()
        }
        composable("image_screen") {
            ImageScreen(modifier = Modifier)
        }
        composable(route = BottomNavItemScreen.About.route) {
            AboutScreen()
        }
        composable("documentation") {
            Documentation(navController = navController)
        }
        composable(route = Graph.LOGIN) {
            LoginScreen(
                userViewModel = userViewModel,
                onRegisterClick = {  },
                onLoginSuccess = {
                    navController.navigate(Graph.USER) {
                        popUpTo(Graph.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        loginNavGraph(
            navController = navController,
            userViewModel = userViewModel)

        searchNavGraph()

        detailsNavGraph()

        pdfNavGraph(modifier = Modifier,navController = navController)

        detailsUINavGraph(navController = navController)

        newsletterNavGraph(modifier = Modifier)

       composable(Screen.MainTodoScreen.route) {
            ListScreen(
                todoListViewModel = hiltViewModel(),
                navController = navController
            )
        }

        composable("ui_ex_screen") {
            UIExampleScreen()
        }

        // Settings main screen
        composable(Screen.Settings.route) {
            SettingsMainScreen(
                navController = navController)
        }
        //  Settings subpages
        composable(Screen.ProfileSettings.route) {
            ProfileSettingsScreen(
                navController = navController,
                viewModel = ProfileSettingsViewModel(
                    api = ProfileApiImpl()
                ))
        }
        composable(Screen.NotificationSettings.route) {
            NotificationSettingsScreen(navController)
        }
        composable(Screen.AppearanceSettings.route) {
            InboxScreen()
        }
        composable(Screen.PrivacySecuritySettings.route) {
            PrivacySecuritySettingsScreen(navController)
        }
    }
}

    fun NavGraphBuilder.detailsNavGraph() {
        navigation(
            route = Graph.DETAILS,
            startDestination = Screen.Details.route
        ) {
            composable(
                route = Screen.Details.route,
                arguments = listOf(navArgument(PRODUCT_ARGUMENT_KEY) {
                    type = NavType.IntType
                })
            ) {
                DetailScreen()
            }
        }
    }

    fun NavGraphBuilder.searchNavGraph() {
        navigation(
            route = Graph.SEARCH,
            startDestination = Screen.Search.route
        ) {
            composable(route = Screen.Search.route) {
                SearchScreen()
            }
        }
    }

    // Call-to-action
   fun NavGraphBuilder.detailsUINavGraph(navController: NavController) {
        navigation(
            route = Graph.DETAILS_UI,
            startDestination = Screen.DetailsUI.route
        ) {
            composable(route = Screen.DetailsUI.route) {
                CallToActionScreen(
                    navController = navController,
                    modifier = Modifier,
                    productPreviewState = PreviewState(),
                    productItems = ItemData

                )
            }
        }
    }

    // Newsletter page
    fun NavGraphBuilder.newsletterNavGraph(modifier: Modifier) {
        navigation(
            route = Graph.NEWSLETTER,
            startDestination = "subscribe"
        ) {
            composable(route = "subscribe") {
                NewsletterSubscription(
                    viewModel = hiltViewModel(),
                    modifier = modifier
                )
            }
        }
    }

    fun NavGraphBuilder.loginNavGraph(
        navController: NavController,userViewModel: UserViewModel
    ) {
        navigation(
            route = Graph.LOGIN,
            startDestination = AuthScreen.Main.route
        ) {
            composable(route = AuthScreen.Main.route) {
                val currentUser by userViewModel.currentUser.collectAsState()
                AuthMainScreen(
                    userViewModel = userViewModel,
                    navController = navController
                )
            }
        }
    }































