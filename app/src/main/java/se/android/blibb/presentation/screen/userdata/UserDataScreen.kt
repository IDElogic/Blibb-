package se.android.blibb.presentation.screen.userdata

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import se.android.blibb.ui.theme.wheat
import se.android.blibb.ui.theme.zuzmo


@Composable
fun UserDataScreen(
    onDataSubmit: (List<UserData>) -> Unit,
    onCancel: () -> Unit
) {
    var userDataList by rememberSaveable { mutableStateOf(listOf<UserData>()) }
    var name by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var city by rememberSaveable { mutableStateOf("") }
    var postalCode by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(wheat)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text ="Please enter your details...",
            style = MaterialTheme.typography.titleSmall
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("name") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("address") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("city") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        OutlinedTextField(
            value = postalCode,
            onValueChange = { postalCode = it },
            label = { Text("postal code") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("e-mail") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Done)
        )
        Row {
            Button(
                colors = ButtonDefaults.buttonColors(zuzmo),
                onClick = {
                    val newUserData = UserData(name, address, city, postalCode, email)
                    userDataList = userDataList + newUserData
                    onDataSubmit(userDataList)
                    // Clear the input fields after adding
                    name = ""
                    address = ""
                    city = ""
                    postalCode = ""
                    email = ""
                }
            ) {
                Text("Add")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                colors = ButtonDefaults.buttonColors(zuzmo.copy(0.66f)),
                onClick = onCancel
            ) {
                Text("Cancel")
            }
        }

        // Display the list of users
        LazyColumn {
            items(userDataList) { userData ->
                UserDataItem(userData)
            }
        }
    }
}
