package se.android.blibb.presentation.screen.shop.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import se.android.blibb.navigation.screen.Screen
import se.android.blibb.presentation.common.content.ListContentCart
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_4dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.TEXT_SIZE_16sp
import se.android.blibb.ui.theme.TEXT_SIZE_18sp
import se.android.blibb.ui.theme.wheat
import se.android.blibb.ui.theme.zuzmo

@Composable
fun CartScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    cartViewModel: CartViewModel,
) {
    val productCartList by cartViewModel.productCartList.collectAsState()
    val totalPrice by cartViewModel.totalPrice.collectAsState()
    val discountedPrice by cartViewModel.discountedPrice.collectAsState()
    val checkoutState by cartViewModel.checkoutState.collectAsState()

    Scaffold { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Box(
                modifier = modifier,
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = modifier
                        .background(MSecond)
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = DIMENS_16dp),
                        text = "Titel",
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = TEXT_SIZE_18sp,
                        color = wheat
                    )

                    Spacer(modifier = Modifier.height(DIMENS_16dp))

                    ListContentCart(
                        cartProducts = productCartList,
                        onClickDeleteCart = { productItem ->
                            cartViewModel.removeFromCart(productItem)
                        }
                    )

                    Spacer(modifier = Modifier.height(DIMENS_16dp))
                    Text(
                        text = "Total: ${String.format("%.2f", totalPrice)} ",
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = TEXT_SIZE_16sp,
                        color = wheat,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Spacer(modifier = Modifier.height(DIMENS_8dp))
                    Text(
                        text = "DiscountedPrice: ${String.format("%.2f", discountedPrice)} ",
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = TEXT_SIZE_16sp,
                        color = wheat.copy(0.66f),
                        modifier = Modifier.align(Alignment.End)
                    )

                    Spacer(modifier = Modifier.height(DIMENS_16dp))

                    Button(
                        colors = ButtonDefaults.buttonColors(Ros.copy(0.66f)),
                        onClick = {
                            cartViewModel.createOrder()
                            navController.navigate(route = Screen.SummaryScreen.route)
                        },
                        modifier = Modifier
                            .padding(DIMENS_4dp)
                            .align(Alignment.End)
                    ) {
                        Text(
                            text = "check",
                            fontFamily = GilroyFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = TEXT_SIZE_12sp,
                            color = wheat
                        )
                        Spacer(modifier = Modifier.width(DIMENS_8dp))
                        Icon(
                            modifier = Modifier
                                .size(DIMENS_16dp),
                            imageVector = Icons.Default.ArrowDropDown,
                            tint = wheat,
                            contentDescription = "control"
                        )
                    }

                    when (checkoutState) {
                        is CheckoutState.Processing -> CircularProgressIndicator()
                        is CheckoutState.Success -> Text("Done!", color = zuzmo)
                        is CheckoutState.Error -> Text("Error", color = Ros)
                        else -> {}
                    }
                }
            }
        }
    }
}