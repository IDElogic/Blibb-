package se.android.blibb.presentation.screen.ui_examples.lightswitch.widgets

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path

@Composable
fun LightBeamCanvas(
    modifier: Modifier = Modifier,
    isVisible: Boolean = true,
    lightOpacity: Float = 0.6f,
    lightColor: Color = Color.White,
    topConeWidth : Float = 220f,
    bottomConeWidth : Float = 600f,
    coneHeight : Float = 500f
) {

    Canvas(
        modifier = modifier
    ) {
        if (isVisible) {
            val canvasWidth = size.width
            val centerX = canvasWidth / 2
            val topY = 0f
            val bottomY = coneHeight

            val path = Path().apply {
                moveTo(centerX - topConeWidth / 2, topY)
                lineTo(centerX + topConeWidth / 2, topY)
                lineTo(centerX + bottomConeWidth / 2, bottomY)
                lineTo(centerX - bottomConeWidth / 2, bottomY)
                close()
            }

            drawPath(
                path = path,
                brush = Brush.verticalGradient(
                    colors = listOf(
                        lightColor.copy(alpha = lightOpacity),
                        Color.Transparent
                    ),
                    startY = topY,
                    endY = bottomY
                )
            )
        }
    }
}