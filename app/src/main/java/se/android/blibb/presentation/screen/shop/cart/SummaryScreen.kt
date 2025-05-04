package se.android.blibb.presentation.screen.shop.cart

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import se.android.blibb.domain.model.ProductItem
import se.android.blibb.ui.theme.DIMENS_14dp
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_4dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.wheat

@Composable
fun SummaryScreen(
    viewModel: CartViewModel,
    modifier: Modifier = Modifier
) {
    val productCartList by viewModel.productCartList.collectAsState()
    val totalPrice by viewModel.totalPrice.collectAsState()
    val discountedPrice by viewModel.discountedPrice.collectAsState()

    val orderNumber by viewModel.orderNumber.collectAsState()
    val orderDate by viewModel.orderDate.collectAsState()

    val context = LocalContext.current

    Scaffold { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(DIMENS_20dp)
                .border(DIMENS_1dp, MDark.copy(0.2f))
                .background(wheat)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Order list",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally))
            Text(
                text = "Order #: $orderNumber",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 16.dp))
            Text(
                text = "Date: $orderDate",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(productCartList) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(wheat)
                            .padding(vertical = 8.dp, horizontal = DIMENS_14dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.Top
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .padding(horizontal = DIMENS_4dp)

                        ) {
                            Text(text = item.title)
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = DIMENS_4dp)
                        ) {
                            Text(
                                text = "${item.price} $")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Total: ${String.format("%.2f", totalPrice)} $",
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = TEXT_SIZE_12sp,
                color = MDark,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(16.dp))
           Text(
                text = "Reward: ${String.format("%.2f", discountedPrice)} $",
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = TEXT_SIZE_12sp,
                color = MDark.copy(0.66f),
                modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(16.dp))
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(DIMENS_20dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(Ros),
                onClick = {
                    shareOrderList(
                        context,
                        productCartList,
                        totalPrice,
                        discountedPrice,
                        orderDate
                    )
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Icon(
                    modifier = Modifier.size(DIMENS_16dp),
                    imageVector = Icons.Default.Share,
                    tint = wheat,
                    contentDescription = "share"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Share",
                    color = wheat)
            }
        }
    }
}

fun shareOrderList(
    context: Context,
    productList: List<ProductItem>,
    totalPrice: Double,
    discountedPrice: Double,
    orderDate: String
) {
    val shareText = buildString {
        appendLine("Order List")
        appendLine("Order Date: $orderDate")
        appendLine()
        productList.forEach { item ->
            appendLine("${item.title}: ${item.price} $")
        }
        appendLine()
        appendLine("Total: ${String.format("%.2f", totalPrice)} $")
        appendLine("DiscountedPrice: ${String.format("%.2f", discountedPrice)} $")
    }
}