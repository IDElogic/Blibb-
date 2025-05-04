package se.android.blibb.presentation.common.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import se.android.blibb.R
import se.android.blibb.domain.model.ProductItem
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_4dp
import se.android.blibb.ui.theme.DIMENS_80dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.TEXT_SIZE_16sp
import se.android.blibb.ui.theme.wheat

@Composable
fun ListContentCart(
    modifier: Modifier = Modifier,
    cartProducts: List<ProductItem>,
    onClickDeleteCart: (ProductItem) -> Unit
) {
    if (cartProducts.isNotEmpty()) {
        LazyColumn(
            modifier = modifier.fillMaxWidth(),
            contentPadding = PaddingValues(top = DIMENS_32dp),
            verticalArrangement = Arrangement.spacedBy(DIMENS_8dp)
        ) {
            items(cartProducts) { items ->
                ContentCart(productItem = items,
                    onClickDeleteCart = { productItem ->
                        onClickDeleteCart.invoke(productItem)
                    }
                )
            }
        }
    } else {
        EmptyContent()
    }
}

@Composable
fun ContentCart(
    modifier: Modifier = Modifier,
    productItem: ProductItem,
    onClickDeleteCart: (ProductItem) -> Unit
) {
    Column {
        Divider(modifier = Modifier.height(DIMENS_1dp), color = MDark)

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = DIMENS_8dp)
        ) {
            Image(
                modifier = Modifier
                    .size(width = DIMENS_80dp, height = DIMENS_80dp)
                    .padding(start = DIMENS_8dp),
                painter = painterResource(id = productItem.image),
                contentDescription = stringResource(id = R.string.image_product)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .padding(start = DIMENS_16dp),
            ) {
                Text(
                    text = productItem.title,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = MDark,
                    fontSize = TEXT_SIZE_16sp
                )
                Spacer(modifier = Modifier.height(DIMENS_8dp))
                Text(
                    text = productItem.unit,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = wheat,
                    fontSize = TEXT_SIZE_12sp,
                )
            }
            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = "${productItem.price} $",
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Medium,
                color = wheat,
                fontSize = TEXT_SIZE_16sp,
            )
            Spacer(modifier = Modifier.width(DIMENS_4dp))

            Image(
                modifier = Modifier
                    .size(DIMENS_16dp)
                    .align(Alignment.CenterVertically)
                    .padding(start = DIMENS_8dp, end = DIMENS_8dp)
                    .clickable {
                        onClickDeleteCart.invoke(productItem)
                    },
                imageVector = Icons.Default.Delete,
                contentDescription = stringResource(R.string.image_delete),
                colorFilter = ColorFilter.tint(color = Ros.copy(0.66f))
            )

        }
    }
}