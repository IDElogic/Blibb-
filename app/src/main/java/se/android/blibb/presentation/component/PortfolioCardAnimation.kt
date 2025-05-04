package se.android.blibb.presentation.component

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.launch
import se.android.blibb.R
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_140dp
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_2dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_48dp
import se.android.blibb.ui.theme.DIMENS_90dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat
import kotlin.math.roundToInt

@Composable
fun PortfolioCardAnimation(navController: NavController)
{
    Box(Modifier
        .fillMaxSize())
    {
        var imageUri by remember { mutableStateOf<Uri?>(null) }
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri: Uri? ->
            imageUri = uri
        }

        var isExpanded by remember { mutableStateOf(false) }
        val transition = updateTransition(targetState = isExpanded, label = "Stack Expand")
        val scope = rememberCoroutineScope()
        val offset = remember { Animatable(Offset(0f, 0f), Offset.VectorConverter) }

        val blurRadius by transition.animateDp(label = "Title blur") { expanded ->
            if (expanded) 8.dp else 0.dp
        }
        Spacer(modifier = Modifier.height(DIMENS_32dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = DIMENS_20dp )
        ) {
        Text(
            text = "Jetpack Compose Developer",
            color = wheat.copy(0.66f),
            fontFamily = GilroyFontFamily,
            fontSize = 48.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = TEXT_SIZE_1sp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = DIMENS_32dp, bottom = DIMENS_10dp)
                .blur(blurRadius, BlurredEdgeTreatment.Unbounded)
        )
        Text(
            text = "Ildiko Cs. Fabian",
            color = Ros,
            fontFamily = GilroyFontFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = TEXT_SIZE_1sp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .blur(blurRadius, BlurredEdgeTreatment.Unbounded)
        )
    }
        val dragOffsetBottom = animateOffsetAsState(
            targetValue = offset.targetValue,
            spring(
                visibilityThreshold = Offset.VisibilityThreshold,
                stiffness = Spring.StiffnessMediumLow
            )
        )
        PortfolioBottomCard(
            transition = transition,
            modifier = Modifier
                .offset {
                    IntOffset(
                        dragOffsetBottom.value.x.roundToInt(),
                        dragOffsetBottom.value.y.roundToInt()
                    )
                }
                .align(Alignment.BottomCenter)
        )

        val dragOffsetMiddle = animateOffsetAsState(targetValue = offset.targetValue)

        PortfolioMiddleCard(
            transition = transition,
            modifier = Modifier
                .offset {
                    IntOffset(
                        dragOffsetMiddle.value.x.roundToInt(),
                        dragOffsetMiddle.value.y.roundToInt()
                    )
                }
                .align(Alignment.BottomCenter)
        )

        val rotationXTop by transition.animateFloat(label = "RotationX top") { expanded ->
            if (expanded) 3f else 0f
        }

        PortfolioTopCard( navController = navController,
            modifier = Modifier
            .offset { IntOffset(offset.value.x.roundToInt(), offset.value.y.roundToInt()) }
            .align(Alignment.BottomCenter)
            .graphicsLayer(
                rotationX = rotationXTop,
                transformOrigin = PortfolioTransformOriginTopCenter
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
fun PortfolioBottomCard(transition: Transition<Boolean>, modifier: Modifier = Modifier) {
    val rotation by transition.animateFloat(label = "Rotation bottom") { expanded ->
        if (expanded) 0f else 10f
    }
    val rotationX by transition.animateFloat(label = "RotationX bottom") { expanded ->
        if (expanded) 10f else 0f
    }
    val expandOffset by transition.animateDp(label = "Offset bottom") { expanded ->
        if (expanded) (-230).dp else (-40).dp
    }
    val scale by transition.animateFloat(label = "Scale bottom") { expanded ->
        if (expanded) 0.8f else 0.9f
    }

    Box(
        modifier = modifier
            .offset(y = expandOffset)
            .graphicsLayer(
                rotationX = rotationX,
                transformOrigin = PortfolioTransformOriginTopCenter
            )
            .graphicsLayer(rotationZ = rotation, scaleX = scale, scaleY = scale)
            .requiredSize(340.dp, 220.dp)
            .background(Ros.copy(alpha = 0.8f), RoundedCornerShape(24.dp))
    )
    {
       // LocationIcon()

    }
}

@Composable
fun PortfolioMiddleCard(transition: Transition<Boolean>, modifier: Modifier = Modifier) {
    val rotation by transition.animateFloat(label = "Rotation middle") { expanded ->
        if (expanded) 0f else 5f
    }
    val rotationX by transition.animateFloat(label = "RotationX middle") { expanded ->
        if (expanded) 5f else 0f
    }
    val expandOffset by transition.animateDp(label = "Offset middle") { expanded ->
        if (expanded) (-160).dp else (-20).dp
    }
    val scale by transition.animateFloat(label = "Scale middle") { expanded ->
        if (expanded) 0.9f else 0.95f
    }

    Box(
        modifier = modifier
            .offset(y = expandOffset)
            .graphicsLayer(
                rotationX = rotationX,
                transformOrigin = PortfolioTransformOriginTopCenter
            )
            .graphicsLayer(rotationZ = rotation, scaleX = scale, scaleY = scale)
            .requiredSize(340.dp, 220.dp)
            .background(wheat.copy(alpha = 0.8f), RoundedCornerShape(24.dp))
    )
    {
        GitHubProfileIcon(username = String())

    }
}

@Composable
fun PortfolioTopCard(modifier: Modifier = Modifier, navController: NavController) {
    Box(
        modifier = modifier
            .requiredSize(340.dp, 220.dp)
            .shadow(DIMENS_20dp, RoundedCornerShape(24.dp))
            .background(MSecond, RoundedCornerShape(24.dp))
    ) {
        PortfolioCardContent(navController = navController)
    }
}

@Composable
fun PortfolioCardContent(
    navController: NavController
) {
    Column {
    Row(
        modifier = Modifier
            .padding(16.dp))
    {
        Column {
            Text(
                text = "double click / drag and drop",
                color = wheat.copy(0.26f),
                fontFamily = GilroyFontFamily,
                fontSize = TEXT_SIZE_12sp,
                fontWeight = FontWeight.Normal,
                letterSpacing = TEXT_SIZE_1sp
            )
            Icon(
                imageVector = Icons.Rounded.ArrowDropDown,
                contentDescription = "",
                tint = wheat,
                modifier = Modifier
                    .requiredSize(DIMENS_20dp)
                    .align(Alignment.CenterHorizontally))
        }
        Spacer(modifier = Modifier.weight(0.1f))

        Column {
            NeuButton(
                shape = RoundedCornerShape(DIMENS_90dp),
                modifier = Modifier
                    .width(64.dp)
                    .height(64.dp)
                    .padding(start = DIMENS_2dp)
                    .border(1.dp, Ros, RoundedCornerShape(DIMENS_90dp)),
                lightColor = Ros.copy(alpha = 0.9f),
                        onClick = {
                    navController.navigate("profile_screen")
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_attach_file_24),
                    contentDescription = "attached-file",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(DIMENS_20dp),)

            }
        }
    }
    Row(
        modifier =Modifier
            .padding(16.dp))
    {
        Column(
            modifier =Modifier
                .fillMaxWidth())
        {
            Row {
                NeuButton(
                    shape = RoundedCornerShape(DIMENS_16dp),
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp)
                        .padding(start = DIMENS_2dp)
                        .border(1.dp, MDark, RoundedCornerShape(DIMENS_16dp))
                        .clickable(
                            enabled = true,
                            onClick = {}
                        ),
                    lightColor = MDark,
                    onClick = {}
                ) {
                    PhoneCallIcon("+36123456789")
                   }
                Spacer(modifier = Modifier.weight(0.1f))
                NeuButton(
                    shape = RoundedCornerShape(DIMENS_16dp),
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp)
                        .padding(start = DIMENS_2dp)
                        .border(1.dp, MDark, RoundedCornerShape(DIMENS_16dp))
                        .clickable(
                            enabled = true,
                            onClick = {}
                        ),
                    lightColor = MDark,
                    onClick = {}
                ) {
                    EmailIcon("pelda@email.com")
                }
                Spacer(modifier = Modifier.weight(0.1f))
                NeuButton(
                    shape = RoundedCornerShape(DIMENS_90dp),
                    modifier = Modifier
                        .width(65.dp)
                        .height(65.dp)
                        .padding(start = DIMENS_2dp)
                        .clickable(
                            enabled = true,
                            onClick = {}
                        ),
                    lightColor = MSecond,
                    onClick = {}
                ) {
                    WebLinkIcon()
                }


                Spacer(modifier = Modifier.weight(0.1f))
                NeuButton(
                    shape = RoundedCornerShape(DIMENS_16dp),
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp)
                        .padding(start = DIMENS_2dp)
                        .border(1.dp, MDark, RoundedCornerShape(DIMENS_16dp))
                        .clickable(
                            enabled = true,
                            onClick = {}
                        ),
                    lightColor = MDark,
                    onClick = {}
                ) {
                    SocialMediaIcon()
                }
            }
        }
    }
}}


