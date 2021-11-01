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
import com.belajar.foodmarket.presentasion.component.ProfileImage
import com.belajar.foodmarket.presentasion.component.TopSection

@Composable
fun SignUp(navController: NavController) {
    Scaffold(
        topBar = {
            TopSection(
                title = stringResource(id = R.string.sign_up),
                subtitle = stringResource(id = R.string.subtitle_sign_up),
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
            var name by rememberSaveable { mutableStateOf("") }
            var email by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }

            ProfileImage(modifier = Modifier.fillMaxWidth(), image = null)
            Spacer(modifier = Modifier.height(15.dp))

            // Text field full name
            OutlinedTextFieldCustom(
                text = stringResource(id = R.string.full_name),
                placeholder = stringResource(id = R.string.placeholder_full_name),
                textState = name,
                keyboardType = KeyboardType.Text,
                onValueChange = { name = it },
                onClearClick = { name = "" },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))

            // Text field email
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

            // Text field password
            OutlinedTextFieldCustom(
                text = stringResource(id = R.string.password),
                placeholder = stringResource(id = R.string.placeholder_password),
                textState = password,
                keyboardType = KeyboardType.Password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Button continue
            ButtonCustom(
                text = stringResource(id = R.string.btn_continue),
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate(Screen.SignUpAddress.route) }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewSignIn() {
    SignUp(navController = rememberNavController())
}