package se.android.blibb.presentation.screen.cards_buttons

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import se.android.blibb.R
import se.android.blibb.navigation.screen.Screen
import se.android.blibb.presentation.component.NeuButton
import se.android.blibb.ui.theme.Blur
import se.android.blibb.ui.theme.Blur2
import se.android.blibb.ui.theme.Blur5
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_12dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_2dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_4dp
import se.android.blibb.ui.theme.DIMENS_64dp
import se.android.blibb.ui.theme.DIMENS_80dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat
import se.android.blibb.ui.theme.zuzmo

@Composable
fun DialogScreen(modifier: Modifier = Modifier,
                 navController: NavController)
{
    val showAlertDialog = remember { mutableStateOf(false) }
    val showCustomDialog = remember { mutableStateOf(false) }
    val datePickerDialog = remember { mutableStateOf(false) }
    val bottomSheetDialog = remember { mutableStateOf(false) }

    Scaffold ()
    { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Blur2)
                    .padding(paddingValues),
            ) {
                val imageModifier = Modifier
                    .fillMaxSize()
                    .shadow(elevation = DIMENS_32dp)
                    .blur(0.dp)
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.wall),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    alpha = DefaultAlpha
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = DIMENS_20dp , end = DIMENS_20dp, top = DIMENS_64dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = DIMENS_20dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    NeuButton(
                        shape = RoundedCornerShape(90.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .border(1.dp, zuzmo, RoundedCornerShape(90.dp))
                            .clickable(
                                enabled = true,
                                onClick = {}
                            ),
                        lightColor = zuzmo,
                        onClick = {}
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = DIMENS_20dp),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                        Text(
                            text = "Card | Button | Dialog",
                            style = MaterialTheme.typography.labelLarge.copy(
                                color = MSecond,
                                fontFamily = GilroyFontFamily,
                                fontWeight = FontWeight.SemiBold
                            )
                        )

                        Icon(
                            modifier = Modifier
                                .size(DIMENS_20dp)
                                .clickable {
                                    navController.navigate(Screen.Settings.route)
                                },
                            imageVector = Icons.Default.Settings,
                            contentDescription = "settings",
                            tint = MSecond
                        ) }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = DIMENS_20dp, vertical = DIMENS_8dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        colors = CardDefaults.cardColors(Blur5),
                        shape = RoundedCornerShape(90.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                            .border(2.dp, Ros, RoundedCornerShape(90.dp))
                            .clickable(
                                enabled = true,
                                onClick = { bottomSheetDialog.value = true })
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Bottom Sheet Dialog",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = wheat,
                                    fontFamily = GilroyFontFamily,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }
                    }
                }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = DIMENS_20dp, vertical = DIMENS_8dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        NeuButton(
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .fillMaxWidth(0.55f)
                                .height(140.dp)
                                .border(1.dp, MSecond, RoundedCornerShape(20.dp))
                                .clickable(
                                    enabled = true,
                                    onClick = { showAlertDialog.value = true }
                                ),
                            lightColor = MSecond,
                            onClick = { showAlertDialog.value = true })
                        {
                            Row() {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .padding(top = DIMENS_64dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally)
                            {
                                Text(
                                    text = "Alert Dialog",
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = wheat,
                                        fontFamily = GilroyFontFamily,
                                        fontWeight = FontWeight.Medium
                                    )
                                )
                                Spacer(modifier = Modifier.height(DIMENS_2dp))
                                Icon(
                                    modifier = Modifier
                                        .size(DIMENS_20dp)
                                        .clickable {
                                            navController.navigate("button_screen")
                                        },
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "arrow_right",
                                    tint = wheat
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(DIMENS_10dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            )
                            {
                                Card(
                                    shape = RoundedCornerShape(20.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .border(1.dp, wheat, RoundedCornerShape(20.dp))
                                        .clickable(
                                            enabled = true,
                                            onClick = { showAlertDialog.value = true })
                                )
                                {
                                    val imageModifier = Modifier
                                        .fillMaxSize()
                                        .shadow(elevation = DIMENS_32dp)
                                    Image(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .align(Alignment.CenterHorizontally),
                                        painter = painterResource(id = R.drawable.wall),
                                        contentDescription = "image",
                                        contentScale = ContentScale.Crop,
                                        alpha = DefaultAlpha
                                    )
                                }
                            }
                        }
                        }
                        Spacer(modifier = Modifier.width(DIMENS_10dp))
                        NeuButton(
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(140.dp)
                                .border(1.dp, wheat, RoundedCornerShape(20.dp))
                                .clickable(
                                    enabled = true,
                                    onClick = { showAlertDialog.value = true }
                                ),
                            lightColor = wheat,
                            onClick = { showAlertDialog.value = true })
                        {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(DIMENS_20dp),
                                verticalArrangement = Arrangement.Bottom,
                                horizontalAlignment = Alignment.CenterHorizontally)
                            {
                                Text(
                                    text = "Button in the card",
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = MSecond,
                                        fontFamily = GilroyFontFamily,
                                        fontWeight = FontWeight.Medium
                                    )
                                )
                                Image(
                                    colorFilter = ColorFilter.tint(MSecond),
                                    painter = painterResource(id = R.drawable.baseline_keyboard_double_arrow_down_24),
                                    contentDescription = "attached-file",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .padding(0.dp)
                                        .size(DIMENS_20dp),
                                )

                                Spacer(modifier = Modifier.height(4.dp))
                                OutlinedButton(
                                    onClick = { navController.navigate("button_screen") })
                                {
                                    Row {
                                        Text(
                                            text = "Buttons",
                                            style = MaterialTheme.typography.bodySmall.copy(
                                                color = MDark,
                                                fontFamily = GilroyFontFamily,
                                                fontWeight = FontWeight.Medium
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = DIMENS_20dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize())
                    {
                        Spacer(modifier = Modifier.height(8.dp))
                        Row {
                        Card(
                            colors = CardDefaults.cardColors(Blur),
                            shape = RoundedCornerShape(DIMENS_20dp),
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .height(248.dp)
                                .border(2.dp,wheat, RoundedCornerShape(20.dp))
                                .clickable(
                                    enabled = true,
                                    onClick = {  }
                                ),
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(DIMENS_20dp),
                                verticalArrangement = Arrangement.Bottom,
                                horizontalAlignment = Alignment.CenterHorizontally)
                            {
                                Text(
                                    text = "blur",
                                    color = MDark,
                                    fontFamily = GilroyFontFamily,
                                    fontSize = 48.sp,
                                    fontWeight = FontWeight.Medium,
                                    letterSpacing = TEXT_SIZE_1sp,
                                    modifier = Modifier
                                        .padding(top = DIMENS_10dp, bottom = DIMENS_80dp)
                                        .padding(horizontal = DIMENS_12dp)
                                        .blur(DIMENS_4dp, BlurredEdgeTreatment.Unbounded)
                                )
                                Spacer(modifier = Modifier.height(DIMENS_10dp))
                                Text(
                                    text = "DatePicker Dialog",
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = MSecond,
                                        fontFamily = GilroyFontFamily,
                                        fontWeight = FontWeight.Medium
                                    )
                                )
                                Spacer(modifier = Modifier.height(DIMENS_2dp))
                                Icon(modifier = Modifier
                                    .size(DIMENS_20dp)
                                    .clickable{
                                        datePickerDialog.value = true
                                    },
                                    imageVector = Icons.Default.DateRange,
                                    contentDescription = "arrow_right",
                                    tint = MSecond
                                )
                            }
                        }
                            Spacer(modifier = Modifier.width(DIMENS_10dp))
                            NeuButton(
                                shape = RoundedCornerShape(DIMENS_20dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(248.dp)
                                    .border(1.dp,wheat, RoundedCornerShape(20.dp)),
                                lightColor = wheat,
                                onClick = {  })
                             {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(horizontal = DIMENS_20dp, vertical = DIMENS_10dp),
                                    verticalArrangement = Arrangement.Bottom,
                                    horizontalAlignment = Alignment.CenterHorizontally)
                                {
                                    NeuButton(
                                        shape = RoundedCornerShape(90.dp),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(60.dp)
                                            .border(1.dp, Ros, RoundedCornerShape(90.dp)),
                                        lightColor = Ros,
                                        onClick = { navController.navigate("image_screen") }
                                    ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = DIMENS_4dp),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "Images",
                                            style = MaterialTheme.typography.bodySmall.copy(
                                                color = wheat,
                                                fontFamily = GilroyFontFamily,
                                                fontWeight = FontWeight.Medium
                                            )
                                        )
                                        Spacer(modifier = Modifier.width(DIMENS_2dp))
                                        Image(
                                            colorFilter = ColorFilter.tint(wheat),
                                            painter = painterResource(id = R.drawable.baseline_crop_original_24),
                                            contentDescription = "attached-file",
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .padding(0.dp)
                                                .size(DIMENS_20dp),
                                        )
                                    }
                                }
                                    Image(
                                        colorFilter = ColorFilter.tint(MSecond),
                                        painter = painterResource(id = R.drawable.baseline_keyboard_double_arrow_up_24),
                                        contentDescription = "attached-file",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .padding(0.dp)
                                            .size(DIMENS_20dp),
                                    )
                                    Spacer(modifier = Modifier.height(DIMENS_2dp))
                                    Text(
                                        text = "Card in the card",
                                        style = MaterialTheme.typography.bodySmall.copy(
                                            color = MSecond,
                                            fontFamily = GilroyFontFamily,
                                            fontWeight = FontWeight.Medium
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(DIMENS_2dp))
                                    Image(
                                        colorFilter = ColorFilter.tint(MSecond),
                                        painter = painterResource(id = R.drawable.baseline_keyboard_double_arrow_down_24),
                                        contentDescription = "attached-file",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .padding(0.dp)
                                            .size(DIMENS_20dp),
                                    )

                                    Spacer(modifier = Modifier.height(DIMENS_2dp))
                                    Card(
                                        colors = CardDefaults.cardColors(MDark),
                                        shape = CircleShape,
                                        modifier = Modifier
                                            .width(100.dp)
                                            .height(100.dp)
                                            .border(1.dp, MDark, RoundedCornerShape(90.dp))
                                            .clickable(
                                                enabled = true,
                                                onClick = { navController.navigate("card_screen") }
                                            ),
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(DIMENS_20dp),
                                            verticalArrangement = Arrangement.Bottom,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        )
                                        {
                                            Text(
                                                text = "Cards",
                                                style = MaterialTheme.typography.bodySmall.copy(
                                                    color = wheat,
                                                    fontFamily = GilroyFontFamily,
                                                    fontWeight = FontWeight.Medium
                                                )
                                            )
                                            Spacer(modifier = Modifier.height(DIMENS_2dp))
                                            Icon(modifier = Modifier
                                                .size(DIMENS_20dp)
                                                .clickable{
                                                    navController.navigate("card_screen")
                                                },
                                                imageVector = Icons.Default.ArrowDropDown,
                                                contentDescription = "arrow_right",
                                                tint = wheat
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        NeuButton(
                            shape = RoundedCornerShape(90.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .border(1.dp, MDark, RoundedCornerShape(90.dp))
                                .clickable(
                                    enabled = true,
                                    onClick = { showCustomDialog.value = true }
                                ),
                            lightColor = MDark,
                            onClick = { showCustomDialog.value = true }
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Custom Dialog",
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = wheat,
                                        fontFamily = GilroyFontFamily,
                                        fontWeight = FontWeight.Medium
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
    }

    if(showAlertDialog.value) {
        AlertDialogExample(showAlertDialog)
    }
    if(showCustomDialog.value) {
        CustomDialogExample(showCustomDialog)
    }
    if(datePickerDialog.value) {
        DatePickerDialogExample(datePickerDialog)
    }
    if(bottomSheetDialog.value) {
        BottomSheetExample(bottomSheetDialog)
    }
}

@Composable
fun AlertDialogExample(showAlertDialog: MutableState<Boolean>) {
    AlertDialog(
        icon = {
            Icon(Icons.Filled.Info, contentDescription = "Info Icon", tint = MaterialTheme.colorScheme.secondaryContainer)
        },
        title = {
            Text(text = "Dialog with info icon")
        },
        text = {
            Text(text = "The Dialog component displays pop up messages or requests user input on a layer above the main app content. It creates an interruptive UI experience to capture user attention.")
        },
        onDismissRequest = { },
        confirmButton = {
            TextButton(
                onClick = { showAlertDialog.value = false }
            ) {
                Text("Confirm", color = MaterialTheme.colorScheme.primary)
            }
        },
        dismissButton = {
            TextButton(
                onClick = { showAlertDialog.value = false }
            ) {
                Text("Dismiss", color = MaterialTheme.colorScheme.primary)
            }
        }
    )
}

@Composable
fun CustomDialogExample(showCustomDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { showCustomDialog.value = false }) {
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp, top = 20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
                    .padding(16.dp)
            ) {
                Icon(Icons.Filled.Info, contentDescription = "Info Icon", tint = MaterialTheme.colorScheme.secondaryContainer)
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Dialog with info icon",
                        style = TextStyle(fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary, fontSize = 18.sp)
                    )
                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        textAlign = TextAlign.Center,
                        text = "This Dialog is an example of a custom dialog with the Dialog Composable"
                    )
                }
                TextButton(
                    onClick = { showCustomDialog.value = false }
                ) {
                    Text("Confirm", color = MaterialTheme.colorScheme.primary)
                }
                TextButton(
                    onClick = { showCustomDialog.value = false }
                ) {
                    Text("Dismiss", color = MaterialTheme.colorScheme.primary)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialogExample(showDatePickerDialog: MutableState<Boolean>) {
    val dateState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = { showDatePickerDialog.value = false },
        confirmButton = {
            TextButton(
                onClick = { showDatePickerDialog.value = false }
            ) {
                Text("Confirm", color = MaterialTheme.colorScheme.primary)
            }
        },
        dismissButton = {
            TextButton(
                onClick = { showDatePickerDialog.value = false }
            ) {
                Text(text = "Cancel", color = MaterialTheme.colorScheme.primary)
            }
        }) {
        DatePicker(
            state = dateState,
            showModeToggle = true
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetExample(showBottomSheet: MutableState<Boolean>) {
    val context = LocalContext.current
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { showBottomSheet.value = false },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        val countries = listOf(
            Pair("United States", "US".toFlagEmoji()),
            Pair("Canada", "CA".toFlagEmoji()),
            Pair("India", "IN".toFlagEmoji()),
            Pair("Germany", "DE".toFlagEmoji()),
            Pair("France", "FR".toFlagEmoji()),
            Pair("Japan", "JP".toFlagEmoji()),
            Pair("China", "CN".toFlagEmoji()),
            Pair("Brazil", "BR".toFlagEmoji()),
            Pair("Australia", "AU".toFlagEmoji()),
            Pair("Russia", "RU".toFlagEmoji()),
            Pair("United Kingdom", "UK".toFlagEmoji()),
            Pair("Belgium", "BE".toFlagEmoji()),
            Pair("Pakistan", "PK".toFlagEmoji()),
        )

        LazyColumn {
            items(countries.size) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 20.dp)
                        .clickable {
                            Toast.makeText(context, countries[it].first+ " Clicked", Toast.LENGTH_SHORT).show()
                            showBottomSheet.value = false
                        }
                ) {
                    Text(
                        text = countries[it].second,
                        modifier = Modifier.padding(end = 20.dp, top = 5.dp, bottom = 5.dp)
                    )
                    Text(text = countries[it].first)
                }
            }
        }
    }
}

private fun String.toFlagEmoji(): String {
    // 1. It first checks if the string consists of only 2 characters: ISO 3166-1 alpha-2 two-letter country codes (https://en.wikipedia.org/wiki/Regional_Indicator_Symbol).
    if (this.length != 2) {
        return this
    }

    val countryCodeCaps =
        this.uppercase() // upper case is important because we are calculating offset
    val firstLetter = Character.codePointAt(countryCodeCaps, 0) - 0x41 + 0x1F1E6
    val secondLetter = Character.codePointAt(countryCodeCaps, 1) - 0x41 + 0x1F1E6

    // 2. It then checks if both characters are alphabet
    if (!countryCodeCaps[0].isLetter() || !countryCodeCaps[1].isLetter()) {
        return this
    }

    return String(Character.toChars(firstLetter)) + String(Character.toChars(secondLetter))
}