val PortfolioTransformOriginTopCenter: TransformOrigin = TransformOrigin(0.5f, 0f)

@Composable
fun WebLinkIcon() {
    val uriHandler = LocalUriHandler.current
    IconButton(
        modifier = Modifier
            .width(65.dp)
            .height(65.dp)
            .clip(RoundedCornerShape(DIMENS_90dp))
            .padding(start = DIMENS_2dp),
        onClick = {
        uriHandler.openUri("https://iwoio.com")
    }) {
        Image(
            painter = painterResource(id = R.drawable.iwoio),
            contentDescription = "attached-file",
            contentScale = ContentScale.Crop,)
    }
}

@Composable
fun SocialMediaIcon() {
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current

    IconButton(onClick = {
        val appUri = "instagram://user?username=iwoio_digital"
        val webUri = "https://instagram.com/iwoio_digital"

        Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(appUri)
            if (resolveActivity(context.packageManager) != null) {
                context.startActivity(this)
            } else {
                uriHandler.openUri(webUri)
            }
        }
    }) {
        Image(
            painter = painterResource(id = R.drawable.insta),
            contentDescription = "attached-file",
            contentScale = ContentScale.Crop,)
    }
}

@Composable
fun EmailIcon(email: String) {
    val context = LocalContext.current
    IconButton(onClick = {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$email")
        }
        context.startActivity(Intent.createChooser(intent, "Choose"))
    }) {
        Icon(Icons.Default.Email, "Email", tint = MSecond.copy(0.66f))
    }
}

