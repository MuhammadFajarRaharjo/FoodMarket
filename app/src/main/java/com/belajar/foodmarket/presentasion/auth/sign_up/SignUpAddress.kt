package com.belajar.foodmarket.presentasion.auth.sign_up

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belajar.foodmarket.R
import com.belajar.foodmarket.presentasion.Screen
import com.belajar.foodmarket.presentasion.component.ButtonCustom
import com.belajar.foodmarket.presentasion.component.OutlinedTextFieldCustom
import com.belajar.foodmarket.presentasion.component.TopSection

@Composable
fun SignUpAddress(navController: NavController) {
    Scaffold(
        topBar = {
            TopSection(
                title = stringResource(id = R.string.address),
                subtitle = stringResource(id = R.string.subtitle_address),
                icon = Icons.Default.ArrowBackIos,
                onClick = { navController.navigateUp() }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxSize()
                .background(MaterialTheme.colors.onPrimary)
                .padding(24.dp)
        ) {
            var phone by rememberSaveable { mutableStateOf("") }
            var address by rememberSaveable { mutableStateOf("") }
            var houseNumber by rememberSaveable { mutableStateOf("") }
            var city by rememberSaveable { mutableStateOf("") }

            // Text field full phone
            OutlinedTextFieldCustom(
                text = stringResource(id = R.string.phone_number),
                placeholder = stringResource(id = R.string.placeholder_phone_number),
                textState = phone,
                keyboardType = KeyboardType.Phone,
                onValueChange = { phone = it },
                onClearClick = { phone = "" },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))

            // Text field full address
            OutlinedTextFieldCustom(
                text = stringResource(id = R.string.address),
                placeholder = stringResource(id = R.string.placeholder_address),
                textState = address,
                onValueChange = { address = it },
                onClearClick = { address = "" },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))

            // Text field houseNumber
            OutlinedTextFieldCustom(
                text = stringResource(id = R.string.house_number),
                placeholder = stringResource(id = R.string.placeholder_house_number),
                textState = houseNumber,
                onValueChange = { houseNumber = it },
                onClearClick = { houseNumber = "" },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))

            // Text field city
            OutlinedTextFieldCustom(
                text = stringResource(id = R.string.city),
                placeholder = stringResource(id = R.string.placeholder_city),
                textState = city,
                onValueChange = { city = it },
                onClearClick = { city = "" },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Button continue
            ButtonCustom(
                text = stringResource(id = R.string.sign_up_now),
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate(Screen.SignUpSuccess.route) }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewSignUpAddress() {
    SignUpAddress(rememberNavController())
}