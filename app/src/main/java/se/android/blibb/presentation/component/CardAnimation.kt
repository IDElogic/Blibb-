package se.android.blibb.presentation.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import se.android.blibb.R
import se.android.blibb.ui.theme.Blur2
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat
import kotlin.math.roundToInt

@Composable
fun CardAnimation()
{
    Box(Modifier.fillMaxSize()) {
        var isExpanded by remember { mutableStateOf(false) }
        val transition = updateTransition(targetState = isExpanded, label = "Stack Expand")
        val scope = rememberCoroutineScope()
        val offset = remember { Animatable(Offset(0f, 0f), Offset.VectorConverter) }

        val blurRadius by transition.animateDp(label = "Title blur") { expanded ->
            if (expanded) 8.dp else 0.dp
        }
        Text(
            text = "Card Animation",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 24.dp)
                .align(Alignment.TopStart)
                .blur(blurRadius, BlurredEdgeTreatment.Unbounded)
        )
        val dragOffsetBottom = animateOffsetAsState(
            targetValue = offset.targetValue,
            spring(
                visibilityThreshold = Offset.VisibilityThreshold,
                stiffness = Spring.StiffnessMediumLow
            )
        )
        BottomCard(
            transition = transition,
            modifier = Modifier
                .offset {
                    IntOffset(
                        dragOffsetBottom.value.x.roundToInt(),
                        dragOffsetBottom.value.y.roundToInt()
                    )
                }
                .align(Alignment.Center)
        )

        val dragOffsetMiddle = animateOffsetAsState(targetValue = offset.targetValue)

        MiddleCard(
            transition = transition,
            modifier = Modifier
                .offset {
                    IntOffset(
                        dragOffsetMiddle.value.x.roundToInt(),
                        dragOffsetMiddle.value.y.roundToInt()
                    )
                }
                .align(Alignment.Center)
        )

        val rotationXTop by transition.animateFloat(label = "RotationX top") { expanded ->
            if (expanded) 3f else 0f
        }

        TopCard(Modifier
            .offset { IntOffset(offset.value.x.roundToInt(), offset.value.y.roundToInt()) }
            .align(Alignment.Center)
            .graphicsLayer(
                rotationX = rotationXTop,
                transformOrigin = TransformOriginTopCenter
            )
            .pointerInput(Unit) {
                scope.launch {
                    detectTapGestures {
                        isExpanded = !isExpanded
                    }
                }
                scope.launch {
                    detectDragGestures(
                        onDragStart = {
                            isExpanded = true
                        },
                        onDragEnd = {
                            scope.launch {
                                offset.animateTo(Offset.Zero, tween())
                            }
                            isExpanded = false
                        },
                        onDrag = { _, dragAmount ->
                            val original = offset.value
                            val summed = original + dragAmount
                            scope.launch {
                                offset.snapTo(summed)
                            }
                        }
                    )
                }
            })
    }
}

@Composable
fun BottomCard(transition: Transition<Boolean>, modifier: Modifier = Modifier) {
    val rotation by transition.animateFloat(label = "Rotation bottom") { expanded ->
        if (expanded) 0f else 10f
    }
    val rotationX by transition.animateFloat(label = "RotationX bottom") { expanded ->
        if (expanded) 10f else 0f
    }
    val expandOffset by transition.animateDp(label = "Offset bottom") { expanded ->
        if (expanded) (-200).dp else (-40).dp
    }
    val scale by transition.animateFloat(label = "Scale bottom") { expanded ->
        if (expanded) 0.8f else 0.9f
    }

    Box(
        modifier = modifier
            .offset(y = expandOffset)
            .graphicsLayer(
                rotationX = rotationX,
                transformOrigin = TransformOriginTopCenter
            )
            .graphicsLayer(rotationZ = rotation, scaleX = scale, scaleY = scale)
            .requiredSize(340.dp, 220.dp)
            .background(Ros.copy(alpha = 0.8f), RoundedCornerShape(24.dp))
    )
}

@Composable
fun MiddleCard(transition: Transition<Boolean>, modifier: Modifier = Modifier) {
    val rotation by transition.animateFloat(label = "Rotation middle") { expanded ->
        if (expanded) 0f else 5f
    }
    val rotationX by transition.animateFloat(label = "RotationX middle") { expanded ->
        if (expanded) 5f else 0f
    }
    val expandOffset by transition.animateDp(label = "Offset middle") { expanded ->
        if (expanded) (-100).dp else (-20).dp
    }
    val scale by transition.animateFloat(label = "Scale middle") { expanded ->
        if (expanded) 0.9f else 0.95f
    }

    Box(
        modifier = modifier
            .offset(y = expandOffset)
            .graphicsLayer(
                rotationX = rotationX,
                transformOrigin = TransformOriginTopCenter
            )
            .graphicsLayer(rotationZ = rotation, scaleX = scale, scaleY = scale)
            .requiredSize(340.dp, 220.dp))
    {
        val imageModifier = Modifier
            .fillMaxSize()
            .shadow(elevation = DIMENS_32dp)
            .blur(0.dp)
        Image(
            modifier = Modifier
                .fillMaxSize()
                .shadow(elevation = DIMENS_32dp)
                .align(Alignment.Center)
                .clip(
                    RoundedCornerShape(24.dp)),
            painter = painterResource(id = R.drawable.rea),
            contentDescription = stringResource(R.string.image_on_boarding),
            contentScale = ContentScale.Crop,
            alpha = DefaultAlpha
        )
    }
}

@Composable
fun TopCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredSize(340.dp, 220.dp)
            .shadow(DIMENS_20dp, RoundedCornerShape(24.dp))
            .background(Blur2, RoundedCornerShape(24.dp))
    ) {
        CardContent()
    }
}

@Composable
fun CardContent() {
    Row(Modifier.padding(16.dp)) {
        Column {
            Text(
                text = "Card Animation",
                color = wheat,
                fontFamily = GilroyFontFamily,
                fontSize = TEXT_SIZE_12sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = TEXT_SIZE_1sp
            )
            Text(
                text = "click here",
                color = wheat.copy(0.86f),
                fontFamily = GilroyFontFamily,
                fontSize = TEXT_SIZE_12sp,
                fontWeight = FontWeight.Normal,
                letterSpacing = TEXT_SIZE_1sp
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f)
        )
        Icon(
            imageVector = Icons.Rounded.Refresh,
            contentDescription = "",
            tint = wheat,
            modifier = Modifier
                .requiredSize(DIMENS_20dp)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = "drag and drop",
            color = wheat.copy(0.86f),
            fontFamily = GilroyFontFamily,
            fontSize = TEXT_SIZE_12sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = TEXT_SIZE_1sp
        )
    }
}

val TransformOriginTopCenter: TransformOrigin = TransformOrigin(0.5f, 0f)