@Composable
fun PhoneCallIcon(phoneNumber: String) {
    val context = LocalContext.current
    IconButton(onClick = {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        context.startActivity(intent)
    }) {
        Icon(Icons.Default.Phone, "Phone call", tint = MSecond.copy(0.66f))
    }
}

@Composable
fun GitHubProfileIcon(username: String)
{
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
        .padding(top = DIMENS_48dp, start = DIMENS_140dp))
    {
    IconButton(
        onClick = {
            val appUri = "github://user?username=IDElogic"
            val webUri = "https://github.com/IDElogic"

            try {
                Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(appUri)
                    context.startActivity(this)
                }
            } catch (e: ActivityNotFoundException) {
                uriHandler.openUri(webUri)
            }
        })
    {
        Image(
            modifier = Modifier
                .width(68.dp)
                .height(68.dp)
                .shadow(elevation = DIMENS_32dp)
                .clickable(
                    enabled = true,
                    onClick = {
                    })
                .clip(
                    RoundedCornerShape(90.dp)
                ),
            colorFilter = ColorFilter.tint(MDark),
            painter = painterResource(id = R.drawable.ic_github),
            contentDescription = "GitHub",
            contentScale = ContentScale.Crop,
            alpha = DefaultAlpha
        )
    }
}
}

@Composable
fun LocationMap(lat: Double, lon: Double) {
    val cameraPosition = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(lat, lon), 15f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPosition
    ) {
        Marker(
            state = MarkerState(position = LatLng(lat, lon)),
            title = "current position "
        )
    }
}

@Composable
fun LocationIcon() {
    val context = LocalContext.current
    var showMap by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(top = DIMENS_32dp, start = DIMENS_140dp))
    {
    IconButton(
        onClick = {
            /* if (hasLocationPermission(context)) {
                showMap = true
            } else {
                requestLocationPermission(context)
            }*/
            showMap = true
        }
    ) {
        Icon(modifier = Modifier
            .size(DIMENS_32dp)
            .clickable{},
            imageVector = Icons.Default.LocationOn,
            contentDescription = "location",
            tint = wheat
        )
    }
    }
    if (showMap) {
        LocationMap(lat = 47.4979, lon = 19.0402)
    }
}

