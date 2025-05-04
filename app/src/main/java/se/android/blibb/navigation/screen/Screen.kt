package se.android.blibb.navigation.screen


sealed class Screen(val route: String) {

    object Splash : Screen("splash_screen")

    object OnBoarding : Screen("on_boarding_screen")

    object Search : Screen("search_screen")

    object Pdf : Screen("pdf_screen")

    object DetailsUI : Screen("details_ui_screen")

    object Details : Screen("details_screen/{productId}") {
        fun passProductId(productId: Int): String = "details_screen/$productId"
    }

    object MainTodoScreen : Screen("customer_list_screen")

    object SummaryScreen : Screen("summary_screen")

    object Settings : Screen("settings") // Beállítások főképernyője
    object ProfileSettings : Screen("settings/profile")
    object NotificationSettings : Screen("settings/notifications")
    object AppearanceSettings : Screen("settings/appearance")
    object PrivacySecuritySettings : Screen("settings/privacy_security")
}