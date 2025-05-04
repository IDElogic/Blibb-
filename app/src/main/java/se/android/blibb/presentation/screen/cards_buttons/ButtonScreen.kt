package se.android.blibb.presentation.screen.cards_buttons

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import se.android.blibb.R
import se.android.blibb.ui.theme.Black
import se.android.blibb.ui.theme.Blur2
import se.android.blibb.ui.theme.DIMENS_108dp
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_12dp
import se.android.blibb.ui.theme.DIMENS_130dp
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_24dp
import se.android.blibb.ui.theme.DIMENS_48dp
import se.android.blibb.ui.theme.DIMENS_4dp
import se.android.blibb.ui.theme.DIMENS_64dp
import se.android.blibb.ui.theme.DIMENS_68dp
import se.android.blibb.ui.theme.DIMENS_80dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_18sp
import se.android.blibb.ui.theme.wheat
import se.android.blibb.ui.theme.zuzmo

@Composable
fun ButtonScreen() {
   MainRow(
        header = {
            HeaderRow()
        },
        selection = {
            SelectionRow()
        },
        status = {
            SectionRow()
        },
    )
}

@Composable
private fun MainRow(
    modifier: Modifier = Modifier,
    header: (@Composable () -> Unit)? = null,
    charge: (@Composable () -> Unit)? = null,
    selection: (@Composable () -> Unit)? = null,
    status: (@Composable () -> Unit)? = null,
) {
        Box(
            modifier = Modifier
                .fillMaxSize())
        {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            painter = painterResource(id = R.drawable.wall),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            alpha = DefaultAlpha)
            LazyColumn(
                modifier = modifier
                    .background(Blur2)
                    .fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    header?.invoke()
                    charge?.invoke()
                    selection?.invoke()
                    status?.invoke()
                }
            }
        }
    }

@Composable
private fun SectionRow(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = DIMENS_20dp)
    ) {
        Row(
            modifier = modifier
                .height(IntrinsicSize.Max)
        ) {
            LeftSection(modifier = Modifier.weight(0.5f))
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                RightColumn(modifier = Modifier.weight(0.5f))
                Spacer(modifier = Modifier.height(16.dp))
                RightColumn2(modifier = Modifier.weight(0.5f))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        ButtonWithIconExample{}
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = modifier
                .height(IntrinsicSize.Max)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                LeftSection2(modifier = Modifier.weight(0.5f))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                RoundedCornerButtonExample { }
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .align(Alignment.CenterHorizontally),
                ) {
                    Text(
                        text = "buttons",
                        style = LocalTextStyle.current.copy(
                            color = MDark,
                            fontFamily = GilroyFontFamily,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    TextButton(
                        onClick = {})
                    {
                        Text(
                            text = "text-button",
                            style = LocalTextStyle.current.copy(
                                color = Color.White,
                                fontFamily = GilroyFontFamily,
                                fontWeight = FontWeight.Black,
                                fontSize = 20.sp
                            )
                        )
                    }
                }
            }
        }
}
}

@Composable
private fun RightColumn2(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier

            .background(Blur2,
                RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            ElevatedButtonExample{}
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButtonExample{}
        }
    }
}
@Composable
private fun LeftSection2(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(MSecond, RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .padding(DIMENS_8dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .height(DIMENS_130dp)
                .align(Alignment.CenterHorizontally)
                .clip(
                    RoundedCornerShape(DIMENS_8dp)),
            painter = painterResource(id = R.drawable.rea),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            alpha = DefaultAlpha
        )
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(DIMENS_10dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween)
        {
            TextButton(
                onClick = { }
            ) {
                Text(
                    text = "click",
                    style = LocalTextStyle.current.copy(
                        color = wheat,
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Black,
                        fontSize = TEXT_SIZE_18sp
                    )
                )
            }
        }
    }
}

