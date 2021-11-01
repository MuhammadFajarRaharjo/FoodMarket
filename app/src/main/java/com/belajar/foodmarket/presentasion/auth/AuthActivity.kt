package com.belajar.foodmarket.presentasion.auth

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.belajar.foodmarket.presentasion.Screen
import com.belajar.foodmarket.presentasion.auth.sign_in.SignIn
import com.belajar.foodmarket.presentasion.auth.sign_up.SignUp
import com.belajar.foodmarket.presentasion.auth.sign_up.SignUpAddress
import com.belajar.foodmarket.presentasion.auth.sign_up.SignUpSuccess
import com.belajar.foodmarket.presentasion.ui.theme.FoodMarketTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@ExperimentalPagerApi
class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodMarketTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Screen.SignIn.route) {
                        composable(Screen.SignIn.route) { SignIn(navController) }
                        composable(Screen.SignUp.route) { SignUp(navController) }
                        composable(Screen.SignUpAddress.route) { SignUpAddress(navController) }
                        composable(Screen.SignUpSuccess.route) { SignUpSuccess() }
                    }
                }
            }
        }
    }
}