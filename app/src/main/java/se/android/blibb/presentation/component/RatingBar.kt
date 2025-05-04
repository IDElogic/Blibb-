package se.android.blibb.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import se.android.blibb.R
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.zuzmo
import kotlin.math.ceil
import kotlin.math.floor

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    starsColor: Color = MSecond
) {

    val filledStars = floor(rating).toInt()
    val unfilledStars = (stars - ceil(rating).toInt())
    val halfStart = !(rating.rem(1).equals(0.0))

    Row(
        modifier = modifier
    ) {
        repeat(filledStars) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = null,
                tint = zuzmo
            )
        }

        if (halfStart) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star_half),
                contentDescription = null,
                tint = zuzmo.copy(0.66f)
            )
        }

        repeat(unfilledStars) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star_outline),
                contentDescription = null,
                tint = zuzmo.copy(0.46f)
            )
        }

    }

}
