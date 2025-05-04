package se.android.blibb.presentation.common.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import se.android.blibb.domain.model.ProductItem
import se.android.blibb.presentation.common.card.ProductCard
import se.android.blibb.ui.theme.*

@Composable
fun ListContentProduct(
    modifier: Modifier = Modifier,
    title: String,
    products: List<ProductItem>,
    navController: NavController,
    onClickToCart: (ProductItem) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = DIMENS_20dp, end = DIMENS_16dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Category First",
                fontWeight = FontWeight.Medium,
                fontFamily = GilroyFontFamily,
                fontSize = 12.sp,
                color = MDark.copy(0.66f),
                textAlign = TextAlign.Start,
                lineHeight = TEXT_SIZE_16sp,
                letterSpacing = TEXT_SIZE_2sp
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                text = "all",
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = TEXT_SIZE_12sp,
                color = MDark.copy(0.66f)
            )
        }
        Spacer(modifier = Modifier.height(DIMENS_10dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(DIMENS_16dp),
            contentPadding = PaddingValues(DIMENS_2dp)
        ) {
            items(products) { product ->
                ProductCard(
                    productItem = product,
                    navController = navController,
                    onClickToCart = onClickToCart
                )
            }
        }
    }
}
