package com.belajar.foodmarket.presentasion.auth.sign_in

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.belajar.foodmarket.R
import com.belajar.foodmarket.presentasion.Screen
import com.belajar.foodmarket.presentasion.component.ButtonCustom
import com.belajar.foodmarket.presentasion.component.OutlinedTextFieldCustom
import com.belajar.foodmarket.presentasion.component.TopSection
import com.belajar.foodmarket.presentasion.ui.theme.Manatee

@Composable
fun SignIn(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopSection(
                title = stringResource(id = R.string.sign_in),
                subtitle = stringResource(id = R.string.subtitle_sign_in),
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
            var email by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }

            // Text Field Email
            OutlinedTextFieldCustom(
                text = stringResource(id = R.string.email_address),
                placeholder = stringResource(id = R.string.placeholder_email),
                textState = email,
                keyboardType = KeyboardType.Email,
                onValueChange = { email = it },
                onClearClick = { email = "" },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))

            // Text Field Password
            OutlinedTextFieldCustom(
                text = stringResource(id = R.string.password),
                placeholder = stringResource(id = R.string.placeholder_password),
                textState = password,
                keyboardType = KeyboardType.Password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Button Login
            ButtonCustom(
                text = stringResource(id = R.string.sign_in),
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            )
            Spacer(modifier = Modifier.height(12.dp))

            // Button Create new account
            ButtonCustom(
                text = stringResource(id = R.string.create_new_account),
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Manatee,
                textColor = Color.White,
                onClick = { navController.navigate(Screen.SignUp.route) }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewSignIn() {
    SignIn(navController = rememberNavController())
}