@Composable
private fun RightColumn(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(MSecond, RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .padding(16.dp))
    {
        Spacer(modifier = Modifier.height(20.dp))
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButtonExample { }
            Column(
                modifier = Modifier
                    .height(DIMENS_108dp)
                    .width(DIMENS_108dp)
                    .padding(DIMENS_20dp)
                    .clickable(onClick = {})
                    .clip(RoundedCornerShape(DIMENS_16dp))
                    .border(DIMENS_1dp, Ros,RoundedCornerShape(DIMENS_16dp))
                    .background(Ros),

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(0.dp))
                Text(
                    text = "click",
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = wheat,
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.SemiBold))
                Spacer(modifier = Modifier.height(0.dp))
                Icon(
                    modifier = Modifier
                        .size(DIMENS_12dp)
                        .clickable {
                            //  navController.navigate(Screen.Settings.route)
                        },
                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                    contentDescription = "arrow_right",
                    tint = wheat
                )
            }
        }
    }
}

@Composable
private fun LeftSection(
    modifier: Modifier = Modifier
) {
    var selected by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .background(MSecond, RoundedCornerShape(16.dp))
            .width(IntrinsicSize.Max)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .height(32.dp)
        )
        Text(
            text = "Buttons",
            textAlign = TextAlign.Center,
            style = LocalTextStyle.current.copy(
                color = wheat,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Black,
                fontSize = 24.sp
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        FilledButtonExample { }
        Spacer(modifier = Modifier.height(16.dp))
        FilledTonalButtonExample { }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButtonExample { }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = "Switch",
                style = LocalTextStyle.current.copy(
                    color = MDark,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier.weight(1f)
            )
            CheckBoxComponent(selected = selected, onValueChange = {
                selected = it
            })
        }
        Spacer(modifier = Modifier.height(16.dp))
        CustomFilledButtonExample { }
        Spacer(modifier = Modifier.height(32.dp))

    }
}

@Composable
private fun CheckBoxComponent(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onValueChange: (Boolean) -> Unit
) {
    Box(
        modifier = modifier
            .background(
                if (selected) Brush.horizontalGradient(
                    listOf(
                        Color(0xFF9F18A4),
                        Color(0xFFF828A2),
                        Color(0xFFFD7803)
                    )
                ) else Brush.horizontalGradient(
                    listOf(
                        MSecond,
                        MDark.copy(alpha = 0.66f)
                    )
                ),
                CircleShape
            )
            .width(DIMENS_48dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { onValueChange(!selected) },
            ), contentAlignment = if (selected) Alignment.TopEnd else Alignment.TopStart
    ) {
        Spacer(
            modifier = Modifier
                .size(DIMENS_24dp)
                .background(
                    brush = Brush.radialGradient(
                        listOf(
                            Color(0xFF020003),
                            MDark)),
                    CircleShape)
        )
    }
}

@Composable
private fun SelectionRow() {
    val list = listOf("Filled", " FilledTonal", "Outlined", "CustomFilled")
    var selected by remember { mutableIntStateOf(0) }
    Row(
        modifier = Modifier
            .padding(top = DIMENS_20dp)
            .height(60.dp)
    ) {
        list.forEachIndexed { index, s ->
            SelectionComponent(
                selected = index == selected,
                title = s,
                index = index,
                onValueChange = {
                    selected = it
                })
        }
    }
}

@Composable
private fun SelectionComponent(
    modifier: Modifier = Modifier,
    selected: Boolean,
    title: String,
    index: Int,
    onValueChange: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(end = DIMENS_16dp)
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null,
                onClick = { onValueChange(index) }
            )
    ) {
        Text(
            text = title, style = LocalTextStyle.current.copy(
                color = if (selected) wheat else Color(0XFF858a8a),
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )
        AnimatedVisibility(visible = selected) {
            HorizontalDivider(
                thickness = DIMENS_4dp,
                modifier = Modifier
                    .padding(DIMENS_1dp)
                    .width(DIMENS_64dp)
                    .clip(CircleShape),
                color = Ros
            )
        }
    }
}

