package se.android.blibb.presentation.screen.shop

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import se.android.blibb.R
import se.android.blibb.domain.model.ProductItem
import se.android.blibb.navigation.screen.BottomNavItemScreen
import se.android.blibb.navigation.screen.Screen
import se.android.blibb.presentation.common.content.ListContentProduct
import se.android.blibb.ui.theme.Black
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_14dp
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_68dp
import se.android.blibb.ui.theme.DIMENS_80dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_24sp
import se.android.blibb.ui.theme.TEXT_SIZE_2sp
import se.android.blibb.ui.theme.wheat
import se.android.blibb.ui.theme.zuzmo
import se.android.blibb.utils.showToastShort

@ExperimentalPagerApi
@Composable
fun ShopHomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    shopHomeViewModel: ShopHomeViewModel = hiltViewModel()
) {
    val mContext = LocalContext.current
    val allProducts by shopHomeViewModel.productList.collectAsState()

    Scaffold { padding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
                .background(Black)
        ) {
            Header(navController = navController)
            Spacer(modifier = Modifier.height(DIMENS_20dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = DIMENS_20dp)
                    .height(DIMENS_68dp)
                    .clip(RoundedCornerShape(DIMENS_16dp)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically)
            {
                Icon(
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .clickable {}
                        .padding(DIMENS_20dp),
                    imageVector = Icons.Default.Menu,
                    tint = MDark.copy(0.66f),
                    contentDescription = stringResource(id = R.string.add))

                Spacer(
                    modifier = Modifier
                        .width(DIMENS_10dp))
                Card(
                    modifier = Modifier
                        .width(DIMENS_68dp)
                        .height(DIMENS_68dp),
                    colors = CardDefaults.cardColors(MDark)

                ) {
                    Icon(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                navController.navigate(BottomNavItemScreen.Start.route)
                            }
                            .padding(DIMENS_20dp),
                        imageVector = Icons.Default.Refresh,
                        tint = wheat,
                        contentDescription = stringResource(id = R.string.add))
                }
                Spacer(
                    modifier = Modifier
                        .width(DIMENS_10dp))
                Card(
                    modifier = Modifier
                        .width(DIMENS_68dp)
                        .height(DIMENS_68dp),
                    colors = CardDefaults.cardColors(MSecond)
                ) {
                    Icon(
                        modifier = Modifier
                            .height(DIMENS_80dp)
                            .clickable {
                                navController.navigate(Screen.Search.route)
                            }
                            .width(DIMENS_80dp)
                            .padding(DIMENS_20dp),
                        imageVector = Icons.Default.Search,
                        tint = wheat,
                        contentDescription = stringResource(id = R.string.add))
                }

                Spacer(
                    modifier = Modifier
                        .width(DIMENS_10dp))
                Card(
                    modifier = Modifier
                        .width(DIMENS_68dp)
                        .height(DIMENS_68dp),
                    colors = CardDefaults.cardColors(zuzmo)
                ) {
                    Icon(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {}
                            .padding(DIMENS_20dp),
                        imageVector = Icons.Default.FavoriteBorder,
                        tint = wheat,
                        contentDescription = stringResource(id = R.string.add))
                }
            }
            Spacer(modifier = Modifier.height(DIMENS_20dp))
                        ListContentProduct(
                        title = stringResource(id = R.string.exclusive_offer),
                    products = allProducts,
                    navController = navController,
                    onClickToCart = { productItem ->
                        clickToCart(mContext, productItem, shopHomeViewModel)
                    }
                )
            Spacer(modifier = Modifier.height(DIMENS_20dp))
                        ListContentProduct(
                        title = stringResource(id = R.string.exclusive_offer),
                products = allProducts,
                navController = navController,
                onClickToCart = { productItem ->
                    clickToCart(mContext, productItem, shopHomeViewModel)
                }
            )
            Spacer(modifier = Modifier.height(DIMENS_20dp))
        }
    }
}

@Composable
private fun Header(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Black))
    {
        Row(
            modifier = Modifier
                .padding(top = 32.dp, start = 32.dp, end = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .width(DIMENS_68dp)
                    .height(DIMENS_68dp),
                painter = painterResource(id = R.drawable.bicycle_02),
                contentDescription = stringResource(R.string.image_on_boarding),
                contentScale = ContentScale.Crop,
                alpha = DefaultAlpha
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                text = "BikeShop",
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = TEXT_SIZE_24sp,
                letterSpacing = TEXT_SIZE_2sp,
                color = wheat.copy(0.66f))
            Button(
                modifier = Modifier
                    .size(DIMENS_68dp)
                    .border(DIMENS_1dp, MDark, RoundedCornerShape(DIMENS_16dp)),
                colors = ButtonDefaults.buttonColors(Black),
                shape = RoundedCornerShape(DIMENS_16dp),
                contentPadding = PaddingValues(DIMENS_10dp),
                onClick = {
                    navController.navigate(BottomNavItemScreen.Cart.route)
                   // navController.navigate("cart?totalPrice={totalPrice}")
                })
            {
                Icon(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(DIMENS_14dp),
                    imageVector = Icons.Default.ShoppingCart,
                    tint = Ros,
                    contentDescription = stringResource(id = R.string.add)
                )
            }
        }
        Spacer(modifier = Modifier.height(DIMENS_8dp))
    }
}

fun clickToCart(context: Context, productItem: ProductItem, viewModel: ShopHomeViewModel) {
    context.showToastShort("Success Add To Cart ${productItem.title}")
    viewModel.addCart(productItem.copy(isCart = true))
}

