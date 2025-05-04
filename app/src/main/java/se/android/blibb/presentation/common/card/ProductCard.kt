package se.android.blibb.presentation.common.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import se.android.blibb.R
import se.android.blibb.domain.model.ProductItem
import se.android.blibb.navigation.screen.Screen
import se.android.blibb.ui.theme.*

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    productItem: ProductItem,
    navController: NavController,
    onClickToCart: (ProductItem) -> Unit
) {
    Column {
    Card(
        shape = RoundedCornerShape(topStart = DIMENS_180dp, topEnd = DIMENS_16dp),
        modifier = modifier
            .padding(vertical = DIMENS_1dp)
            .width(DIMENS_180dp)
            .height(DIMENS_64dp),
            backgroundColor = MDark
        ) {

        Button(
            modifier = Modifier
                .size(DIMENS_40dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MDark),
          //  shape = RoundedCornerShape(DIMENS_8dp),
            contentPadding = PaddingValues(DIMENS_4dp),
            onClick = {
                onClickToCart.invoke(productItem) })
        {
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
            Text(
                text = "add to cart",
                fontWeight = FontWeight.Normal,
                fontFamily = GilroyFontFamily,
                fontSize = 10.sp,
                color =wheat.copy(0.86f),
                textAlign = TextAlign.Start,
                lineHeight = TEXT_SIZE_12sp,
                letterSpacing = TEXT_SIZE_1sp
            )
                Spacer(modifier = Modifier.width(DIMENS_10dp))
            Icon(
                modifier = Modifier
                    .size(DIMENS_16dp),
                imageVector = Icons.Default.Add,
                tint = wheat,
                contentDescription = stringResource(id = R.string.add)
            )
            }
        }
    }
    Card(
        shape = RoundedCornerShape(bottomStart = DIMENS_8dp, bottomEnd = DIMENS_8dp),
        modifier = modifier
            .width(DIMENS_180dp)
            .clickable {
                navController.navigate(Screen.Details.passProductId(productId = productItem.id))
            },
        backgroundColor = MDark
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(modifier = Modifier)
            {
                val imageModifier = Modifier
                    .fillMaxWidth()
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(DIMENS_180dp)
                        .clip(RoundedCornerShape(bottomEnd =DIMENS_180dp, bottomStart = DIMENS_16dp )),
                    painter = painterResource(id = R.drawable.pic_2),
                    contentDescription = stringResource(R.string.image_on_boarding),
                    contentScale = ContentScale.Crop,
                    alpha = DefaultAlpha
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Blur)
                ) {
                    Spacer(modifier = Modifier.height(DIMENS_10dp))
                    Image(
                        painter = painterResource(id = productItem.image),
                        contentDescription = stringResource(R.string.image_product),
                        modifier = Modifier
                            .padding(DIMENS_10dp)
                            .align(Alignment.CenterHorizontally)
                            .width(DIMENS_180dp)
                    )

                    Spacer(modifier = Modifier.height(DIMENS_6dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(DIMENS_20dp),
                        horizontalAlignment = Alignment.End
                    )
                    {
                        Text(
                            text = productItem.title,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = GilroyFontFamily,
                            fontSize = 12.sp,
                            color =wheat,
                            textAlign = TextAlign.End,
                            lineHeight = TEXT_SIZE_2sp,
                            letterSpacing = TEXT_SIZE_1sp
                        )
                        Spacer(modifier = Modifier.height(DIMENS_6dp))
                        Text(
                            text = productItem.unit,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = GilroyFontFamily,
                            fontSize = 10.sp,
                            color = wheat,
                            textAlign = TextAlign.End,
                            lineHeight = TEXT_SIZE_12sp,
                            letterSpacing = TEXT_SIZE_1sp
                        )
                        Spacer(modifier = Modifier.height(DIMENS_10dp))
                        Row(modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = DIMENS_10dp)
                        ) {
                            Text(
                                text = "$ ${productItem.price}",
                                fontFamily = GilroyFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                color = wheat,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically),
                                fontSize = TEXT_SIZE_24sp
                            )
                            Spacer(modifier = Modifier.height(DIMENS_16dp))
                        }
                    }
                }
                }
            }
        }
    }}