@Composable
fun FilledButtonExample(onClick: () -> Unit) {
    Button(
        colors = ButtonDefaults.buttonColors(Ros),
        onClick = { onClick() }) {
        Text(
            text = "Filled Button",
            textAlign = TextAlign.Center,
            style = LocalTextStyle.current.copy(
                color = wheat,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}
@Composable
fun FilledTonalButtonExample(onClick: () -> Unit) {
    FilledTonalButton(
        onClick = { onClick() })
    {
        Text(
            text = "Tonal Button",
            textAlign = TextAlign.Center,
            style = LocalTextStyle.current.copy(
                color = MSecond,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Composable
fun OutlinedButtonExample(onClick: () -> Unit) {
    OutlinedButton(onClick = { onClick() }) {
        Text(
            text = "Outlined Button",
            textAlign = TextAlign.Center,
            style = LocalTextStyle.current.copy(
                color = wheat,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun CustomFilledButtonExample(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = MDark)
    ) {
        Text(
            modifier = Modifier,
            text = "Custom background",
            textAlign = TextAlign.Center,
            style = LocalTextStyle.current.copy(
                color = wheat,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Composable
fun TextButtonExample(onClick: () -> Unit) {
    TextButton(
        onClick = { onClick() }
    ) {
        Text(
            text = "Text Button",
            style = LocalTextStyle.current.copy(
                color = wheat,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Black,
                fontSize = 24.sp
            )
        )
    }
}

@Composable
fun ElevatedButtonExample(onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick() }) {
        Text(
            text = "Elevated Button",
            textAlign = TextAlign.Center,
            style = LocalTextStyle.current.copy(
                color = MSecond,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun IconButtonExample(onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center)
    {
        Text(
            text = "IconButton",
            textAlign = TextAlign.Center,
            style = LocalTextStyle.current.copy(
                color = wheat,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier
                .padding(start = 10.dp)
        )
        IconButton(onClick) {
        Icon(Icons.Filled.Share,
            contentDescription = "Share",
            tint = wheat,
            modifier = Modifier.size(20.dp)
        )
        }
    }
}

@Composable
fun ButtonWithIconExample(onClick: () -> Unit) {
    Button(onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(DIMENS_68dp),
        colors = ButtonDefaults.buttonColors(zuzmo)
        )
    {
        Image(
            painterResource(id = R.drawable.baseline_bubble_chart_24),
            contentDescription ="chart_icon",
            modifier = Modifier
                .size(20.dp))
        Text(
            text = "Button with icon",
            style = LocalTextStyle.current.copy(
                color = MSecond,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier
                .padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun RoundedCornerButtonExample(onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .height(DIMENS_68dp),
        colors = ButtonDefaults.buttonColors(wheat),
        onClick = { onClick() },
        shape = RoundedCornerShape(90.dp)
    ) {
        Text(
            text = "Round corner shape button",
            textAlign = TextAlign.Center,
            style = LocalTextStyle.current.copy(
                color = MSecond,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold))
    }
}


@Composable
private fun HeaderRow()
{
    Column {
    Row {
        Row(modifier = Modifier.weight(1f)) {
            Card(
                border = BorderStroke(2.dp, color = Black.copy(0.66f)),
                shape = RoundedCornerShape(50.dp))
            {
                Image(
                    modifier = Modifier
                        .height(DIMENS_80dp)
                        .width(DIMENS_80dp),
                    painter = painterResource(id = R.drawable.bg_b),
                    contentScale = ContentScale.Crop,
                    contentDescription = "image")
            }
            Column(
                modifier = Modifier
                    .padding(start = DIMENS_16dp)
                    .align(Alignment.CenterVertically),
            ) {
                Text(
                    text = "buttons",
                    style = LocalTextStyle.current.copy(
                        color = MDark,
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.SemiBold)
                )
                Text(
                    text = "pre-defined composable",
                    style = LocalTextStyle.current.copy(
                        color = Color.White,
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Black,
                        fontSize = 24.sp)
                )
            }
        }
        Box(
            modifier = Modifier
                .background(color = Color.Transparent, CircleShape)
                .border(
                    5.dp, wheat,
                    CircleShape)
                .align(Alignment.CenterVertically)
        ) {
            Box(
                modifier = Modifier
                    .border(4.dp, wheat, CircleShape)
                    .background(
                        brush = Brush.linearGradient(listOf(wheat, wheat.copy(0.66f))), CircleShape)
                    .padding(18.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(modifier = Modifier
                    .size(DIMENS_20dp)
                    .clickable {},
                    imageVector = Icons.Default.Settings,
                    contentDescription = "arrow_right",
                    tint = MSecond)
            }
        }
    } }
}
