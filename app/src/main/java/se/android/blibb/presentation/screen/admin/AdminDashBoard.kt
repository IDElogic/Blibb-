package se.android.blibb.presentation.screen.admin

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import se.android.blibb.R
import se.android.blibb.navigation.screen.Screen
import se.android.blibb.presentation.component.NeuButton
import se.android.blibb.presentation.screen.auth.data.User
import se.android.blibb.presentation.screen.auth.data.UserListItem
import se.android.blibb.presentation.screen.auth.navigation.AuthScreen
import se.android.blibb.presentation.screen.auth.registration.UserViewModel
import se.android.blibb.ui.theme.Black
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_2dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_4dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.TEXT_SIZE_16sp
import se.android.blibb.ui.theme.TEXT_SIZE_18sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat
import se.android.blibb.ui.theme.zuzmo

@Composable
fun AdminDashboard(userViewModel: UserViewModel, navController: NavController) {

    var users by remember { mutableStateOf<List<User>>(emptyList()) }

    LaunchedEffect(Unit) {
        users = userViewModel.getAllUsers()
    }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(wheat)
                    .padding(paddingValues),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(DIMENS_32dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //header
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column {
                            NeuButton(
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .height(180.dp)
                                    .padding(bottom = 5.dp, end = DIMENS_2dp, start = 0.dp)
                                    .border(1.dp, wheat, RoundedCornerShape(20.dp)),
                                lightColor = Ros,
                                onClick = {
                                }
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                )
                                {
                                    Text(
                                        text = "Admin Dashboard",
                                        color = Black,
                                        fontFamily = GilroyFontFamily,
                                        fontSize = TEXT_SIZE_16sp,
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = TEXT_SIZE_1sp
                                    )
                                    Spacer(modifier = Modifier.height(DIMENS_8dp))
                                    Box {
                                        Image(
                                            painter = painterResource(id = R.drawable.bg_b),
                                            contentDescription = "profile picture",
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .size(60.dp, 60.dp)
                                                .border(1.dp, wheat, RoundedCornerShape(50.dp))
                                                .clip(RoundedCornerShape(50.dp))
                                        )
                                    }
                                }
                            }

                            NeuButton(
                                shape = RoundedCornerShape(90.dp),
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .height(80.dp)
                                    .padding(bottom = 5.dp, end = DIMENS_2dp, start = 0.dp)
                                    .border(1.dp, MSecond, RoundedCornerShape(90.dp)),
                                lightColor = MSecond,
                                onClick = {
                                }
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Text",
                                        color = wheat,
                                        fontFamily = GilroyFontFamily,
                                        fontSize = TEXT_SIZE_12sp,
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = TEXT_SIZE_1sp
                                    )
                                    Icon(
                                        modifier = Modifier
                                            .size(DIMENS_20dp),
                                        imageVector = Icons.Default.ArrowDropDown,
                                        contentDescription = "arrow_right",
                                        tint = wheat
                                    )
                                }
                            }
                        }
                        Column {
                            NeuButton(
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp)
                                    .padding(bottom = 5.dp, end = 0.dp, start = DIMENS_2dp)
                                    .border(1.dp, Black, RoundedCornerShape(20.dp)),
                                lightColor = Black,
                                onClick = {
                                }
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                )
                                {
                                    Spacer(modifier = Modifier.height(DIMENS_8dp))
                                    NeuButton(
                                        shape = RoundedCornerShape(90.dp),
                                        modifier = Modifier
                                            .fillMaxWidth(0.4f)
                                            .height(70.dp)
                                            .padding(0.dp)
                                            .border(1.dp, zuzmo, RoundedCornerShape(90.dp)),
                                        lightColor = zuzmo,
                                        onClick = {
                                        }
                                    ) {
                                        Icon(
                                            modifier = Modifier
                                                .size(DIMENS_20dp),
                                            imageVector = Icons.Default.Person,
                                            contentDescription = "arrow_right",
                                            tint = MDark
                                        )

                                    }
                                    Spacer(modifier = Modifier.height(DIMENS_16dp))
                                    Text(
                                        text = "Text",
                                        color = wheat,
                                        fontFamily = GilroyFontFamily,
                                        fontSize = TEXT_SIZE_18sp,
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = TEXT_SIZE_1sp
                                    )
                                }
                            }
                            NeuButton(
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(80.dp)
                                    .padding(bottom = 5.dp, end = 0.dp, start = 0.dp)
                                    .border(1.dp, wheat, RoundedCornerShape(20.dp)),
                                lightColor = wheat,
                                onClick = {

                                }
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Text",
                                        color = wheat,
                                        fontFamily = GilroyFontFamily,
                                        fontSize = TEXT_SIZE_12sp,
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = TEXT_SIZE_1sp
                                    )
                                    LazyColumn {

                                        items(users) { user ->
                                            UserListItem(user)
                                        }
                                    }
                                }
                            }
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        NeuButton(
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .height(80.dp)
                                .padding(bottom = 5.dp, end = DIMENS_2dp, start = 0.dp)
                                .border(1.dp, MDark, RoundedCornerShape(20.dp)),
                            lightColor = MDark,
                            onClick = {
                            }
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Text",
                                    color = Black,
                                    fontFamily = GilroyFontFamily,
                                    fontSize = TEXT_SIZE_12sp,
                                    fontWeight = FontWeight.Medium,
                                    letterSpacing = TEXT_SIZE_1sp
                                )
                                Icon(
                                    modifier = Modifier
                                        .size(DIMENS_20dp),
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "arrow_right",
                                    tint = Black
                                )
                            }
                        }
                        NeuButton(
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .padding(bottom = 5.dp, start = DIMENS_2dp, end = 0.dp)
                                .border(1.dp, wheat, RoundedCornerShape(20.dp)),
                            lightColor = wheat,
                            onClick = {
                            }
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Text",
                                    color = Black,
                                    fontFamily = GilroyFontFamily,
                                    fontSize = TEXT_SIZE_12sp,
                                    fontWeight = FontWeight.Medium,
                                    letterSpacing = TEXT_SIZE_1sp
                                )
                                Icon(
                                    modifier = Modifier
                                        .size(DIMENS_20dp),
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "arrow_right",
                                    tint = Black
                                )
                            }
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        NeuButton(
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .height(80.dp)
                                .padding(bottom = 5.dp, end = DIMENS_2dp, start = 0.dp)
                                .border(1.dp, wheat, RoundedCornerShape(20.dp)),
                            lightColor = wheat,
                            onClick = {
                            }
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Text",
                                    color = wheat,
                                    fontFamily = GilroyFontFamily,
                                    fontSize = TEXT_SIZE_12sp,
                                    fontWeight = FontWeight.Medium,
                                    letterSpacing = TEXT_SIZE_1sp
                                )
                                Icon(
                                    modifier = Modifier
                                        .size(DIMENS_20dp),
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "arrow_right",
                                    tint = wheat
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            NeuButton(
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .height(80.dp)
                                    .padding(bottom = 5.dp, start = DIMENS_2dp, end = 0.dp)
                                    .border(1.dp, wheat, RoundedCornerShape(20.dp)),
                                lightColor = wheat,
                                onClick = {
                                }
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Text",
                                        color = wheat,
                                        fontFamily = GilroyFontFamily,
                                        fontSize = TEXT_SIZE_12sp,
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = TEXT_SIZE_1sp
                                    )
                                    Icon(
                                        modifier = Modifier
                                            .size(DIMENS_20dp),
                                        imageVector = Icons.Default.ArrowDropDown,
                                        contentDescription = "arrow_right",
                                        tint = wheat
                                    )
                                }
                            }
                            NeuButton(
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(80.dp)
                                    .padding(bottom = 5.dp, start = DIMENS_2dp, end = 0.dp)
                                    .border(1.dp, MDark, RoundedCornerShape(20.dp)),
                                lightColor = MDark,
                                onClick = {
                                }
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Text",
                                        color = Black,
                                        fontFamily = GilroyFontFamily,
                                        fontSize = TEXT_SIZE_12sp,
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = TEXT_SIZE_1sp
                                    )
                                    Icon(
                                        modifier = Modifier
                                            .size(DIMENS_20dp),
                                        imageVector = Icons.Default.ArrowDropDown,
                                        contentDescription = "arrow_right",
                                        tint = Black
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                        ) {
                            NeuButton(
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(80.dp)
                                    .padding(bottom = 5.dp, start = DIMENS_2dp, end = 0.dp)
                                    .border(1.dp, wheat, RoundedCornerShape(20.dp)),
                                lightColor = wheat,
                                onClick = {

                                }
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Text",
                                        color = Black,
                                        fontFamily = GilroyFontFamily,
                                        fontSize = TEXT_SIZE_12sp,
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = TEXT_SIZE_1sp
                                    )
                                    Icon(
                                        modifier = Modifier
                                            .size(DIMENS_20dp),
                                        imageVector = Icons.Default.ArrowDropDown,
                                        contentDescription = "arrow_right",
                                        tint = Black
                                    )
                                }
                            }

                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                NeuButton(
                                    shape = RoundedCornerShape(20.dp),
                                    modifier = Modifier
                                        .fillMaxWidth(0.5f)
                                        .height(80.dp)
                                        .padding(bottom = 5.dp, start = DIMENS_2dp, end = 0.dp)
                                        .border(1.dp, zuzmo, RoundedCornerShape(20.dp)),
                                    lightColor = zuzmo,
                                    onClick = {

                                    }
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "Text",
                                            color = Black,
                                            fontFamily = GilroyFontFamily,
                                            fontSize = TEXT_SIZE_12sp,
                                            fontWeight = FontWeight.Medium,
                                            letterSpacing = TEXT_SIZE_1sp
                                        )
                                        Icon(
                                            modifier = Modifier
                                                .size(DIMENS_20dp),
                                            imageVector = Icons.Default.ArrowDropDown,
                                            contentDescription = "arrow_right",
                                            tint = Black
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.width(DIMENS_2dp))
                                NeuButton(
                                    shape = RoundedCornerShape(20.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(80.dp)
                                        .padding(bottom = 5.dp, start = DIMENS_2dp, end = 0.dp)
                                        .border(1.dp, zuzmo, RoundedCornerShape(20.dp)),
                                    lightColor = zuzmo,
                                    onClick = {

                                    }
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "Text",
                                            color = Black,
                                            fontFamily = GilroyFontFamily,
                                            fontSize = TEXT_SIZE_12sp,
                                            fontWeight = FontWeight.Medium,
                                            letterSpacing = TEXT_SIZE_1sp
                                        )
                                        Icon(
                                            modifier = Modifier
                                                .size(DIMENS_20dp),
                                            imageVector = Icons.Default.ArrowDropDown,
                                            contentDescription = "arrow_right",
                                            tint = Black
                                        )
                                    }
                                }
                            }
                        }
                    }

                    //recipes
                    NeuButton(
                        shape = RoundedCornerShape(90.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(bottom = 5.dp, end = 0.dp, start = 0.dp)
                            .border(1.dp, MSecond, RoundedCornerShape(90.dp)),
                        lightColor = MSecond,
                        onClick = {}
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(DIMENS_20dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(0.5f),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Text",
                                    color = wheat,
                                    fontFamily = GilroyFontFamily,
                                    fontSize = TEXT_SIZE_12sp,
                                    fontWeight = FontWeight.Medium,
                                    letterSpacing = TEXT_SIZE_1sp
                                )
                                Icon(
                                    modifier = Modifier
                                        .size(DIMENS_20dp),
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "arrow_right",
                                    tint = wheat
                                )
                            }

                            NeuButton(
                                shape = RoundedCornerShape(90.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .padding(start = DIMENS_20dp)
                                    .border(1.dp, zuzmo, RoundedCornerShape(90.dp)),
                                lightColor = zuzmo,
                                onClick = {
                                    userViewModel.logout()
                                    navController.navigate(AuthScreen.Login.route) {
                                        popUpTo(AuthScreen.Main.route) { inclusive = true }
                                    }
                                }
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Text",
                                        color = MSecond,
                                        fontFamily = GilroyFontFamily,
                                        fontSize = TEXT_SIZE_12sp,
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = TEXT_SIZE_1sp
                                    )
                                    Spacer(modifier = Modifier.height(DIMENS_2dp))
                                    Icon(
                                        modifier = Modifier
                                            .size(DIMENS_20dp),
                                        imageVector = Icons.Default.ArrowDropDown,
                                        contentDescription = "arrow_right",
                                        tint = MSecond
                                    )
                                }
                            }
                        }
                    }

                    //settings etc.
                    NeuButton(
                        shape = RoundedCornerShape(90.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(bottom = 5.dp, end = 0.dp, start = 0.dp)
                            .border(1.dp, MSecond, RoundedCornerShape(90.dp)),
                        lightColor = MSecond,
                        onClick = {

                        }
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(DIMENS_20dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            NeuButton(
                                shape = RoundedCornerShape(90.dp),
                                modifier = Modifier
                                    .fillMaxWidth(0.2f)
                                    .height(60.dp)
                                    .padding(start = DIMENS_4dp)
                                    .border(1.dp, Ros, RoundedCornerShape(90.dp)),
                                lightColor = Ros,
                                onClick = {
                                }
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(DIMENS_20dp),
                                    imageVector = Icons.Default.Settings,
                                    contentDescription = "arrow_right",
                                    tint = Black
                                )
                            }
                            NeuButton(
                                shape = RoundedCornerShape(90.dp),
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .height(60.dp)
                                    .padding(start = DIMENS_20dp)
                                    .border(1.dp, wheat, RoundedCornerShape(90.dp)),
                                lightColor = wheat,
                                onClick = {
                                }
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "Text",
                                        color = wheat,
                                        fontFamily = GilroyFontFamily,
                                        fontSize = TEXT_SIZE_12sp,
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = TEXT_SIZE_1sp
                                    )
                                }
                            }
                            NeuButton(
                                shape = RoundedCornerShape(90.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .padding(start = DIMENS_20dp)
                                    .border(1.dp, zuzmo, RoundedCornerShape(90.dp))
                                    .clickable(
                                        enabled = true,
                                        onClick = {
                                            userViewModel.logout()
                                            navController.navigate(AuthScreen.Login.route) {
                                                popUpTo(AuthScreen.Main.route) { inclusive = true }
                                            }
                                        }
                                    ),
                                lightColor = zuzmo,
                                onClick = {
                                    userViewModel.logout()
                                    navController.navigate(AuthScreen.Login.route) {
                                        popUpTo(AuthScreen.Main.route) { inclusive = true }
                                    }
                                }
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(DIMENS_20dp),
                                    imageVector = Icons.Default.Home,
                                    contentDescription = "arrow_right",
                                    tint = Black
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
