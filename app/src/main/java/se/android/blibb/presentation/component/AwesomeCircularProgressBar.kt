package se.android.blibb.presentation.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp

@Composable
fun AwesomeCircularProgressBar(
    progress: Float,
    size: Dp,
    strokeWidth: Dp,
    colors: List<Color>,
    glowColor: Color,
    animationDuration: Int
) {
    val animatedProgress = remember { Animatable(0f) }

    LaunchedEffect(progress) {
        animatedProgress.animateTo(
            targetValue = progress,
            animationSpec = tween(durationMillis = animationDuration))
    }
    Canvas(modifier = Modifier.size(size)) {
        val sweepAngle = animatedProgress.value * 360
        drawArc(
            brush = Brush.sweepGradient(colors),
            startAngle = -90f,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round))
        drawArc(
            color = glowColor,
            startAngle = sweepAngle - 90f,
            sweepAngle = 10f,
            useCenter = false,
            style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round),
            alpha = 0.5f
        )
    }
}