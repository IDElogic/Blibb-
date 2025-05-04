package se.android.blibb.presentation.screen.shop.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import se.android.blibb.R
import se.android.blibb.domain.model.ProductItem
import se.android.blibb.presentation.common.SpacerDividerContent
import se.android.blibb.presentation.component.NeuButton
import se.android.blibb.presentation.component.RatingBar
import se.android.blibb.ui.theme.*
import se.android.blibb.utils.showToastShort


@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    detailViewModel: DetailViewModel = hiltViewModel(),
) {
    val mContext = LocalContext.current
    val selectedProduct by detailViewModel.selectedProduct.collectAsState()

    Scaffold { padding ->
        Column {
            Column(
                modifier = modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f)
                    .padding(padding)
                    .background(Black)
            ) {
                selectedProduct?.let { productItem ->
                    Spacer(modifier = Modifier.height(DIMENS_24dp))

                    DetailContentImageHeader(productItem = productItem)

                    Spacer(modifier = Modifier.height(DIMENS_24dp))

                    DetailContentDescription(productItem = productItem)
                }
            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Black)
                    .padding(20.dp)
            ){
                selectedProduct?.let {
                    DetailButtonAddCart(
                        productItem = it,
                        onClickToCart = { productItem ->
                            mContext.showToastShort("Success Add To Cart ${productItem.title}")
                            detailViewModel.addCart(productItem.copy(isCart = true))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun DetailContentImageHeader(
    productItem: ProductItem
) {
    Card(
        shape = RoundedCornerShape(DIMENS_20dp),
        colors = CardDefaults.cardColors(Blur),
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .height(DIMENS_353dp),
    ) {
        Image(
            painter = painterResource(id = productItem.image),
            contentDescription = stringResource(id = R.string.image_product),
            modifier = Modifier
                .fillMaxSize()
                .padding(DIMENS_24dp)
        )
    }
}

@Composable
fun DetailContentDescription(
    modifier: Modifier = Modifier,
    productItem: ProductItem
) {
    Column(
        modifier = modifier
            .padding(DIMENS_20dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = productItem.title,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = MDark,
                    fontSize = TEXT_SIZE_24sp
                )
                Spacer(modifier = Modifier.height(DIMENS_6dp))
                Text(
                    text = productItem.unit,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = MDark,
                    fontSize = TEXT_SIZE_12sp,
                )
            }
        }
        Spacer(modifier = Modifier.height(DIMENS_8dp))
        SpacerDividerContent()
        Text(
            text = "description",
            fontFamily = GilroyFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = MDark,
            fontSize = TEXT_SIZE_16sp,)
        Spacer(modifier = Modifier.height(DIMENS_8dp))
        Text(
            text = productItem.description,
            fontFamily = GilroyFontFamily,
            fontWeight = FontWeight.Medium,
            color = MDark,
            fontSize = TEXT_SIZE_12sp,)
        Spacer(modifier = Modifier.height(DIMENS_16dp))
        SpacerDividerContent()
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "description",
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Medium,
                color = MDark,
                fontSize = TEXT_SIZE_16sp,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )

            Card(
                shape = RoundedCornerShape(DIMENS_6dp),
                modifier = Modifier
                    .background(zuzmo)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = productItem.nutritions,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = MDark,
                    fontSize = TEXT_SIZE_10sp,
                    modifier = Modifier
                        .background(color = MSecond)
                        .padding(DIMENS_4dp)
                )
            }

            Spacer(modifier = Modifier.width(DIMENS_8dp))

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.arrow_right),
                tint = MDark.copy(0.66f)
            )
        }
        SpacerDividerContent()
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.review),
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Medium,
                color = MDark,
                fontSize = TEXT_SIZE_16sp,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
            RatingBar(rating = productItem.review)
            Spacer(modifier = Modifier.width(DIMENS_8dp))
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.arrow_right),
                tint = MDark.copy(0.66f)
            )
        }
    }
}

@Composable
fun DetailButtonAddCart(
    modifier: Modifier = Modifier,
    productItem: ProductItem,
    onClickToCart: (ProductItem) -> Unit
) {
    NeuButton(
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 40.dp)
            .clickable(
                enabled = true,
                onClick = { onClickToCart.invoke(productItem) }
            ),
        lightColor = MDark,
        onClick = { onClickToCart.invoke(productItem) }
    )
    {
        Text(
            text = stringResource(R.string.add_to_cart),
            fontFamily = GilroyFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = TEXT_SIZE_12sp,
            color = Color.White,
            modifier = Modifier.padding(top = DIMENS_8dp, bottom = DIMENS_8dp)
        )
    }
}











